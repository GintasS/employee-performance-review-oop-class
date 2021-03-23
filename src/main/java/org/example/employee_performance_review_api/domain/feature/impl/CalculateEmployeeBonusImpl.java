package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.CalculateEmployeeBonus;
import org.example.employee_performance_review_api.domain.feature.FindEmployees;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.EntityUtils;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CalculateEmployeeBonusImpl implements CalculateEmployeeBonus {

    @Override
    public double handle(Employee employee) {

        final var employmentTime = employee.getEmploymentTime();
        final var employeeSalary = employee.getYearlySalary();
        final var employeeType = employee.getType();
        final var employeeTeam = employee.getTeam();
        final var employeePerformanceRating = employee.getRating();
        final var employeeYearlyBonuses = employee.getYearlyBonuses();
        var bonus = 0d;

        if (employeeType.equals(EmployeeType.INTERN)) {
            return 0;
        }

        if (isEmployeeValidForBonus(employeeYearlyBonuses, employeeSalary) == false) {
            return 0;
        }

        if (employmentTime < 1) {
            bonus = employeeSalary * 0.5;
        }
        else if (employmentTime >= 1 && employmentTime <= 3) {
            bonus = employeeSalary;
        }
        else {
            bonus = employeeSalary * 1.25;
        }

        if (employeeTeam.equals(Team.SENMANAGE)) {
            bonus *= 2;
        }

        if (employeePerformanceRating.equals(PerformanceRating.EXCEPTIONAL)) {
            bonus += bonus * 0.5;
        }

        return bonus;
    }

    private boolean isEmployeeValidForBonus(List<Double> yearlyBonuses, double salary) {


        // Checks yearlyBonuses in the groups of 5.
        // Will not count groups less than 5 members.

        // 1 2 3 4 5 6 7 8 9 10

        // 1 2 3 4 5
        //   2 3 4 5 6
        //     3 4 5 6 7
        //       4 5 6 7 8
        //         5 6 7 8 9
        //           6 7 8 9 10


        // 1 2 3 4 5 6 7 8 9

        // 1 2 3 4 5
        //   2 3 4 5 6
        //     3 4 5 6 7
        //       4 5 6 7 8
        //         5 6 7 8 9

        for(int i = 0; i < yearlyBonuses.size(); i++) {

            var start = 0 + i;
            var end = start + 5;
            var sumOfBonusesOf5yearsInRow = 0;

            if (yearlyBonuses.size() < 5 || end > yearlyBonuses.size()) {
                break;
            }

            for (int y = start; y < end ; y++) {
                sumOfBonusesOf5yearsInRow += yearlyBonuses.get(y);
            }

            System.out.println("SUM when start: " + start + " end: " + end + " sum: " + sumOfBonusesOf5yearsInRow);

            if (sumOfBonusesOf5yearsInRow > salary * 6) {
                return false;
            }
        }

        return true;
    }

}

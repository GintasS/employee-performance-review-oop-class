package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.CalculateEmployeeBonus;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class CalculateEmployeeBonusImpl implements CalculateEmployeeBonus {

    @Override
    public BigDecimal handle(Employee employee) {

        final var employmentTime = employee.getEmploymentTime();
        final var employeeSalary = employee.getYearlySalary();
        final var employeeType = employee.getType();
        final var employeeTeam = employee.getTeam();
        final var employeePerformanceRating = employee.getRating();
        final var employeeYearlyBonuses = employee.getYearlyBonuses();
        var bonus = new BigDecimal(0);

        if (employeeType.equals(EmployeeType.INTERN)) {
            return new BigDecimal(0);
        }

        if (isEmployeeValidForBonus(employeeYearlyBonuses, employeeSalary) == false) {
            return new BigDecimal(0);
        }

        if (employmentTime < 1) {
            bonus = employeeSalary.multiply(BigDecimal.valueOf(0.5));
        }
        else if (employmentTime <= 3) {
            bonus = employeeSalary;
        }
        else {
            bonus = employeeSalary.multiply(BigDecimal.valueOf(1.25));
        }

        if (employeeTeam.equals(Team.SENMANAGE)) {
            bonus = bonus.multiply(BigDecimal.valueOf(2));
        }

        if (employeePerformanceRating.equals(PerformanceRating.EXCEPTIONAL)) {
            bonus = bonus.multiply(BigDecimal.valueOf(1.5));
        }

        return bonus;
    }

    private boolean isEmployeeValidForBonus(List<BigDecimal> yearlyBonuses, BigDecimal salary) {

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

        var salaryMultipliedBySix = salary.multiply(BigDecimal.valueOf(6));
        for(int i = 0; i < yearlyBonuses.size(); i++) {

            var start = i;
            var end = start + 5;
            var sumOfBonusesOf5yearsInRow = new BigDecimal(0);

            if (yearlyBonuses.size() < 5 || end > yearlyBonuses.size()) {
                break;
            }

            for (int y = start; y < end ; y++) {
                sumOfBonusesOf5yearsInRow = sumOfBonusesOf5yearsInRow.add(yearlyBonuses.get(y));
            }

            if (sumOfBonusesOf5yearsInRow.compareTo(salaryMultipliedBySix) == 1) {
                return false;
            }
        }

        return true;
    }

}

package org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.constants.ValidationMessages;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeEntity {

  // This is a unique identifier for every employee.
  private String id;
  private String firstName;
  private String lastName;
  private Team team;
  private PerformanceRating rating;
  private EmployeeType type;
  private BigDecimal yearlySalary;
  private int employmentTime;
  private List<BigDecimal> yearlyBonuses;

  public EmployeeEntity(Employee employee) {
    update(employee);
  }

  public EmployeeEntity(UUID id, String firstName, String lastName, Team team, PerformanceRating rating, EmployeeType type,
                        BigDecimal yearlySalary, int employmentTime, List<BigDecimal> yearlyBonuses)
  {
    this.id = id.toString();
    this.firstName = firstName;
    this.lastName = lastName;
    this.team = team;
    this.rating = rating;
    this.type = type;
    this.yearlySalary = yearlySalary;
    this.employmentTime = employmentTime;
    this.yearlyBonuses = yearlyBonuses;
  }


  public void update(Employee employee) {
    this.id = employee.getId().toString();
    this.firstName = employee.getFirstName();
    this.lastName = employee.getLastName();
    this.team = employee.getTeam();
    this.rating = employee.getRating();
    this.type = employee.getType();
    this.yearlySalary = employee.getYearlySalary();
    this.employmentTime = employee.getEmploymentTime();
    this.yearlyBonuses = employee.getYearlyBonuses();
  }
}

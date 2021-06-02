package org.example.employee_performance_review_api.domain.model.employee;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;

@Data
@AllArgsConstructor
public class NewEmployeeInput {

  private String firstName;
  private String lastName;
  private Team team;
  private PerformanceRating rating;
  private EmployeeType type;
  private BigDecimal yearlySalary;
  private int employmentTime;
  private List<BigDecimal> yearlyBonuses;
}

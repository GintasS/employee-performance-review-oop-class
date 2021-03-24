package org.example.employee_performance_review_api.application.web.model.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.employee.UpdateEmployeeInput;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;
import org.example.employee_performance_review_api.infrastructure.web.validation.constraint.AtLeastOneFieldMustBeNotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonRootName("employee")
@AtLeastOneFieldMustBeNotNull
@RegisterForReflection
public class UpdateEmployeeRequest {

  private String firstName;
  private String lastName;
  private Team team;
  private PerformanceRating rating;
  private EmployeeType type;
  private BigDecimal yearlySalary;
  private int employmentTime;
  private List<BigDecimal> yearlyBonuses;

  public UpdateEmployeeInput toUpdateEmployeeInput(UUID id) {
    return new UpdateEmployeeInput(id, this.firstName, this.lastName, this.team, this.rating, this.type, this.yearlySalary, this.employmentTime, this.yearlyBonuses);

    // TODO finish this mapping.
  }
}

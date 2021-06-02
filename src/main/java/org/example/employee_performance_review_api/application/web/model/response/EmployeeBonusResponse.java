package org.example.employee_performance_review_api.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName("employeeBonus")
@RegisterForReflection
public class EmployeeBonusResponse {

  private BigDecimal bonus;

  public EmployeeBonusResponse(BigDecimal bonus) {
    this.bonus = bonus;
  }
}

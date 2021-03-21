package org.example.employee_performance_review_api.application.web.model.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.article.UpdateArticleInput;
import org.example.employee_performance_review_api.domain.model.employee.UpdateEmployeeInput;
import org.example.employee_performance_review_api.infrastructure.web.validation.constraint.AtLeastOneFieldMustBeNotNull;

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

  public UpdateEmployeeInput toUpdateEmployeeInput(UUID id) {
    return new UpdateEmployeeInput(id, this.firstName, this.lastName);

    // TODO finish this mapping.
  }
}

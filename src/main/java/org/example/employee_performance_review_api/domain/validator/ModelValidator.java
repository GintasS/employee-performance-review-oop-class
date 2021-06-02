package org.example.employee_performance_review_api.domain.validator;

import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.exception.ModelValidationException;

@AllArgsConstructor
public class ModelValidator {

  private final Validator validator;

  public <T> T validate(T model) {
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(model);

    if (!constraintViolations.isEmpty()) {
      final var messages =
          constraintViolations.stream()
              .map(ConstraintViolation::getMessage)
              .collect(Collectors.toList());
      throw new ModelValidationException(messages);
    }

    return model;
  }
}

package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.user.UpdateUserInput;
import org.example.employee_performance_review_api.domain.model.user.User;

public interface UpdateUser {
  User handle(UpdateUserInput updateUserInput);
}

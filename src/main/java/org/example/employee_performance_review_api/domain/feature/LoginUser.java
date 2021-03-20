package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.user.LoginUserInput;
import org.example.employee_performance_review_api.domain.model.user.User;

public interface LoginUser {
  User handle(LoginUserInput loginUserInput);
}

package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindUserByUsername;
import org.example.employee_performance_review_api.domain.exception.UserNotFoundException;
import org.example.employee_performance_review_api.domain.model.user.User;
import org.example.employee_performance_review_api.domain.model.user.UserRepository;

@AllArgsConstructor
public class FindUserByUsernameImpl implements FindUserByUsername {

  private final UserRepository userRepository;

  @Override
  public User handle(String username) {
    return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
  }
}

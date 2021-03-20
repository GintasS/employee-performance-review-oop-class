package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindUserById;
import org.example.employee_performance_review_api.domain.exception.UserNotFoundException;
import org.example.employee_performance_review_api.domain.model.user.User;
import org.example.employee_performance_review_api.domain.model.user.UserRepository;

import java.util.UUID;

@AllArgsConstructor
public class FindUserByIdImpl implements FindUserById {

  private final UserRepository userRepository;

  @Override
  public User handle(UUID id) {
    return userRepository.findUserById(id).orElseThrow(UserNotFoundException::new);
  }
}

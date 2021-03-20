package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.exception.EmailAlreadyExistsException;
import org.example.employee_performance_review_api.domain.exception.UsernameAlreadyExistsException;
import org.example.employee_performance_review_api.domain.feature.CreateUser;
import org.example.employee_performance_review_api.domain.model.provider.HashProvider;
import org.example.employee_performance_review_api.domain.model.user.CreateUserInput;
import org.example.employee_performance_review_api.domain.model.user.User;
import org.example.employee_performance_review_api.domain.model.user.UserModelBuilder;
import org.example.employee_performance_review_api.domain.model.user.UserRepository;

@AllArgsConstructor
public class CreateUserImpl implements CreateUser {

  private final UserRepository userRepository;
  private final HashProvider hashProvider;
  private final UserModelBuilder userBuilder;

  @Override
  public User handle(CreateUserInput createUserInput) {
    final var user =
        userBuilder.build(
            createUserInput.getUsername(),
            createUserInput.getEmail(),
            createUserInput.getPassword());
    checkExistingUsername(user.getUsername());
    checkExistingEmail(user.getEmail());
    user.setPassword(hashProvider.hashPassword(user.getPassword()));
    userRepository.save(user);
    return user;
  }

  private void checkExistingUsername(String username) {
    if (userRepository.existsBy("username", username)) {
      throw new UsernameAlreadyExistsException();
    }
  }

  private void checkExistingEmail(String email) {
    if (userRepository.existsBy("email", email)) {
      throw new EmailAlreadyExistsException();
    }
  }
}

package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindUserById;
import org.example.employee_performance_review_api.domain.feature.FindUserByUsername;
import org.example.employee_performance_review_api.domain.feature.FollowUserByUsername;
import org.example.employee_performance_review_api.domain.model.user.FollowRelationship;
import org.example.employee_performance_review_api.domain.model.user.FollowRelationshipRepository;

import java.util.UUID;

@AllArgsConstructor
public class FollowUserByUsernameImpl implements FollowUserByUsername {

  private final FindUserById findUserById;
  private final FindUserByUsername findUserByUsername;
  private final FollowRelationshipRepository usersFollowedRepository;

  @Override
  public FollowRelationship handle(UUID loggedUserId, String username) {
    final var loggedUser = findUserById.handle(loggedUserId);
    final var userToFollow = findUserByUsername.handle(username);
    final var followingRelationship = new FollowRelationship(loggedUser, userToFollow);
    usersFollowedRepository.save(followingRelationship);
    return followingRelationship;
  }
}

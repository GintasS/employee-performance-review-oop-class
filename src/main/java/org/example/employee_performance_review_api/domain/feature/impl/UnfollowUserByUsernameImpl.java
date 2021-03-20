package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindUserById;
import org.example.employee_performance_review_api.domain.feature.FindUserByUsername;
import org.example.employee_performance_review_api.domain.feature.UnfollowUserByUsername;
import org.example.employee_performance_review_api.domain.model.user.FollowRelationshipRepository;

import java.util.UUID;

@AllArgsConstructor
public class UnfollowUserByUsernameImpl implements UnfollowUserByUsername {

  private final FindUserById findUserById;
  private final FindUserByUsername findUserByUsername;
  private final FollowRelationshipRepository followRelationshipRepository;

  @Override
  public void handle(UUID loggedUserId, String username) {
    final var loggedUser = findUserById.handle(loggedUserId);
    final var userToUnfollow = findUserByUsername.handle(username);
    final var followingRelationship =
        followRelationshipRepository.findByUsers(loggedUser, userToUnfollow).orElseThrow();
    followRelationshipRepository.remove(followingRelationship);
  }
}

package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.user.FollowRelationship;

import java.util.UUID;

public interface FollowUserByUsername {
  FollowRelationship handle(UUID loggedUserId, String username);
}

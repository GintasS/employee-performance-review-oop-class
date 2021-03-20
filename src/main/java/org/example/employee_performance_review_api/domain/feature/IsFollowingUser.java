package org.example.employee_performance_review_api.domain.feature;

import java.util.UUID;

public interface IsFollowingUser {
  boolean handle(UUID currentUserId, UUID followedUserId);
}

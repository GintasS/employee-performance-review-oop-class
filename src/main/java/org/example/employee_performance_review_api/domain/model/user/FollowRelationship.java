package org.example.employee_performance_review_api.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowRelationship {
  private User user;
  private User followed;
}

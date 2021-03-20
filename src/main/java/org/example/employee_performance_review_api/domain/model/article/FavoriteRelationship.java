package org.example.employee_performance_review_api.domain.model.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.employee_performance_review_api.domain.model.user.User;

@Data
@AllArgsConstructor
public class FavoriteRelationship {
  private User user;
  private Article article;
}

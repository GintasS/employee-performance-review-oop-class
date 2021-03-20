package org.example.employee_performance_review_api.domain.feature;

import java.util.UUID;

public interface DeleteArticleBySlug {
  void handle(UUID authorId, String slug);
}

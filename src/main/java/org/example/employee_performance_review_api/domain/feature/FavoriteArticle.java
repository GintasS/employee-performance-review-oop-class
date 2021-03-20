package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.article.FavoriteRelationship;

import java.util.UUID;

public interface FavoriteArticle {
  FavoriteRelationship handle(String articleSlug, UUID currentUserId);
}

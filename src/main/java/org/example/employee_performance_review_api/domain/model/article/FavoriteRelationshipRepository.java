package org.example.employee_performance_review_api.domain.model.article;

import java.util.Optional;
import java.util.UUID;

public interface FavoriteRelationshipRepository {
  boolean isFavorited(Article article, UUID currentUserId);

  long favoritesCount(Article article);

  Optional<FavoriteRelationship> findByArticleIdAndUserId(UUID articleId, UUID currentUserId);

  void save(FavoriteRelationship favoriteRelationship);

  void delete(FavoriteRelationship favoriteRelationship);
}

package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.IsArticleFavorited;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.FavoriteRelationshipRepository;

import java.util.UUID;

@AllArgsConstructor
public class IsArticleFavoritedImpl implements IsArticleFavorited {

  private final FavoriteRelationshipRepository favoriteRelationshipRepository;

  @Override
  public boolean handle(Article article, UUID currentUserId) {
    return favoriteRelationshipRepository.isFavorited(article, currentUserId);
  }
}

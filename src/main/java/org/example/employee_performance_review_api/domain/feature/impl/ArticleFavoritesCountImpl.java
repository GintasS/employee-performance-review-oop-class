package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.ArticleFavoritesCount;
import org.example.employee_performance_review_api.domain.feature.FindArticleById;
import org.example.employee_performance_review_api.domain.model.article.FavoriteRelationshipRepository;

import java.util.UUID;

@AllArgsConstructor
public class ArticleFavoritesCountImpl implements ArticleFavoritesCount {

  private final FindArticleById findArticleById;
  private final FavoriteRelationshipRepository favoriteRelationshipRepository;

  @Override
  public long handle(UUID articleId) {
    final var article = findArticleById.handle(articleId);
    return favoriteRelationshipRepository.favoritesCount(article);
  }
}

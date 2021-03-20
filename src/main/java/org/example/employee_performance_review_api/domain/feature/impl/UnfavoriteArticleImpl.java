package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindArticleBySlug;
import org.example.employee_performance_review_api.domain.feature.UnfavoriteArticle;
import org.example.employee_performance_review_api.domain.model.article.FavoriteRelationshipRepository;

import java.util.UUID;

@AllArgsConstructor
public class UnfavoriteArticleImpl implements UnfavoriteArticle {

  private final FindArticleBySlug findArticleBySlug;
  private final FavoriteRelationshipRepository favoriteRelationshipRepository;

  @Override
  public void handle(String articleSlug, UUID currentUserId) {
    final var article = findArticleBySlug.handle(articleSlug);
    final var favoriteRelationshipOptional =
        favoriteRelationshipRepository.findByArticleIdAndUserId(article.getId(), currentUserId);
    favoriteRelationshipOptional.ifPresent(favoriteRelationshipRepository::delete);
  }
}

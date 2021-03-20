package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.DeleteArticleBySlug;
import org.example.employee_performance_review_api.domain.feature.FindArticleByAuthorAndSlug;
import org.example.employee_performance_review_api.domain.model.article.ArticleRepository;

import java.util.UUID;

@AllArgsConstructor
public class DeleteArticleBySlugImpl implements DeleteArticleBySlug {

  private final FindArticleByAuthorAndSlug findArticleByAuthorAndSlug;
  private final ArticleRepository articleRepository;

  @Override
  public void handle(UUID authorId, String slug) {
    final var article = findArticleByAuthorAndSlug.handle(authorId, slug);
    articleRepository.delete(article);
  }
}

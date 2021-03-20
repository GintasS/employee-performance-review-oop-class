package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindArticleByAuthorAndSlug;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.ArticleRepository;
import org.example.employee_performance_review_api.domain.exception.ArticleNotFoundException;

import java.util.UUID;

@AllArgsConstructor
public class FindArticleByAuthorAndSlugImpl implements FindArticleByAuthorAndSlug {

  private final ArticleRepository articleRepository;

  @Override
  public Article handle(UUID authorId, String slug) {
    return articleRepository
        .findByAuthorAndSlug(authorId, slug)
        .orElseThrow(ArticleNotFoundException::new);
  }
}

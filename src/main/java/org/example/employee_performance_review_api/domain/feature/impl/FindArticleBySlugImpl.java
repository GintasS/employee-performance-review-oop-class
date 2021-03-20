package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindArticleBySlug;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.ArticleRepository;
import org.example.employee_performance_review_api.domain.exception.ArticleNotFoundException;

@AllArgsConstructor
public class FindArticleBySlugImpl implements FindArticleBySlug {

  private final ArticleRepository articleRepository;

  @Override
  public Article handle(String slug) {
    return articleRepository.findBySlug(slug).orElseThrow(ArticleNotFoundException::new);
  }
}

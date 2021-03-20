package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindArticleById;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.ArticleRepository;
import org.example.employee_performance_review_api.domain.exception.ArticleNotFoundException;

import java.util.UUID;

@AllArgsConstructor
public class FindArticleByIdImpl implements FindArticleById {

  private final ArticleRepository articleRepository;

  @Override
  public Article handle(UUID id) {
    return articleRepository.findArticleById(id).orElseThrow(ArticleNotFoundException::new);
  }
}

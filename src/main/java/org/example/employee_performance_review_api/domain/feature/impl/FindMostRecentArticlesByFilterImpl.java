package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindMostRecentArticlesByFilter;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.ArticleFilter;
import org.example.employee_performance_review_api.domain.model.article.ArticleRepository;
import org.example.employee_performance_review_api.domain.model.article.PageResult;

@AllArgsConstructor
public class FindMostRecentArticlesByFilterImpl implements FindMostRecentArticlesByFilter {

  private final ArticleRepository articleRepository;

  @Override
  public PageResult<Article> handle(ArticleFilter articleFilter) {
    return articleRepository.findMostRecentArticlesByFilter(articleFilter);
  }
}

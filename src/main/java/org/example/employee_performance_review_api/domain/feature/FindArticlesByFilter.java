package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.ArticleFilter;
import org.example.employee_performance_review_api.domain.model.article.PageResult;

public interface FindArticlesByFilter {
  PageResult<Article> handle(ArticleFilter articleFilter);
}

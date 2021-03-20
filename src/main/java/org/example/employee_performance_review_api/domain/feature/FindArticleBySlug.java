package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.article.Article;

public interface FindArticleBySlug {
  Article handle(String slug);
}

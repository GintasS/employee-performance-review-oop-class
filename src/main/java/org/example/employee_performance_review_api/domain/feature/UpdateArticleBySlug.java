package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.UpdateArticleInput;

public interface UpdateArticleBySlug {
  Article handle(UpdateArticleInput updateArticleInput);
}

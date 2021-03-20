package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.NewArticleInput;

public interface CreateArticle {
  Article handle(NewArticleInput newArticleInput);
}

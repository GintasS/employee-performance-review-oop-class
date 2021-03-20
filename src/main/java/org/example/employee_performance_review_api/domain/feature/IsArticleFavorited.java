package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.article.Article;

import java.util.UUID;

public interface IsArticleFavorited {
  boolean handle(Article article, UUID currentUserId);
}

package org.example.employee_performance_review_api.domain.exception;

public class ArticleNotFoundException extends BusinessException {

  public ArticleNotFoundException() {
    super(5, "article not found");
  }
}

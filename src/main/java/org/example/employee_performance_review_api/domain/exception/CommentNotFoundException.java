package org.example.employee_performance_review_api.domain.exception;

public class CommentNotFoundException extends BusinessException {
  public CommentNotFoundException() {
    super(6, "comment not found");
  }
}

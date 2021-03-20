package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.comment.DeleteCommentInput;

public interface DeleteComment {
  void handle(DeleteCommentInput deleteCommentInput);
}

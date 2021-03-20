package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.comment.Comment;
import org.example.employee_performance_review_api.domain.model.comment.NewCommentInput;

public interface CreateComment {
  Comment handle(NewCommentInput newCommentInput);
}

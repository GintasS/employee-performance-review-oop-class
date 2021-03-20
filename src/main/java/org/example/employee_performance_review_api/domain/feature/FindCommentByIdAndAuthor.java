package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.comment.Comment;

import java.util.UUID;

public interface FindCommentByIdAndAuthor {
  Comment handle(UUID commentId, UUID authorId);
}

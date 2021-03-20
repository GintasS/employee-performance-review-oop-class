package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindCommentByIdAndAuthor;
import org.example.employee_performance_review_api.domain.model.comment.Comment;
import org.example.employee_performance_review_api.domain.model.comment.CommentRepository;
import org.example.employee_performance_review_api.domain.exception.CommentNotFoundException;

import java.util.UUID;

@AllArgsConstructor
public class FindCommentByIdAndAuthorImpl implements FindCommentByIdAndAuthor {

  private final CommentRepository commentRepository;

  @Override
  public Comment handle(UUID commentId, UUID authorId) {
    return commentRepository
        .findByIdAndAuthor(commentId, authorId)
        .orElseThrow(CommentNotFoundException::new);
  }
}

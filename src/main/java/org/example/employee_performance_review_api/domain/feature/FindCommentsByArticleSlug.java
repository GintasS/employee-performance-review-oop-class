package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.comment.Comment;

import java.util.List;

public interface FindCommentsByArticleSlug {
  List<Comment> handle(String slug);
}

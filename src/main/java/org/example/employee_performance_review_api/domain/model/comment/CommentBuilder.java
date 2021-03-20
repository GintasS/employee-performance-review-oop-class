package org.example.employee_performance_review_api.domain.model.comment;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.user.User;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
public class CommentBuilder {

  private final ModelValidator modelValidator;

  public Comment build(User author, Article article, String body) {
    final var createdAt = LocalDateTime.now();
    return modelValidator.validate(
        new Comment(UUID.randomUUID(), author, article, body, createdAt, createdAt));
  }

  public Comment build(
      UUID id,
      User author,
      Article article,
      String body,
      LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    return modelValidator.validate(new Comment(id, author, article, body, createdAt, updatedAt));
  }
}

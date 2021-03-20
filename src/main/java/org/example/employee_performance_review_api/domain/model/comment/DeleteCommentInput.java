package org.example.employee_performance_review_api.domain.model.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class DeleteCommentInput {
  private final UUID commentId;
  private final UUID authorId;
  private final String articleSlug;
}

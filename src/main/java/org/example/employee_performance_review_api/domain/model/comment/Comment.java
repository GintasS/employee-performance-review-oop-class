package org.example.employee_performance_review_api.domain.model.comment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.user.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
  @NotNull private final UUID id;
  @NotNull private final User author;
  @NotNull private final Article article;
  @NotBlank private final String body;
  @NotNull private final LocalDateTime createdAt;
  private final LocalDateTime updatedAt;
}

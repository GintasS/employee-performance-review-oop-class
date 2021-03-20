package org.example.employee_performance_review_api.application.web.model.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.comment.NewCommentInput;
import org.example.employee_performance_review_api.domain.model.constants.ValidationMessages;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
@JsonRootName("comment")
@RegisterForReflection
public class NewCommentRequest {
  @NotBlank(message = ValidationMessages.BODY_MUST_BE_NOT_BLANK)
  private String body;

  public NewCommentInput toNewCommentInput(UUID authorId, String articleSlug) {
    return new NewCommentInput(authorId, articleSlug, this.body);
  }
}

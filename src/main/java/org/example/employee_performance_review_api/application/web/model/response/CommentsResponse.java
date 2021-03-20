package org.example.employee_performance_review_api.application.web.model.response;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RegisterForReflection
public class CommentsResponse {

  private List<CommentResponse> comments;

  public CommentsResponse(List<CommentResponse> comments) {
    this.comments = comments;
  }
}

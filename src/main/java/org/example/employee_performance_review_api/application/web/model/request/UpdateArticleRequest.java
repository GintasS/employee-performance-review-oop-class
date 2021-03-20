package org.example.employee_performance_review_api.application.web.model.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.article.UpdateArticleInput;
import org.example.employee_performance_review_api.infrastructure.web.validation.constraint.AtLeastOneFieldMustBeNotNull;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonRootName("article")
@AtLeastOneFieldMustBeNotNull
@RegisterForReflection
public class UpdateArticleRequest {

  private String title;

  private String description;

  private String body;

  public UpdateArticleInput toUpdateArticleInput(UUID authorId, String slug) {
    return new UpdateArticleInput(authorId, slug, this.title, this.description, this.body);
  }
}

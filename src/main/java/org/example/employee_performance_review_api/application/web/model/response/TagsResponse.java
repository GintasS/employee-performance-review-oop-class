package org.example.employee_performance_review_api.application.web.model.response;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.tag.Tag;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@RegisterForReflection
public class TagsResponse {

  private List<String> tags;

  public TagsResponse(List<Tag> tags) {
    this.tags = tags.stream().map(Tag::getName).collect(Collectors.toList());
  }
}

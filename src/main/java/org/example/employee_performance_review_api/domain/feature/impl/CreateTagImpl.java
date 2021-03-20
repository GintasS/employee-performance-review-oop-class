package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.CreateTag;
import org.example.employee_performance_review_api.domain.model.tag.Tag;
import org.example.employee_performance_review_api.domain.model.tag.TagBuilder;
import org.example.employee_performance_review_api.domain.model.tag.TagRepository;

@AllArgsConstructor
public class CreateTagImpl implements CreateTag {

  private final TagRepository tagRepository;
  private final TagBuilder tagBuilder;

  @Override
  public Tag handle(String name) {
    final var tag = tagBuilder.build(name);
    tagRepository.save(tag);
    return tag;
  }
}

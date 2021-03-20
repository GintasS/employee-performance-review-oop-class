package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindTags;
import org.example.employee_performance_review_api.domain.model.tag.Tag;
import org.example.employee_performance_review_api.domain.model.tag.TagRepository;

import java.util.List;

@AllArgsConstructor
public class FindTagsImpl implements FindTags {

  private final TagRepository tagRepository;

  @Override
  public List<Tag> handle() {
    return tagRepository.findAllTags();
  }
}

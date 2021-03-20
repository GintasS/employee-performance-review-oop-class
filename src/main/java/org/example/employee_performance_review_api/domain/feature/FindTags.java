package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.tag.Tag;

import java.util.List;

public interface FindTags {
  List<Tag> handle();
}

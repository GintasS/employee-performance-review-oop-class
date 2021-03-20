package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.tag.Tag;

public interface CreateTag {
  Tag handle(String name);
}

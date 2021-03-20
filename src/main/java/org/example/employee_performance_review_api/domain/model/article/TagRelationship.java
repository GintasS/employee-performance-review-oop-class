package org.example.employee_performance_review_api.domain.model.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.employee_performance_review_api.domain.model.tag.Tag;

@Data
@AllArgsConstructor
public class TagRelationship {
  private final Article article;
  private final Tag tag;
}

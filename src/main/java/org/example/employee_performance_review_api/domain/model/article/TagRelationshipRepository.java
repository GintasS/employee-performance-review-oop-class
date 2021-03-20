package org.example.employee_performance_review_api.domain.model.article;

import org.example.employee_performance_review_api.domain.model.tag.Tag;

import java.util.List;

public interface TagRelationshipRepository {
  void save(TagRelationship tagRelationship);

  List<Tag> findArticleTags(Article article);
}

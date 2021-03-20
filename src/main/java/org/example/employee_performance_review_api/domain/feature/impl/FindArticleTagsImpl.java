package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindArticleTags;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.TagRelationshipRepository;
import org.example.employee_performance_review_api.domain.model.tag.Tag;

import java.util.List;

@AllArgsConstructor
public class FindArticleTagsImpl implements FindArticleTags {

  private final TagRelationshipRepository tagRelationshipRepository;

  @Override
  public List<Tag> handle(Article article) {
    return tagRelationshipRepository.findArticleTags(article);
  }
}

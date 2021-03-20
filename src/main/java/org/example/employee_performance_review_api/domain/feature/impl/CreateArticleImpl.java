package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.CreateArticle;
import org.example.employee_performance_review_api.domain.feature.CreateSlugByTitle;
import org.example.employee_performance_review_api.domain.feature.FindTagsByNameCreateIfNotExists;
import org.example.employee_performance_review_api.domain.feature.FindUserById;
import org.example.employee_performance_review_api.domain.model.article.*;
import org.example.employee_performance_review_api.domain.model.tag.Tag;

import java.util.List;

@AllArgsConstructor
public class CreateArticleImpl implements CreateArticle {

  private final FindUserById findUserById;
  private final ArticleRepository articleRepository;
  private final ArticleModelBuilder articleBuilder;
  private final CreateSlugByTitle createSlugByTitle;
  private final FindTagsByNameCreateIfNotExists findTagsByNameCreateIfNotExists;
  private final TagRelationshipRepository tagRelationshipRepository;

  @Override
  public Article handle(NewArticleInput newArticleInput) {
    final var author = findUserById.handle(newArticleInput.getAuthorId());
    final var slug = createSlugByTitle.handle(newArticleInput.getTitle());
    final var article =
        articleBuilder.build(
            slug,
            newArticleInput.getTitle(),
            newArticleInput.getDescription(),
            newArticleInput.getBody(),
            author);
    articleRepository.save(article);
    final var tags = findTagsByNameCreateIfNotExists.handle(newArticleInput.getTagList());
    createTagRelationship(article, tags);
    return article;
  }

  private void createTagRelationship(Article article, List<Tag> tags) {
    tags.forEach(tag -> tagRelationshipRepository.save(new TagRelationship(article, tag)));
  }
}

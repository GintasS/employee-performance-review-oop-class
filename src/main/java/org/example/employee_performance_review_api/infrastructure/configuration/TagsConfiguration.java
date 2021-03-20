package org.example.employee_performance_review_api.infrastructure.configuration;

import org.example.employee_performance_review_api.domain.feature.CreateTag;
import org.example.employee_performance_review_api.domain.feature.FindTags;
import org.example.employee_performance_review_api.domain.feature.FindTagsByNameCreateIfNotExists;
import org.example.employee_performance_review_api.domain.feature.impl.CreateTagImpl;
import org.example.employee_performance_review_api.domain.feature.impl.FindTagsByNameCreateIfNotExistsImpl;
import org.example.employee_performance_review_api.domain.feature.impl.FindTagsImpl;
import org.example.employee_performance_review_api.domain.model.tag.TagBuilder;
import org.example.employee_performance_review_api.domain.model.tag.TagRepository;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Dependent
public class TagsConfiguration {

  @Produces
  @Singleton
  public FindTags findTags(TagRepository tagRepository) {
    return new FindTagsImpl(tagRepository);
  }

  @Produces
  @Singleton
  public CreateTag createTag(TagRepository tagRepository, TagBuilder tagBuilder) {
    return new CreateTagImpl(tagRepository, tagBuilder);
  }

  @Produces
  @Singleton
  public FindTagsByNameCreateIfNotExists findTagsByNameCreateIfNotExists(
      TagRepository tagRepository, CreateTag createTag) {
    return new FindTagsByNameCreateIfNotExistsImpl(tagRepository, createTag);
  }

  @Produces
  @Singleton
  public TagBuilder tagBuilder(ModelValidator modelValidator) {
    return new TagBuilder(modelValidator);
  }
}

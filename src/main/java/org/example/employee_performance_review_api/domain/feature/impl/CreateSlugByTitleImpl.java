package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.CreateSlugByTitle;
import org.example.employee_performance_review_api.domain.model.article.ArticleRepository;
import org.example.employee_performance_review_api.domain.model.provider.SlugProvider;

import java.util.UUID;

@AllArgsConstructor
public class CreateSlugByTitleImpl implements CreateSlugByTitle {

  private final ArticleRepository articleRepository;
  private final SlugProvider slugProvider;

  @Override
  public String handle(String title) {
    String slug = slugProvider.slugify(title);
    if (articleRepository.existsBySlug(slug)) {
      slug += UUID.randomUUID().toString();
    }
    return slug;
  }
}

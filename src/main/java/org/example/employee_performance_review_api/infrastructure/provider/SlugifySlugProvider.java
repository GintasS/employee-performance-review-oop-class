package org.example.employee_performance_review_api.infrastructure.provider;

import com.github.slugify.Slugify;
import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.model.provider.SlugProvider;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@AllArgsConstructor
public class SlugifySlugProvider implements SlugProvider {

  private final Slugify slugify;

  @Override
  public String slugify(String text) {
    return slugify.slugify(text);
  }
}

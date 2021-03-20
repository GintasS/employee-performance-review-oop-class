package org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TagRelationshipEntityKey implements Serializable {

  @ManyToOne private ArticleEntity article;
  @ManyToOne private TagEntity tag;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    TagRelationshipEntityKey that = (TagRelationshipEntityKey) o;
    return Objects.equals(article, that.article) && Objects.equals(tag, that.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(article, tag);
  }
}
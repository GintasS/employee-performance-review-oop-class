package org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.ArticleModelBuilder;
import org.example.employee_performance_review_api.domain.model.article.FavoriteRelationship;
import org.example.employee_performance_review_api.domain.model.comment.Comment;
import org.example.employee_performance_review_api.domain.model.comment.CommentBuilder;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeModelBuilder;
import org.example.employee_performance_review_api.domain.model.tag.Tag;
import org.example.employee_performance_review_api.domain.model.tag.TagBuilder;
import org.example.employee_performance_review_api.domain.model.user.User;
import org.example.employee_performance_review_api.domain.model.user.UserModelBuilder;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@AllArgsConstructor
public class EntityUtils {
  private final UserModelBuilder userBuilder;
  private final TagBuilder tagBuilder;
  private final ArticleModelBuilder articleBuilder;
  private final CommentBuilder commentBuilder;
  private final EmployeeModelBuilder employeeBuilder;

  public User user(UserEntity userEntity) {
    final var id = userEntity.getId();
    final var username = userEntity.getUsername();
    final var bio = userEntity.getBio();
    final var image = userEntity.getImage();
    final var password = userEntity.getPassword();
    final var email = userEntity.getEmail();
    return userBuilder.build(id, username, bio, image, password, email);
  }

  public Employee employee(EmployeeEntity employeeEntity) {
    final var id = employeeEntity.getId();
    final var firstName = employeeEntity.getFirstName();
    final var lastName = employeeEntity.getLastName();
    // TODO map this
    return employeeBuilder.build(id, firstName, lastName);
  }



  public Tag tag(TagEntity tagEntity) {
    return tagBuilder.build(tagEntity.getId(), tagEntity.getName());
  }

  public Tag tag(TagRelationshipEntity tagRelationshipEntity) {
    return tag(tagRelationshipEntity.getPrimaryKey().getTag());
  }

  public Article article(ArticleEntity articleEntity) {
    return articleBuilder.build(
        articleEntity.getId(),
        articleEntity.getSlug(),
        articleEntity.getTitle(),
        articleEntity.getDescription(),
        articleEntity.getBody(),
        articleEntity.getCreatedAt(),
        articleEntity.getUpdatedAt(),
        user(articleEntity.getAuthor()));
  }

  public Comment comment(CommentEntity commentEntity) {
    return commentBuilder.build(
        commentEntity.getId(),
        user(commentEntity.getAuthor()),
        article(commentEntity.getArticle()),
        commentEntity.getBody(),
        commentEntity.getCreatedAt(),
        commentEntity.getUpdatedAt());
  }

  public FavoriteRelationship favoriteRelationship(
      FavoriteRelationshipEntity favoriteRelationshipEntity) {
    return new FavoriteRelationship(
        user(favoriteRelationshipEntity.getUser()),
        article(favoriteRelationshipEntity.getArticle()));
  }
}

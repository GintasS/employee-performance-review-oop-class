package org.example.employee_performance_review_api.infrastructure.configuration;

import org.example.employee_performance_review_api.domain.feature.*;
import org.example.employee_performance_review_api.domain.feature.impl.CreateCommentImpl;
import org.example.employee_performance_review_api.domain.feature.impl.DeleteCommentImpl;
import org.example.employee_performance_review_api.domain.feature.impl.FindCommentByIdAndAuthorImpl;
import org.example.employee_performance_review_api.domain.feature.impl.FindCommentsByArticleSlugImpl;
import org.example.employee_performance_review_api.domain.model.comment.CommentBuilder;
import org.example.employee_performance_review_api.domain.model.comment.CommentRepository;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Dependent
public class CommentsConfiguration {

  @Produces
  @Singleton
  public CreateComment createComment(
      CommentRepository commentRepository,
      FindUserById findUserById,
      FindArticleBySlug findArticleBySlug,
      CommentBuilder commentBuilder) {
    return new CreateCommentImpl(
        commentRepository, findUserById, findArticleBySlug, commentBuilder);
  }

  @Produces
  @Singleton
  public DeleteComment deleteComment(
      FindCommentByIdAndAuthor findCommentByIdAndAuthor, CommentRepository commentRepository) {
    return new DeleteCommentImpl(findCommentByIdAndAuthor, commentRepository);
  }

  @Produces
  @Singleton
  public FindCommentByIdAndAuthor findCommentByIdAndAuthor(CommentRepository commentRepository) {
    return new FindCommentByIdAndAuthorImpl(commentRepository);
  }

  @Produces
  @Singleton
  public FindCommentsByArticleSlug findCommentsByArticleSlug(
      FindArticleBySlug findArticleBySlug, CommentRepository commentRepository) {
    return new FindCommentsByArticleSlugImpl(findArticleBySlug, commentRepository);
  }

  @Produces
  @Singleton
  public CommentBuilder commentBuilder(ModelValidator modelValidator) {
    return new CommentBuilder(modelValidator);
  }
}

package org.example.employee_performance_review_api.application.web.resource.utils;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.application.web.model.response.*;
import org.example.employee_performance_review_api.domain.feature.*;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.PageResult;
import org.example.employee_performance_review_api.domain.model.comment.Comment;
import org.example.employee_performance_review_api.domain.model.employee.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
@AllArgsConstructor
public class ResourceUtils {

  private static final int DEFAULT_LIMIT = 20;
  private final FindUserByUsername findUserByUsername;
  private final IsFollowingUser isFollowingUser;
  private final FindArticleTags findArticleTags;
  private final IsArticleFavorited isArticleFavorited;
  private final ArticleFavoritesCount articleFavoritesCount;

  public ProfileResponse profileResponse(String username, UUID loggedUserId) {
    final var user = findUserByUsername.handle(username);
    final var profileResponse = new ProfileResponse(user);
    if (loggedUserId != null) {
      profileResponse.setFollowing(isFollowingUser.handle(loggedUserId, user.getId()));
    }
    return profileResponse;
  }

  public ArticleResponse articleResponse(Article article, UUID loggedUserId) {
    final var author = article.getAuthor();
    final var profileResponse = profileResponse(author.getUsername(), author.getId());
    final var tags = findArticleTags.handle(article);
    final var favoritesCount = articleFavoritesCount.handle(article.getId());
    final var articleResponse = new ArticleResponse(article, profileResponse, favoritesCount, tags);
    if (loggedUserId != null) {
      articleResponse.setFavorited(isArticleFavorited.handle(article, loggedUserId));
    }
    return articleResponse;
  }

  public ArticlesResponse articlesResponse(PageResult<Article> pageResult, UUID loggedUserId) {
    final var resultResponse =
        pageResult.getResult().stream()
            .map(article -> articleResponse(article, loggedUserId))
            .collect(Collectors.toList());
    return new ArticlesResponse(resultResponse, pageResult.getTotal());
  }

  public EmployeesResponse employeesResponse(List<Employee> employees) {
    final var resultsResponse = employees.stream().map(employee -> employeeResponse(employee))
            .collect(Collectors.toList());

    return new EmployeesResponse(resultsResponse);
  }

  public EmployeeResponse employeeResponse(Employee employee) {
    return new EmployeeResponse(employee);
  }


  public CommentResponse commentResponse(Comment comment, UUID loggedUserId) {
    final var commentAuthor = comment.getAuthor();
    final var authorResponse = profileResponse(commentAuthor.getUsername(), loggedUserId);
    return new CommentResponse(comment, authorResponse);
  }

  public UUID getLoggedUserId(SecurityContext securityContext) {
    Principal principal = securityContext.getUserPrincipal();
    return principal != null ? UUID.fromString(principal.getName()) : null;
  }

  public CommentsResponse commentsResponse(List<Comment> comments, UUID loggedUserId) {
    final var resultResponse =
        comments.stream()
            .map(comment -> commentResponse(comment, loggedUserId))
            .collect(Collectors.toList());
    return new CommentsResponse(resultResponse);
  }

  public int getLimit(int limit) {
    return limit > 0 ? limit : DEFAULT_LIMIT;
  }
}

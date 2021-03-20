package org.example.employee_performance_review_api.infrastructure.repository.hibernate.panache;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.FavoriteRelationship;
import org.example.employee_performance_review_api.domain.model.article.FavoriteRelationshipRepository;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.EntityUtils;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.FavoriteRelationshipEntity;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.FavoriteRelationshipEntityKey;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.UUID;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
@AllArgsConstructor
public class FavoriteRelationshipRepositoryPanache
    extends AbstractPanacheRepository<FavoriteRelationshipEntity, FavoriteRelationshipEntityKey>
    implements FavoriteRelationshipRepository {

  private final EntityUtils entityUtils;

  @Override
  public boolean isFavorited(Article article, UUID currentUserId) {
    return count(
            "article.id = :articleId and user.id = :currentUserId",
            with("articleId", article.getId()).and("currentUserId", currentUserId))
        > 0;
  }

  @Override
  public long favoritesCount(Article article) {
    return count("article.id", article.getId());
  }

  @Override
  public Optional<FavoriteRelationship> findByArticleIdAndUserId(
      UUID articleId, UUID currentUserId) {
    return find(
            "article.id = :articleId and user.id = :currentUserId",
            with("articleId", articleId).and("currentUserId", currentUserId))
        .firstResultOptional()
        .map(entityUtils::favoriteRelationship);
  }

  @Override
  public void save(FavoriteRelationship favoriteRelationship) {
    final var userEntity = findUserEntityById(favoriteRelationship.getUser().getId());
    final var articleEntity = findArticleEntityById(favoriteRelationship.getArticle().getId());
    persist(new FavoriteRelationshipEntity(userEntity, articleEntity));
  }

  @Override
  public void delete(FavoriteRelationship favoriteRelationship) {
    final var favoriteRelationshipEntity =
        findFavoriteRelationshipEntityByKey(favoriteRelationship);
    delete(favoriteRelationshipEntity);
  }
}

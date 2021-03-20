package org.example.employee_performance_review_api.integration;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.http.HttpStatus;
import org.example.employee_performance_review_api.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.example.employee_performance_review_api.constants.TestConstants.API_PREFIX;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class TagsResourceIntegrationTest extends AbstractIntegrationTest {

  private final String TAGS_PATH = API_PREFIX + "/tags";

  @Test
  public void givenExistentTags_whenExecuteGetTagsEndpoint_shouldReturnTagListWithStatusCode200() {

    final var tag1 = createTagEntity("tag 1");
    final var tag2 = createTagEntity("tag 2");
    final var tag3 = createTagEntity("tag 3");
    final var tag4 = createTagEntity("tag 4");

    given()
        .contentType(MediaType.APPLICATION_JSON)
        .get(TAGS_PATH)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body(
            "tags.size()",
            is(4),
            "tags",
            hasItems(tag1.getName(), tag2.getName(), tag3.getName(), tag4.getName()));
  }
}

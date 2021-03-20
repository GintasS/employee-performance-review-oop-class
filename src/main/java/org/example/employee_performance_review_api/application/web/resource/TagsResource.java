package org.example.employee_performance_review_api.application.web.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.application.web.model.response.TagsResponse;
import org.example.employee_performance_review_api.domain.feature.FindTags;
import org.example.employee_performance_review_api.domain.model.tag.Tag;
import org.example.employee_performance_review_api.infrastructure.web.qualifiers.NoWrapRootValueObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tags")
@AllArgsConstructor
public class TagsResource {

  @NoWrapRootValueObjectMapper ObjectMapper objectMapper;
  private final FindTags findTags;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTags() throws JsonProcessingException {
    List<Tag> tags = findTags.handle();
    return Response.ok(objectMapper.writeValueAsString(new TagsResponse(tags)))
        .status(Response.Status.OK)
        .build();
  }
}
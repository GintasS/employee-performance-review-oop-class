package org.example.employee_performance_review_api.application.web.resource;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.application.web.model.request.LoginRequest;
import org.example.employee_performance_review_api.application.web.model.request.NewUserRequest;
import org.example.employee_performance_review_api.application.web.model.response.UserResponse;
import org.example.employee_performance_review_api.domain.exception.InvalidPasswordException;
import org.example.employee_performance_review_api.domain.exception.UserNotFoundException;
import org.example.employee_performance_review_api.domain.feature.CreateUser;
import org.example.employee_performance_review_api.domain.feature.LoginUser;
import org.example.employee_performance_review_api.domain.model.constants.ValidationMessages;
import org.example.employee_performance_review_api.domain.model.user.User;
import org.example.employee_performance_review_api.infrastructure.web.exception.UnauthorizedException;
import org.example.employee_performance_review_api.infrastructure.web.provider.TokenProvider;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@AllArgsConstructor
public class UsersResource {

  private final CreateUser createUser;
  private final LoginUser loginUser;
  private final TokenProvider tokenProvider;

  @POST
  @Transactional
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response create(
      @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL)
          NewUserRequest newUserRequest,
      @Context SecurityException context) {
    final var user = createUser.handle(newUserRequest.toCreateUserInput());
    final var token = tokenProvider.createUserToken(user.getId().toString());
    return Response.ok(new UserResponse(user, token)).status(Response.Status.CREATED).build();
  }

  @POST
  @Path("/login")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response login(
      @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL)
          LoginRequest loginRequest) {
    User user;
    try {
      user = loginUser.handle(loginRequest.toLoginUserInput());
    } catch (UserNotFoundException | InvalidPasswordException ex) {
      throw new UnauthorizedException();
    }
    final var token = tokenProvider.createUserToken(user.getId().toString());
    return Response.ok(new UserResponse(user, token)).status(Response.Status.OK).build();
  }
}

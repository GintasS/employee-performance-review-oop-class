package org.example.employee_performance_review_api.infrastructure.web.mapper;

import org.example.employee_performance_review_api.application.web.model.response.ErrorResponse;
import org.example.employee_performance_review_api.domain.exception.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

  private final Map<Class<? extends BusinessException>, Function<BusinessException, Response>>
      exceptionMapper;

  public BusinessExceptionMapper() {
    this.exceptionMapper = configureExceptionMapper();
  }

  private Map<Class<? extends BusinessException>, Function<BusinessException, Response>>
      configureExceptionMapper() {

    final var handlerMap =
        new HashMap<Class<? extends BusinessException>, Function<BusinessException, Response>>();

    handlerMap.put(EmailAlreadyExistsException.class, this::conflict);
    handlerMap.put(UserNotFoundException.class, this::notFound);
    handlerMap.put(InvalidPasswordException.class, this::unauthorized);
    handlerMap.put(UsernameAlreadyExistsException.class, this::conflict);
    handlerMap.put(TagNotFoundException.class, this::notFound);
    handlerMap.put(ArticleNotFoundException.class, this::notFound);
    handlerMap.put(ModelValidationException.class, this::unprocessableEntity);
    handlerMap.put(EmployeeNotFoundException.class, this::notFound);

    // TODO add custom exception mappings here

    return handlerMap;
  }

  private Response notFound(BusinessException businessException) {
    return Response.ok(errorResponse(businessException))
        .status(Response.Status.NOT_FOUND.getStatusCode())
        .build();
  }

  private Response conflict(BusinessException businessException) {
    return Response.ok(errorResponse(businessException))
        .status(Response.Status.CONFLICT.getStatusCode())
        .build();
  }

  private Response unauthorized(BusinessException businessException) {
    return Response.ok(errorResponse(businessException))
        .status(Response.Status.UNAUTHORIZED.getStatusCode())
        .build();
  }

  private Response unprocessableEntity(BusinessException businessException) {
    return Response.ok(errorResponse(businessException)).status(422).build();
  }

  private ErrorResponse errorResponse(BusinessException businessException) {
    return new ErrorResponse(businessException.getMessages());
  }

  @Override
  public Response toResponse(BusinessException businessException) {
    return this.exceptionMapper.get(businessException.getClass()).apply(businessException);
  }
}

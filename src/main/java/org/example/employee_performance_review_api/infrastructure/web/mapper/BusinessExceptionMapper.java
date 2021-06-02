package org.example.employee_performance_review_api.infrastructure.web.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.example.employee_performance_review_api.application.web.model.response.ErrorResponse;
import org.example.employee_performance_review_api.domain.exception.BusinessException;
import org.example.employee_performance_review_api.domain.exception.EmployeeNotFoundException;
import org.example.employee_performance_review_api.domain.exception.ModelValidationException;

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

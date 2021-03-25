package org.example.employee_performance_review_api.application.web.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.application.web.model.request.NewEmployeeRequest;
import org.example.employee_performance_review_api.application.web.model.request.UpdateEmployeeRequest;
import org.example.employee_performance_review_api.application.web.model.response.EmployeeResponse;
import org.example.employee_performance_review_api.application.web.resource.utils.ResourceUtils;
import org.example.employee_performance_review_api.domain.feature.*;
import org.example.employee_performance_review_api.domain.model.constants.ValidationMessages;
import org.example.employee_performance_review_api.infrastructure.web.qualifiers.NoWrapRootValueObjectMapper;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/employees")
@AllArgsConstructor
public class EmployeeResource {
  private final CreateEmployee createEmployee;
  private final FindEmployees findEmployees;
  private final FindEmployeeById findEmployeeById;
  private final DeleteEmployeeById deleteEmployeeById;
  private final UpdateEmployeeById updateEmployeeById;
  private final CalculateEmployeeBonus calculateEmployeeBonus;

  @NoWrapRootValueObjectMapper
  ObjectMapper objectMapper;
  private final ResourceUtils resourceUtils;

  @POST
  @Transactional
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response create(@Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL) NewEmployeeRequest newEmployeeRequest) {

    final var employee = createEmployee.handle(newEmployeeRequest.toNewEmployeeInput());
    return Response.ok(new EmployeeResponse(employee)).status(Response.Status.CREATED).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllEmployees() throws JsonProcessingException {
    final var employees = findEmployees.handle();

    return Response.ok(
            objectMapper.writeValueAsString(
                    resourceUtils.employeesResponse(employees)))
            .status(Response.Status.OK)
            .build();
  }


   // TODO in POSTMAN collections fix tests
   @DELETE
   @Transactional
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response delete(@PathParam("id") @NotNull(message = ValidationMessages.EMPLOYEE_ID_MUST_NOT_BE_NULL) UUID employeeId) {

      deleteEmployeeById.handle(employeeId);
      return Response.ok().build();
   }

    @PUT
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") @NotNull(message = ValidationMessages.EMPLOYEE_ID_MUST_NOT_BE_NULL) UUID employeeId,
                           @Valid @NotNull UpdateEmployeeRequest updateEmployeeRequest) {

        final var updatedEmployee = updateEmployeeById.handle(updateEmployeeRequest.toUpdateEmployeeInput(employeeId));

        return Response.ok(resourceUtils.employeeResponse(updatedEmployee))
                .status(Response.Status.OK)
                .build();
    }

    @GET
    @Transactional
    @Path("/{id}/bonus")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBonus(@PathParam("id") @NotNull(message = ValidationMessages.EMPLOYEE_ID_MUST_NOT_BE_NULL) UUID employeeId) {

        final var employee = findEmployeeById.handle(employeeId);

        final var bonus = calculateEmployeeBonus.handle(employee);

        return Response.ok(resourceUtils.employeeBonusResponse(bonus))
                .status(Response.Status.OK)
                .build();
    }

    // TODO read and update for performance rating
}

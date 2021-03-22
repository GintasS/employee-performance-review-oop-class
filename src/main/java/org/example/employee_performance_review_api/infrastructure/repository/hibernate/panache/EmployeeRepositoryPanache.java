package org.example.employee_performance_review_api.infrastructure.repository.hibernate.panache;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.domain.model.user.User;
import org.example.employee_performance_review_api.domain.model.user.UserRepository;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.EmployeeEntity;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.EntityUtils;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.UserEntity;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.panache.utils.SimpleQueryBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
@AllArgsConstructor
public class EmployeeRepositoryPanache extends AbstractPanacheRepository<EmployeeEntity, UUID>
    implements EmployeeRepository {

  private final EntityUtils entityUtils;

  @Override
  public void save(Employee employee) {
    persist(new EmployeeEntity(employee));
  }

  @Override
  public void delete(Employee employee) {
    deleteById(employee.getId());
  }

  @Override
  public void update(Employee employee) {
    final var employeeEntity = findById(employee.getId());
    employeeEntity.update(employee);
  }


  @Override
  public List<Employee> findAllEmployees() {
    return listAll().stream().map(entityUtils::employee).collect(Collectors.toList());
  }



  @Override
  public Optional<Employee> findEmployeeById(UUID id) {
    return findByIdOptional(id).map(entityUtils::employee);
  }

  // TODO Implement remaining CRUD methods.
}

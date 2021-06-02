package org.example.employee_performance_review_api.infrastructure.repository.hibernate.panache;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.EmployeeEntity;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.helpers.FileHelper;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.helpers.GenericListHelper;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.helpers.JsonHelper;

@ApplicationScoped
@AllArgsConstructor
public class EmployeeRepositoryPanache implements EmployeeRepository {

  @Override
  public void save(Employee employee) {
    var employees = findAllEmployees();
    employees.add(new EmployeeEntity(employee));

    saveAllEmployees(employees);
  }

  @Override
  public void delete(Employee employee) {

    var employees =
        findAllEmployees().stream()
            .filter(x -> UUID.fromString(x.getId()).equals(employee.getId()) == false)
            .collect(Collectors.toList());

    saveAllEmployees(employees);
  }

  @Override
  public void update(Employee employee) {
    var employees = findAllEmployees();

    Predicate<EmployeeEntity> predicate = x -> UUID.fromString(x.getId()).equals(employee.getId());
    var singleEmployeeIndex = GenericListHelper.indexOf(employees, predicate);

    if (singleEmployeeIndex != -1) {
      var singleEmployee = employees.get(singleEmployeeIndex);
      singleEmployee.update(employee);

      employees.set(singleEmployeeIndex, singleEmployee);
    }

    saveAllEmployees(employees);
  }

  @Override
  public Optional<EmployeeEntity> findEmployeeById(UUID id) {
    return findAllEmployees().stream()
        .filter(x -> UUID.fromString(x.getId()).equals(id))
        .findFirst();
  }

  @Override
  public List<EmployeeEntity> findAllEmployees() {
    var employeesString =
        FileHelper.ReadFile(
            "C:\\Users\\Gintautas\\Documents\\IntelliJIDE\\employee-performance-review-oop-class\\src\\main\\java\\org\\example\\employee_performance_review_api\\infrastructure\\repository\\hibernate\\json files\\employees.json");
    return JsonHelper.DeserializeStringToEmployees(employeesString);
  }

  @Override
  public void saveAllEmployees(List<EmployeeEntity> employees) {
    var newEmployeesString = JsonHelper.SerializeEmployeeToString(employees);
    FileHelper.WriteToFile(
        "C:\\Users\\Gintautas\\Documents\\IntelliJIDE\\employee-performance-review-oop-class\\src\\main\\java\\org\\example\\employee_performance_review_api\\infrastructure\\repository\\hibernate\\json files\\employees.json",
        newEmployeesString);
  }

  // TODO Implement remaining CRUD methods.
}

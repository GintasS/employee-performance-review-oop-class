package org.example.employee_performance_review_api.domain.model.employee;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface EmployeeRepository {

    void save(Employee employee);

    void delete(Employee employee);

    void update(Employee employee);

    List<Employee> findAllEmployees();

    Optional<Employee> findEmployeeById(UUID id);

    // boolean existsBy(String field, String value);

    //Optional<Employee> findByFullName(String firstName, String lastName);

    //Optional<Employee> findEmployeeById(UUID id);

    //boolean existsUsername(UUID excludeId, String username);

    //boolean existsEmail(UUID excludeId, String email);

    // TODO add missing methods here.

}

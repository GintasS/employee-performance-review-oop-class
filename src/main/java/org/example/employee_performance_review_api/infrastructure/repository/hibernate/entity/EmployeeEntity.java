package org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.user.User;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEES")
public class EmployeeEntity {

  @Id private UUID id;

  private String firstName;
  private String lastName;


  public EmployeeEntity(Employee employee) {
    this.id  = employee.getId();
    update(employee);
  }

  public void update(Employee employee) {
    this.firstName = employee.getFirstName();
    this.lastName = employee.getLastName();

    // TODO: finish initializing
  }
}

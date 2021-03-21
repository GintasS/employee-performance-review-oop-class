package org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.employee.Employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

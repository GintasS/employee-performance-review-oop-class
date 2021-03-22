package org.example.employee_performance_review_api.infrastructure.repository.hibernate.panache;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractPanacheRepository<ENTITY, ID> implements PanacheRepositoryBase<ENTITY, ID> {

  protected boolean isNotEmpty(List<?> list) {
    return list != null && !list.isEmpty();
  }

  protected List<String> toUpperCase(List<String> subjectList) {
    return subjectList.stream().map(String::toUpperCase).collect(Collectors.toList());
  }
}

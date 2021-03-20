package org.example.employee_performance_review_api.domain.model.article;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResult<T> {
  private List<T> result;
  private long total;
}

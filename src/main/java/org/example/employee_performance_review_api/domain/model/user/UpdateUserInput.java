package org.example.employee_performance_review_api.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UpdateUserInput {
  private UUID id;
  private String username;
  private String bio;
  private String image;
  private String email;
}

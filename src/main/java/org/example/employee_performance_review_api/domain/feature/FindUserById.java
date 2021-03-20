package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.user.User;

import java.util.UUID;

public interface FindUserById {
  User handle(UUID id);
}

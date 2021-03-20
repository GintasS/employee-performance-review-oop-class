package org.example.employee_performance_review_api.domain.model.provider;

public interface HashProvider {
  String hashPassword(String password);

  boolean checkPassword(String plaintext, String hashed);
}

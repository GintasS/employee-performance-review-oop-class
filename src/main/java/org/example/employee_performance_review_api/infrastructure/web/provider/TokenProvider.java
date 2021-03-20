package org.example.employee_performance_review_api.infrastructure.web.provider;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.example.employee_performance_review_api.infrastructure.web.security.profile.Role;

public interface TokenProvider {

  String createUserToken(String subject);

  DecodedJWT verify(String token);

  Role[] extractRoles(DecodedJWT decodedJWT);
}

package org.example.employee_performance_review_api.infrastructure.web.security.annotation;

import org.example.employee_performance_review_api.infrastructure.web.security.profile.Role;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Secured {
  Role[] value() default {};

  boolean optional() default false;
}

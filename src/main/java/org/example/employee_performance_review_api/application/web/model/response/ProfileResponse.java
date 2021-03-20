package org.example.employee_performance_review_api.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.user.User;

@Getter
@Setter
@JsonRootName("profile")
@RegisterForReflection
public class ProfileResponse {

  private String username;
  private String bio;
  private String image;
  private boolean following;

  public ProfileResponse(User user) {
    this.username = user.getUsername();
    this.bio = user.getBio();
    this.image = user.getImage();
  }
}

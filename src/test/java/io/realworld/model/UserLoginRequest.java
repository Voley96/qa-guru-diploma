package io.realworld.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserLoginRequest {
    @JsonProperty("email")
    String email;

    @JsonProperty("password")
    String password;
}

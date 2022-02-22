package io.realworld.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserLoginRequest {
    String email;

    String password;
}

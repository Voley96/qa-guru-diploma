package io.realworld.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdateRequest {

    @JsonProperty("bio")
    String bio;

}

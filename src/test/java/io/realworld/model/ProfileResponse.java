package io.realworld.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProfileResponse {

	@JsonProperty("image")
	private String image;

	@JsonProperty("following")
	private boolean following;

	@JsonProperty("bio")
	private String bio;

	@JsonProperty("username")
	private String username;
}
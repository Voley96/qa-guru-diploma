package io.realworld.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleResponse {

    @JsonProperty("tagList")
    private List<String> tagList;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("description")
    private String description;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

    @JsonProperty("favoritesCount")
    private int favoritesCount;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("favorited")
    private boolean favorited;
}
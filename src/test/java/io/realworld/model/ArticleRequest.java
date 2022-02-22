package io.realworld.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ArticleRequest {

    private List<String> tagList;

    private String description;

    private String title;

    private String body;
}
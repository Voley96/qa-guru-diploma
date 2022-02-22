package io.realworld.api.controller;

import io.qameta.allure.Step;
import io.realworld.api.client.ApiConfig;
import io.realworld.model.ArticleRequest;
import io.restassured.response.Response;

import java.util.Collections;

public class ArticlesController extends ApiController {

    public ArticlesController(ApiConfig config) {
        super(config);
    }

    @Step("Create article")
    public Response createArticle(ArticleRequest request) {
        reqSpec.addHeaders(getAuthHeader())
                .setBody(Collections.singletonMap("article", request));

        return post("/articles");
    }

    @Step("Get article by slug {slug}")
    public Response getArticle(String slug) {
        reqSpec.addHeaders(getAuthHeader())
                .addPathParam("slug", slug);

        return get("/articles/{slug}");
    }

    @Step("Update article by slug {slug}")
    public Response updateArticle(String slug, ArticleRequest request) {
        reqSpec.addHeaders(getAuthHeader())
                .addPathParam("slug", slug)
                .setBody(Collections.singletonMap("article", request));

        return put("/articles/{slug}");
    }

    @Step("Delete article by slug {slug}")
    public void deleteArticle(String slug) {
        reqSpec.addHeaders(getAuthHeader())
                .addPathParam("slug", slug);

        delete("/articles/{slug}");
    }
}

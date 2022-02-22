package io.realworld.tests.api;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.realworld.annotation.JiraIssue;
import io.realworld.annotation.Layer;
import io.realworld.api.client.ApiClient;
import io.realworld.data.TestData;
import io.realworld.model.ArticleRequest;
import io.realworld.model.ArticleResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("rest")
@Owner("oleynik")
@Feature("articles")
class ArticlesTests {

    private final ApiClient apiClient = ApiClient.api();
    private final Faker faker = new Faker();

    @Tag("api")
    @Test
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Create new article")
    void shouldCreateNewArticle() {
        ArticleRequest request = TestData.randomArticle();

        apiClient.auth().loginAsDefaultUser();

        ArticleResponse article = apiClient.articles().createArticle(request)
                .then().statusCode(200)
                .extract().body().jsonPath().getObject("article", ArticleResponse.class);

        assertEquals(request.getBody(), article.getBody());
        assertEquals(request.getDescription(), article.getDescription());
        assertEquals(request.getTitle(), article.getTitle());
        assertEquals(request.getTagList(), article.getTagList());
    }

    @Tag("api")
    @Test
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Get new article by slug")
    void shouldGetArticleBySlug() {
        apiClient.auth().loginAsDefaultUser();

        ArticleResponse newArticle = apiClient.articles().createArticle(TestData.randomArticle()).jsonPath()
                .getObject("article", ArticleResponse.class);

        ArticleResponse article = apiClient.articles().getArticle(newArticle.getSlug()).jsonPath()
                .getObject("article", ArticleResponse.class);

        assertEquals(newArticle.getSlug(), article.getSlug());
        assertEquals(newArticle.getTitle(), article.getTitle());
    }

    @Tag("api")
    @Test
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Update existing article by slug")
    void shouldUpdateArticleBySlug() {
        ArticleRequest request = TestData.randomArticle();
        apiClient.auth().loginAsDefaultUser();

        ArticleResponse newArticle = apiClient.articles().createArticle(request).jsonPath()
                .getObject("article", ArticleResponse.class);

        request.setTitle(faker.random().hex(6));
        request.setBody("Updated body");
        request.setDescription("Updated description");


        ArticleResponse article = apiClient.articles().updateArticle(newArticle.getSlug(), request).jsonPath()
                .getObject("article", ArticleResponse.class);

        assertEquals(request.getBody(), article.getBody());
        assertEquals(request.getDescription(), article.getDescription());
        assertEquals(request.getTitle(), article.getTitle());
    }

    @Tag("api")
    @Test
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Delete existing article by slug")
    void shouldDeleteBySlug() {
        apiClient.auth().loginAsDefaultUser();

        ArticleResponse newArticle = apiClient.articles().createArticle(TestData.randomArticle()).jsonPath()
                .getObject("article", ArticleResponse.class);

        apiClient.articles().deleteArticle(newArticle.getSlug());
        Response response = apiClient.articles().getArticle(newArticle.getSlug());

        assertEquals(Collections.emptyMap(), response.path("article.author"));
    }
}

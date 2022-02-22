package io.realworld.data;

import com.github.javafaker.Faker;
import io.realworld.config.app.App;
import io.realworld.model.ArticleRequest;
import io.realworld.model.UserLoginRequest;

import java.util.Arrays;

public class TestData {
    private final static Faker faker = new Faker();

    private TestData() {
    }

    public static UserLoginRequest defaultUser() {
        return UserLoginRequest.builder()
                .email(App.config.defaultLogin())
                .password(App.config.defaultPassword())
                .build();
    }

    public static ArticleRequest randomArticle() {
        return ArticleRequest.builder()
                .title(faker.random().hex(6))
                .body(faker.random().hex(20))
                .description(faker.random().hex(20))
                .tagList(Arrays.asList(faker.random().hex(5), faker.random().hex(5)))
                .build();
    }
}

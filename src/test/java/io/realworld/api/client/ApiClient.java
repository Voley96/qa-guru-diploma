package io.realworld.api.client;


import io.realworld.api.controller.ArticlesController;
import io.realworld.api.controller.AuthController;
import io.realworld.api.controller.ProfileController;

public class ApiClient {

    private ApiClient() {
    }

    public static ApiClient api() {
        return new ApiClient();
    }

    public AuthController auth() {
        return new AuthController(ApiConfig.config().build());
    }

    public ArticlesController articles() {
        return new ArticlesController(ApiConfig.config().build());
    }

    public ProfileController profile() {
        return new ProfileController(ApiConfig.config().build());
    }

}

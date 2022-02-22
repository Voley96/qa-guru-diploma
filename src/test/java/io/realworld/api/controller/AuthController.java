package io.realworld.api.controller;

import io.qameta.allure.Step;
import io.realworld.api.client.ApiConfig;
import io.realworld.data.TestData;
import io.realworld.model.UserLoginRequest;
import io.restassured.response.Response;

import java.util.Collections;

public class AuthController extends ApiController {

    public AuthController(ApiConfig config) {
        super(config);
    }

    @Step("Login with body")
    public Response login(UserLoginRequest payload) {
        reqSpec.setBody((Collections.singletonMap("user", payload)));
        Response response = post("/users/login");
        setToken(response.path("user.token"));

        return response;
    }

    @Step("Login as default user")
    public Response loginAsDefaultUser() {
        return login(TestData.defaultUser());
    }
}

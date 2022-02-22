package io.realworld.api.controller;

import io.qameta.allure.Step;
import io.realworld.api.client.ApiConfig;
import io.realworld.model.UserUpdateRequest;
import io.restassured.response.Response;

import java.util.Collections;

public class ProfileController extends ApiController {
    public ProfileController(ApiConfig config) {
        super(config);
    }

    @Step("Get profile by {username}")
    public Response getProfileInfo(String username) {
        reqSpec.addHeaders(getAuthHeader())
                .addPathParam("username", username);

        return get("/profiles/{username}");
    }

    @Step("Update user info")
    public Response updateProfile(UserUpdateRequest request) {
        reqSpec.addHeaders(getAuthHeader())
                .setBody(Collections.singletonMap("user", request));

        return put("/user");
    }
}

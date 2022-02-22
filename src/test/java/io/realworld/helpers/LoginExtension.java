package io.realworld.helpers;

import io.realworld.api.client.ApiClient;
import io.realworld.config.app.App;
import io.realworld.model.UserLoginRequest;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.open;

public class LoginExtension implements BeforeEachCallback {


    @Override
    public void beforeEach(ExtensionContext context) {
        UserLoginRequest user = UserLoginRequest.builder()
                .email(App.config.defaultLogin())
                .password(App.config.defaultPassword())
                .build();

        String authResponse = ApiClient.api().auth().login(user).path("user.token");

        open("/favicon.ico");
        localStorage().setItem("jwtToken", authResponse);
    }
}

package io.realworld.tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.realworld.annotation.JiraIssue;
import io.realworld.annotation.Layer;
import io.realworld.data.ErrorMessage;
import io.realworld.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Layer("UI")
@Owner("oleynik")
@Feature("auth")
class AuthTests extends TestBase {

    @Tag("UI")
    @Test
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Login with valid credentials")
    void shouldLoginWithValidCredentials() {
        loginPage.open()
                .typeEmail("qa.vo12345@gmail.com")
                .typePassword("123456")
                .clickSignIn()
                .getNavBar().checkUsernameEquals("oleynik96");
    }

    @Tag("UI")
    @Test
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Login with invalid credentials")
    void shouldPresentErrorMessageInvalidCredentials() {
        loginPage.open()
                .typeEmail("qa.vo12345@gmail.com")
                .typePassword("111111")
                .clickSignIn()
                .checkErrorMessagePresent(ErrorMessage.INVALID_CREDENTIALS);
    }

    @Tag("UI")
    @Test
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Login with invalid credentials. Bland password")
    void shouldPresentErrorMessageEmptyPassword() {
        loginPage.open()
                .typeEmail("qa.vo12345@gmail.com")
                .clickSignIn()
                .checkErrorMessagePresent(ErrorMessage.BLANK_PASSWORD);
    }

    @Tag("UI")
    @Test
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Login with invalid credentials. Bland email")
    void shouldPresentErrorMessageEmptyEmail() {
        loginPage.open()
                .typePassword("111111")
                .clickSignIn()
                .checkErrorMessagePresent(ErrorMessage.BLANK_EMAIL);
    }

    @Tags({@Tag("api"), @Tag("UI")})
    @Test
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Login with via API")
    void shouldLoginViaAPI() {
        step("Get auth token by API and set it to browser localstorage", () -> {

            String token = apiClient.auth().loginAsDefaultUser().path("user.token");

            step("Open minimal content, because localstorage can be set when site is opened", () ->
                    open("/favicon.ico"));

            step("Set auth token to to browser localstorage", () ->
                    localStorage().setItem("jwtToken", token));
        });
        step("Verify successful authorization", () ->
                homePage.open().getNavBar().checkUsernameEquals("oleynik96"));
    }

    @Tag("UI")
    @Test
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Login register with valid credentials")
    void shouldRegister() {
        String username = faker.name().username();

        signUpPage.open()
                .typeUserName(username)
                .typeEmail(faker.internet().emailAddress())
                .typePassword(faker.internet().password())
                .clickSignIn();

        homePage.getNavBar().checkUsernameEquals(username);
    }
}

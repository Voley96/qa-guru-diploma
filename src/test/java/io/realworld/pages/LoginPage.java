package io.realworld.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.realworld.data.ErrorMessage;
import io.realworld.pages.components.NavBar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final NavBar navBar = new NavBar();

    @Step("Open login page")
    public LoginPage open() {
        Selenide.open("/#/login");
        return this;
    }

    @Step("Get Navbar")
    public NavBar getNavBar() {
        return navBar;
    }

    @Step("Type email {email}")
    public LoginPage typeEmail(String email) {
        $("input[type='email']").setValue(email);
        return this;
    }

    @Step("Type password {password}")
    public LoginPage typePassword(String password) {
        $("input[type='password']").setValue(password);
        return this;
    }

    @Step("Click sign in button")
    public LoginPage clickSignIn() {
        $("button[type='submit']").click();
        return this;
    }

    @Step("Check error message {errorMessage} present")
    public void checkErrorMessagePresent(ErrorMessage errorMessage) {
        $(Selectors.byText(errorMessage.getErrorMessage())).shouldBe(visible);
    }
}

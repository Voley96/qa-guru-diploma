package io.realworld.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {

    @Step("Open sign up page")
    public SignUpPage open() {
        Selenide.open("/#/register");
        return this;
    }

    @Step("Type username {username}")
    public SignUpPage typeUserName(String username) {
        $("input[type='text']").setValue(username);
        return this;
    }

    @Step("Type email {email}")
    public SignUpPage typeEmail(String email) {
        $("input[type='email']").setValue(email);
        return this;
    }

    @Step("Type password {password}")
    public SignUpPage typePassword(String password) {
        $("input[type='password']").setValue(password);
        return this;
    }

    @Step("Click submit button")
    public void clickSignIn() {
        $("button[type='submit']").click();
    }
}

package io.realworld.pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NavBar {

    @Step("Go to profile page")
    public void goToProfilePage() {
        $(".user-pic").parent().click();
    }

    @Step("Check username present")
    public void checkUsernameEquals(String username) {
        $(".user-pic").parent().shouldHave(text(username));
    }
}

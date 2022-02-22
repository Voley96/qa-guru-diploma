package io.realworld.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.realworld.pages.components.NavBar;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    private final NavBar navBar = new NavBar();

    @Step("Open home page")
    public HomePage open() {
        Selenide.open("/");
        return this;
    }

    @Step("Get Navbar")
    public NavBar getNavBar() {
        return navBar;
    }

    @Step("Go to global feed")
    public HomePage goToGlobalFeed() {
        $(Selectors.byText("Global Feed")).click();
        return this;
    }

    @Step("Go to first author profile page")
    public void goToFirstAuthorProfilePage() {
        $$(".article-preview").first().$("a[ui-sref*='app.profile']").click();
    }

    @Step("Go to author {author} page")
    public void goToAuthorProfilePage(String author) {
        Selenide.open("/#/@" + author);
    }
}

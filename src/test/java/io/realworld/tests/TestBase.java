package io.realworld.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import io.realworld.api.client.ApiClient;
import io.realworld.helpers.Attach;
import io.realworld.helpers.DriverSettings;
import io.realworld.pages.HomePage;
import io.realworld.pages.LoginPage;
import io.realworld.pages.ProfilePage;
import io.realworld.pages.SignUpPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({AllureJunit5.class})
public class TestBase {

    protected LoginPage loginPage = new LoginPage();
    protected HomePage homePage = new HomePage();
    protected ProfilePage profilePage = new ProfilePage();
    protected SignUpPage signUpPage = new SignUpPage();

    protected Faker faker = new Faker();

    protected ApiClient apiClient = ApiClient.api();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

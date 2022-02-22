package io.realworld.tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.realworld.annotation.JiraIssue;
import io.realworld.annotation.Layer;
import io.realworld.annotation.WithLogin;
import io.realworld.model.UserUpdateRequest;
import io.realworld.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Layer("UI")
@Owner("oleynik")
@Feature("profile")
class ProfileTests extends TestBase {

    @Test
    @WithLogin
    @Tag("UI")
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Follow to another member")
    void shouldFollowToMember() {
        homePage.open().goToGlobalFeed().goToAuthorProfilePage("Gerome");
        profilePage.clickFollowButton().verifyFollowing();
        profilePage.clickFollowButton().verifyUnfollowing();
    }

    @Test
    @WithLogin
    @Tags({@Tag("api"), @Tag("UI")})
    @JiraIssue("HOMEWORK-316")
    @DisplayName("Edit profile. Change bio")
    void shouldEditProfile() {
        UserUpdateRequest request = UserUpdateRequest.builder()
                .bio(faker.job().field())
                .build();

        apiClient.profile().updateProfile(request);

        homePage.open().getNavBar().goToProfilePage();
        profilePage.verifyBioEquals(request.getBio());
    }
}

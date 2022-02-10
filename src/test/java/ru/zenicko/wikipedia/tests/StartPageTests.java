package ru.zenicko.wikipedia.tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class StartPageTests extends TestBase {

    @Test
    @Disabled("In progress")
    @Feature("Feature: The main page app")
    @Story("Story: Check the announcement text on the main page of app by swipe actions")
    void swapStartPageFourTimesAndGetStarted() {

    }

    @Test
    @Feature("Feature: The main page app")
    @Story("Story: Check the announcement text on the main page of app by bottom \"CONTINUE\"")
    void shouldBeTheAnnouncementTextOnTheMainPage() {
        step("Push the bottom \"CONTINUE\" three times", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Push the bottom \"GET STARTED\"", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });
        step("Check the announcement text on the main page of app", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(Condition.text("Customize your Explore feed You can now choose " +
                            "what to show on your feed, and also prioritize your favorite types of content."));
        });
    }

}


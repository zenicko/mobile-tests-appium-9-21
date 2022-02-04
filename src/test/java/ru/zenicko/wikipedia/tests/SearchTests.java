package ru.zenicko.wikipedia.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selectors;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends TestBase {
    @Test
    @Feature("Feature: search")
    @Story("Story: give a list of searching results")
    @DisplayName("Check searching result")
    void searchText() {
        back();
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");

        $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldBe(CollectionCondition.sizeGreaterThan(0));
        $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_description")).shouldBe(CollectionCondition.sizeGreaterThan(0));
        $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_image")).shouldBe(CollectionCondition.sizeGreaterThan(0));
        $$(Selectors.byClassName("android.widget.TextView")).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

}

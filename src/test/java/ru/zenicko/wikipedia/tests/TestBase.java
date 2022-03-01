package ru.zenicko.wikipedia.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.zenicko.wikipedia.helpers.attachments.Attachment;
import ru.zenicko.wikipedia.providers.TestProvider;

public class TestBase {
    Attachment addAttachments = TestProvider.getAttachment();

    @BeforeAll
    public static void SetUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = TestProvider.getNameClassOfDriver();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        Selenide.open();

    }

    @AfterEach
    public void setDown() {
        addAttachments.addAttachmets();
    }
}

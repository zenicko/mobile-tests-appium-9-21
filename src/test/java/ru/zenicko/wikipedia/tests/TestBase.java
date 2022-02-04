package ru.zenicko.wikipedia.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.zenicko.wikipedia.drivers.DriverProvider;
import ru.zenicko.wikipedia.helpers.AllureAttachments;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {

    @BeforeAll
    public static void SetUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = DriverProvider.getNameClassOfDriver();
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        AllureAttachments.addScreenshotAs("Last screenshot " + dtf.format(now));
        AllureAttachments.addPageSource();

        Selenide.closeWebDriver();

    }
}

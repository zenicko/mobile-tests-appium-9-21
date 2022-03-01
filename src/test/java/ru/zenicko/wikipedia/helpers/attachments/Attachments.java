package ru.zenicko.wikipedia.helpers.attachments;

import com.codeborne.selenide.Selenide;
import ru.zenicko.wikipedia.helpers.videourl.BrowserStack;
import ru.zenicko.wikipedia.helpers.videourl.SelenoidQaGuru;
import ru.zenicko.wikipedia.helpers.videourl.VideoUrl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Attachments {

    public static void addAttachmentsWithoutVideo() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        AllureAttachments.addScreenshotAs("Last screenshot " + dtf.format(now));
        AllureAttachments.addPageSource();
        Selenide.closeWebDriver();
    }

    public static void addAllAttachmentsWithBrowserStack() {
        String sessionId = AllureAttachments.getSessionId();
        addAttachmentsWithoutVideo();
        AllureAttachments.attachVideo(sessionId, new BrowserStack());
    }
    public static void addAllAttachmentsWithSelenoidQaGuru() {
        String sessionId = AllureAttachments.getSessionId();
        addAttachmentsWithoutVideo();
        AllureAttachments.attachVideo(sessionId, new SelenoidQaGuru());
    }
}

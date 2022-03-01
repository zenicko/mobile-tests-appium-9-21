package ru.zenicko.wikipedia.helpers.attachments;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.zenicko.wikipedia.helpers.videourl.BrowserStack;
import ru.zenicko.wikipedia.helpers.videourl.VideoUrl;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AllureAttachments {

    @Attachment(value = "{attachName}", type = "text/plain")
    private static String addMessage(String attachName, String text) {
        return text;
    }

    @Attachment(value = "Page source", type = "text/html")
    public static byte[] addPageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] addScreenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String attachVideo(String sessionId, VideoUrl videoUrl) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + videoUrl.getVideoUrl(sessionId)
                + "' type='video/mp4'></video></body></html>";
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

}

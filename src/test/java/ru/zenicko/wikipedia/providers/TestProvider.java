package ru.zenicko.wikipedia.providers;

import ru.zenicko.wikipedia.drivers.BrowserStackMobileDriver;
import ru.zenicko.wikipedia.drivers.LocalMobileDriver;
import ru.zenicko.wikipedia.drivers.SelenoidMobileDriver;
import ru.zenicko.wikipedia.helpers.attachments.Attachment;
import ru.zenicko.wikipedia.helpers.attachments.Attachments;

public class TestProvider {
    private static final String typeOfDevice = System.getProperty("typeDevice");

    public static String getNameClassOfDriver() {

        switch (typeOfDevice) {
            case "emulate":
                System.out.println("emulate");
                return LocalMobileDriver.class.getName();
            case "real":
                System.out.println("real");
                return LocalMobileDriver.class.getName();
            case "browserstack":
                System.out.println("browserstack");
                return BrowserStackMobileDriver.class.getName();
            case "selenoid":
                System.out.println("selenoid");
                return SelenoidMobileDriver.class.getName();
            default:
                throw new RuntimeException(String.format("The type of staring %s is unknown" +
                        "Choose ones of [emulate, real, browserstack], selenoid is in progressing].", typeOfDevice));
        }
    }

    public static Attachment getAttachment() {
        String typeDevice = System.getProperty("typeDevice");

        switch (typeOfDevice) {
            case "emulate":
                System.out.println("emulate");
                return Attachments::addAttachmentsWithoutVideo;
            case "real":
                System.out.println("real");
                return Attachments::addAttachmentsWithoutVideo;
            case "browserstack":
                System.out.println("browserstack");
                return Attachments::addAllAttachmentsWithBrowserStack;
            case "selenoid":
                System.out.println("selenoid");
                return Attachments::addAllAttachmentsWithSelenoidQaGuru;
            default:
                throw new RuntimeException(String.format("The type of staring %s is unknown" +
                        "Choose ones of [emulate, real, browserstack], selenoid is in progressing].", typeDevice));
        }

    }
}

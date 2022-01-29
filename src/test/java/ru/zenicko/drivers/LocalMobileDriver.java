package ru.zenicko.drivers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalMobileDriver implements CreateDriver {
    public static URL getBrowserUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("version", "11.0");

        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        desiredCapabilities.setCapability("app", "src/test/resources/apk/app-alpha-universal-release.apk");

        return new AndroidDriver(getBrowserUrl(), desiredCapabilities);
    }

}

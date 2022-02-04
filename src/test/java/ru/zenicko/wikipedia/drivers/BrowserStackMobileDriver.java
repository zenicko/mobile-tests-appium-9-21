package ru.zenicko.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static ru.zenicko.wikipedia.config.MobileDevice.mobileDeviceConfig;
import static ru.zenicko.wikipedia.config.browserstack.BrowserStack.browserStackConfig;

public class BrowserStackMobileDriver extends BaseMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", browserStackConfig.user());
        desiredCapabilities.setCapability("browserstack.key", browserStackConfig.key());
        desiredCapabilities.setCapability("browserstack.networkLogs", browserStackConfig.networkLogs());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", browserStackConfig.app());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", mobileDeviceConfig.device());
        desiredCapabilities.setCapability("os_version", mobileDeviceConfig.osVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", browserStackConfig.nameProject());
        desiredCapabilities.setCapability("build", browserStackConfig.nameBuild());
        desiredCapabilities.setCapability("name", browserStackConfig.name());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver driver = new AndroidDriver(getBrowserUrl(browserStackConfig.url()), desiredCapabilities);

        return driver;
    }

}

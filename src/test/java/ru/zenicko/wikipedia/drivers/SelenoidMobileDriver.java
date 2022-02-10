package ru.zenicko.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.zenicko.wikipedia.utils.FileUtils;

import static ru.zenicko.wikipedia.config.MobileDevice.mobileDeviceConfig;
import static ru.zenicko.wikipedia.config.local.Local.localConfig;

@Disabled("Selenide unworked. Need to test later")
public class SelenoidMobileDriver extends BaseMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("deviceName", mobileDeviceConfig.device());
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("version", mobileDeviceConfig.osVersion());

        desiredCapabilities.setCapability("locale", mobileDeviceConfig.locale());
        desiredCapabilities.setCapability("language", mobileDeviceConfig.language());

        desiredCapabilities.setCapability("appPackage", localConfig.appPackage());
        desiredCapabilities.setCapability("appActivity", localConfig.appActivity());

        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);

        desiredCapabilities.setCapability("app", FileUtils.getAbsolutePath(localConfig.pathApp()));

        return new AndroidDriver(getBrowserUrl(localConfig.url()), desiredCapabilities);
    }
}

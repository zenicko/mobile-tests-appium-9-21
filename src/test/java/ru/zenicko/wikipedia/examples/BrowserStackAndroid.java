package ru.zenicko.wikipedia.examples;

import java.net.URL;
import java.util.List;
import java.util.function.Function;
import java.net.MalformedURLException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.zenicko.wikipedia.config.browserstack.BrowserStack;

public class BrowserStackAndroid {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set your access credentials
        capabilities.setCapability("browserstack.user", BrowserStack.browserStackConfig.user());
        capabilities.setCapability("browserstack.key", BrowserStack.browserStackConfig.key());

        // Set URL of the application under test
        capabilities.setCapability("app", BrowserStack.browserStackConfig.app());

        // Specify device and os_version for testing
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        capabilities.setCapability("project", BrowserStack.browserStackConfig.nameProject());
        capabilities.setCapability("build", BrowserStack.browserStackConfig.nameBuild());
        capabilities.setCapability("name", BrowserStack.browserStackConfig.name());


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), capabilities);

        // Test case for the BrowserStack sample Android app.
        // If you have uploaded your app, update the test case here.
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);
        List<AndroidElement> allProductsName = driver.findElementsByClassName(
                "android.widget.TextView");
        assert(allProductsName.size() > 0);


        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

    }
}
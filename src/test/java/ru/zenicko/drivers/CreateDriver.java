package ru.zenicko.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface CreateDriver {
    WebDriver createDriver(DesiredCapabilities desiredCapabilities);
}

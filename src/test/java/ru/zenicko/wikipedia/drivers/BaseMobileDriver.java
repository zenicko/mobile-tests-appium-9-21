package ru.zenicko.wikipedia.drivers;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseMobileDriver {
    public static URL getBrowserUrl(String pathMobileDriver) {
        try {
            return new URL(pathMobileDriver);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}

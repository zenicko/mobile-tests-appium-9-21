package ru.zenicko.wikipedia.config.browserstack;

import org.aeonbits.owner.ConfigFactory;

public class BrowserStack {
    public static BrowserStackConfig browserStackConfig = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

}

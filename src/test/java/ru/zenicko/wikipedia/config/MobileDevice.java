package ru.zenicko.wikipedia.config;

import org.aeonbits.owner.ConfigFactory;

public class MobileDevice {

    public static MobileDeviceConfig mobileDeviceConfig = ConfigFactory.create(MobileDeviceConfig.class, System.getProperties());
}

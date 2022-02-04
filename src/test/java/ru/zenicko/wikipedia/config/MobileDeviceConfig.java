package ru.zenicko.wikipedia.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${locationDevice}/${typeDevice}/mobiledevice.properties"
})
public interface MobileDeviceConfig extends Config {

    @Key("udid")
    String udid();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("locale")
    String locale();

    @Key("language")
    String language();
}

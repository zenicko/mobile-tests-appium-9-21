package ru.zenicko.wikipedia.config.local;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${locationDevice}/local.properties"
})
public interface LocalConfig extends Config {
    @Key("local.appPackage")
    String appPackage();

    @Key("local.appActivity")
    String appActivity();

    @Key("local.path.app")
    String pathApp();

    @Key("local.url")
    String url();
}


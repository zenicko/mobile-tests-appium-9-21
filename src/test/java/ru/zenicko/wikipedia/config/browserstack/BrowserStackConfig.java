package ru.zenicko.wikipedia.config.browserstack;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/remote/browserstack/browserstack.properties"
})
public interface BrowserStackConfig extends Config {

    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @Key("browserstack.networkLogs")
    boolean networkLogs();

    @Key("browserstack.app")
    String app();

    @Key("browserstack.url")
    String url();

    @Key("browserstack.url.statSession")
    String urlStatSession();

    @Key("browserstack.project")
    String nameProject();

    @Key("browserstack.build")
    String nameBuild();

    @Key("browserstack.name")
    String name();

}

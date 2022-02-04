package ru.zenicko.wikipedia.config.local;

import org.aeonbits.owner.ConfigFactory;

public class Local {
    public static LocalConfig localConfig = ConfigFactory.create(LocalConfig.class, System.getProperties());
}

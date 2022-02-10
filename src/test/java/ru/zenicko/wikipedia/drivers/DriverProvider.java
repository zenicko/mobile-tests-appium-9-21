package ru.zenicko.wikipedia.drivers;

@Deprecated
public class DriverProvider {
    public static String getNameClassOfDriver() {
        String typeDevice = System.getProperty("typeDevice");

        switch (typeDevice) {
            case "emulate":
                System.out.println("emulate");
                return LocalMobileDriver.class.getName();
            case "real":
                System.out.println("real");
                return LocalMobileDriver.class.getName();
            case "browserstack":
                System.out.println("browserstack");
                return BrowserStackMobileDriver.class.getName();
            case "selenoid":
                System.out.println("selenoid");
                return SelenoidMobileDriver.class.getName();
            default:
                throw new RuntimeException(String.format("The type of staring %s is unknown" +
                        "Choose ones of [emulate, real, browserstack], selenoid is in progressing].", typeDevice));
        }

    }
}

package ru.zenicko.wikipedia.drivers;

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
                return BrowserStackMobileDriver.class.getName();
            case "selenoid":
                throw new RuntimeException(String.format("In progressing. Choose ones of [emulate, real, browserstack]"));
            default:
                throw new RuntimeException(String.format("The type of staring %s is unknown" +
                        "Choose ones of [emulate, real, browserstack], selenoid is in progressing].", typeDevice));
        }

    }
}

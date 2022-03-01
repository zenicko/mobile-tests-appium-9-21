package ru.zenicko.wikipedia.helpers.videourl;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidQaGuru implements VideoUrl {

    public String getVideoUrl(String sessionId) {
        try {
            return new URL("https://selenoid.autotests.cloud/video/" + sessionId + ".mp4") + "";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

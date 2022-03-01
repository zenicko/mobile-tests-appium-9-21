package ru.zenicko.wikipedia.helpers.videourl;

import static io.restassured.RestAssured.given;
import static ru.zenicko.wikipedia.config.browserstack.BrowserStack.browserStackConfig;

public class BrowserStack implements VideoUrl {
    public String getVideoUrl(String sessionId) {
        return given()
                .auth().basic(browserStackConfig.user(), browserStackConfig.key())
                .when()
                .get(browserStackConfig.urlStatSession() + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}

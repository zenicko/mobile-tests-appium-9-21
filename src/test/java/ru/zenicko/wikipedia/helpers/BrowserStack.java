package ru.zenicko.wikipedia.helpers;

import static io.restassured.RestAssured.given;
import static ru.zenicko.wikipedia.config.browserstack.BrowserStack.browserStackConfig;

public class BrowserStack {
    public static String videoUrl(String sessionId) {
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

package helpers;

import config.Project;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserStackUtils {

    public static String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .auth().basic(Project.config.bsusername(), Project.config.bspassword())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}

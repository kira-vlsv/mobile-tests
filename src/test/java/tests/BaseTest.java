package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Project;
import driver.DriverManager;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static config.Project.isVideoOn;
import static driver.Drivers.LOCAL;
import static io.qameta.allure.Allure.step;

public abstract class BaseTest {

    @BeforeAll
    static void beforeAll() {
        DriverManager driverManager = DriverManager.createDriver(Project.config.driver());
        Configuration.browser = driverManager.getClass().getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();

        if (Project.config.driver().equals(LOCAL.getValue())) {
            step("Click on skip when start app", Selenide::back);
        }
    }

    @AfterEach
    void afterEach() {
        String sessionId = sessionId().toString();
        AllureAttachments.pageSource();
        closeWebDriver();

        if (isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}

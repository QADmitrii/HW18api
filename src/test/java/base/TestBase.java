package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import helper.Attach;


public class TestBase {

    @BeforeAll
    static void config() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (System.getProperty("selenide.remote") != null) {
            Configuration.remote = System.getProperty("selenide.remote");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
        Configuration.browserCapabilities = capabilities;

        ConfigProvider config = new ConfigProvider();
        config.setConfiguration("remote"); // конфиг для удаленного запуска
//        config.setConfiguration("local"); // раскомментить для локального запуска
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotsAs("Last screenshot");
        Attach.pageSource();
        if (Configuration.browser.equals("chrome")) {
            Attach.browserConsoleLogs();
        }
        if (System.getProperty("selenide.remote") != null) {
            Attach.addVideo();
        }
    }
}

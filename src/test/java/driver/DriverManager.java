package driver;

import com.codeborne.selenide.WebDriverProvider;

import static driver.Drivers.BROWSER_STACK;
import static driver.Drivers.LOCAL;

public interface DriverManager extends WebDriverProvider {

    static DriverManager createDriver(String driver) {
        if (driver.equals(LOCAL.getValue())) {
            return new LocalMobileDriver();
        } else if (driver.equals(BROWSER_STACK.getValue())) {
            return new BrowserStackDriver();
        } else {
            throw new IllegalArgumentException("Driver is not found");
        }
    }
}

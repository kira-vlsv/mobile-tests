package config;

import org.aeonbits.owner.ConfigFactory;

import static driver.Drivers.BROWSER_STACK;

public class Project {

    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isVideoOn() {
        return Project.config.driver().equals(BROWSER_STACK.getValue());
    }
}

package spring.selenium.demo.driver;

import org.openqa.selenium.WebDriver;
import spring.selenium.demo.config.ConfigReader;

public interface DriverFactory {

    String BROWSER_TYPE = ConfigReader.getProperty("browser");
    boolean HEADLESS_MODE = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
    boolean FULLSCREEN = Boolean.parseBoolean(ConfigReader.getProperty("fullscreen"));
    int WIDTH = Integer.parseInt(ConfigReader.getProperty("width"));
    int HEIGHT = Integer.parseInt(ConfigReader.getProperty("height"));

    ThreadLocal<DriverFactoryImplementation> driverFactorySingleton = new ThreadLocal<>();
    ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    WebDriver getDriver();
    void removeDriver();

}

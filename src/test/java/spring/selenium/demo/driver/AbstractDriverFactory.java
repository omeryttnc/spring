package spring.selenium.demo.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDriverFactory implements DriverFactory{

    private static final Logger LOG = LoggerFactory.getLogger(AbstractDriverFactory.class);

    protected static void setDriver(){
        LOG.trace("Web driver is set...  ***  " + Thread.currentThread().getId());
            if(System.getProperty("os.name").equals("Windows 10")){
                switch (BROWSER_TYPE){
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        if(HEADLESS_MODE){
                            firefoxOptions.addArguments("headless");
                            firefoxOptions.addArguments("disable-gpu");
                            firefoxOptions.addArguments("--no-sandbox");
                            webDriver.set(new FirefoxDriver(firefoxOptions));
                            break;
                        }
                        FirefoxDriver firefoxDriver = new FirefoxDriver();
                        if(FULLSCREEN){
                            firefoxDriver.manage().window().maximize();
                        } else {
                            Dimension dimension = new Dimension(WIDTH, HEIGHT);
                            firefoxDriver.manage().window().setSize(dimension);
                        }
                        webDriver.set(firefoxDriver);
                        break;
                    case "ie":
                        webDriver.set(new InternetExplorerDriver());
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        if(HEADLESS_MODE){
                            EdgeOptions options = new EdgeOptions();
                            webDriver.set(new EdgeDriver(options));
                        } else {
                            webDriver.set(new EdgeDriver());
                        }
                        break;
                    case "opera":
                        WebDriverManager.operadriver().setup();
                        OperaDriver driver = new OperaDriver();
                        if(FULLSCREEN){
                            driver.manage().window().maximize();
                        } else {
                            Dimension dimension = new Dimension(WIDTH, HEIGHT);
                            driver.manage().window().setSize(dimension);
                        }
                        webDriver.set(driver);
                        break;
//                    case "aws":
//                        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
//                        ChromeOptions optionsAWS = new ChromeOptions();
//                        optionsAWS.addArguments("disable-gpu");
//                        optionsAWS.setHeadless(true);
//                        optionsAWS.addArguments("--no-sandbox");
//                        optionsAWS.addArguments("headless");
//                        optionsAWS.addArguments("--disable-dev-shm-usage");
//                        optionsAWS.addArguments("--disable-extensions");
//                        optionsAWS.addArguments("--allow-insecure-localhost");
//                        optionsAWS.addArguments("--single-process");
//                        webDriver.set(new ChromeDriver(optionsAWS));
//                        break;
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                       // System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/Documents/seleniumdependencies/chromedriver.exe");
                        ChromeOptions options = new ChromeOptions();
                        if(HEADLESS_MODE){
                            options.addArguments("headless");
                            options.addArguments("disable-gpu");
                            options.addArguments("--no-sandbox");
                            webDriver.set(new ChromeDriver(options));
                            break;
                        }
                        ChromeDriver chromeDriver = new ChromeDriver();
                        if(FULLSCREEN){
                            chromeDriver.manage().window().maximize();
                        } else {
                            Dimension dimension = new Dimension(WIDTH, HEIGHT);
                            chromeDriver.manage().window().setSize(dimension);
                        }
                        webDriver.set(chromeDriver);
                        break;
                }
            } else {
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                ChromeOptions optionsAWS = new ChromeOptions();
                optionsAWS.addArguments("disable-gpu");
                optionsAWS.setHeadless(true);
                optionsAWS.addArguments("--no-sandbox");
                optionsAWS.addArguments("headless");
                optionsAWS.addArguments("--disable-dev-shm-usage");
                optionsAWS.addArguments("--disable-extensions");
                optionsAWS.addArguments("--allow-insecure-localhost");
                optionsAWS.addArguments("--single-process");
                webDriver.set(new ChromeDriver(optionsAWS));
            }



    }
}

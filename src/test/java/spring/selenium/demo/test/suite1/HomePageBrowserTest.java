package spring.selenium.demo.test.suite1;


import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import spring.selenium.demo.config.TestResultLoggerExtension;
import spring.selenium.demo.driver.DriverFactoryImplementation;
import spring.selenium.demo.pages.PageFactory;
import spring.selenium.demo.test.BrowserTestBase;
import spring.selenium.demo.util.ReusableMethods;

@SpringBootTest
@Epic("EP001")
@Story("US001")
@ExtendWith(TestResultLoggerExtension.class)
public class HomePageBrowserTest extends BrowserTestBase {

    @Value("${appUrl}")
    private String HOME_PAGE;

    @Autowired
    protected PageFactory pageFactory;

    @Test
    @DisplayName("TC001001")
    public void OpenBrowser1()  {
        LOG.info("open browser for TC001001 test =>>  " + Thread.currentThread().getId());
        DriverFactoryImplementation.getInstance().getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                                "Page title is not correct");
        pageFactory.getHomePage().searchBox.sendKeys("kavgam");
        actions.sendKeys(Keys.ENTER).perform();
    }


    @Test
    @DisplayName("TC001002")
    public void OpenBrowser2()  {
        LOG.info("open browser for TC001002 test =>>  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        pageFactory.getHomePage().searchBox.sendKeys("nutuk");
        actions.sendKeys(Keys.ENTER).perform();
    }
    @Test
    @DisplayName("TC001003")
    public void OpenBrowser3()  {
        LOG.info("open browser for TC001003 test =>>  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        pageFactory.getHomePage().searchBox.sendKeys("ingilizce");
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(10);
    }

    @Test
    @DisplayName("TC001004")
    public void OpenBrowser4()  {
        LOG.info("open browser for TC001004 test =>>  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        pageFactory.getHomePage().searchBox.sendKeys("almanca");
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
    }
    @Test
    @DisplayName("TC001005")
    public void OpenBrowser5()  {
        LOG.info("open browser for TC001005 test =>>  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        pageFactory.getHomePage().searchBox.sendKeys("yunanca");
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(5);
    }





}
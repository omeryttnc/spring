package spring.selenium.demo.test.suite1;


import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import spring.selenium.demo.config.TestResultLoggerExtension;
import spring.selenium.demo.test.BrowserTestBase;

@SpringBootTest
@Epic("EP001")
@Story("US002")
@ExtendWith(TestResultLoggerExtension.class)
public class HomePage2BrowserTest extends BrowserTestBase {

    @Value("${appUrl}")
    private String HOME_PAGE;




    @Test
    @DisplayName("TC002001")
    public void OpenBrowser1()  {
        LOG.info("open browser TC002001 test ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        elements.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }
    @Test
    @DisplayName("TC002002")
    public void OpenBrowser2()  {
        LOG.info("open browser TC002002 test  ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        elements.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
        System.out.println("dd");
    }
    @Test
    @DisplayName("TC002003")
    public void OpenBrowser3()  {
        LOG.info("open browser TC002003 test  ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        elements.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }
    @Test
    @DisplayName("TC002004")
    public void OpenBrowser4()  {
        LOG.info("open browser TC002004 test  ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        elements.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Test
    @DisplayName("TC002005")
    public void OpenBrowser5()  {
        LOG.info("open browser TC002005 test  ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        elements.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }




}
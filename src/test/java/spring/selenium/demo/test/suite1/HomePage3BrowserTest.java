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
import spring.selenium.demo.pages.PageFactory;
import spring.selenium.demo.test.BrowserTestBase;

@SpringBootTest
@Epic("EP001")
@Story("US003")
@ExtendWith(TestResultLoggerExtension.class)
public class HomePage3BrowserTest extends BrowserTestBase {

    @Value("${appUrl}")
    private String HOME_PAGE;

    @Autowired
    PageFactory pageFactory;


    @Test
    @DisplayName("TC003001")
    public void OpenBrowser1()  {
        LOG.info("open browser TC003001 test ***  " + Thread.currentThread().getId());
        webDriverForTest.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(webDriverForTest.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        pageFactory.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }
    @Test
    @DisplayName("TC003002")
    public void OpenBrowser2()  {
        LOG.info("open browser TC003002 test  ***  " + Thread.currentThread().getId());
        webDriverForTest.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(webDriverForTest.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        pageFactory.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }
    @Test
    @DisplayName("TC003003")
    public void OpenBrowser3()  {
        LOG.info("open browser TC003003 test  ***  " + Thread.currentThread().getId());
        webDriverForTest.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(webDriverForTest.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        pageFactory.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }
    @Test
    @DisplayName("TC003004")
    public void OpenBrowser4()  {
        LOG.info("open browser TC003004 test  ***  " + Thread.currentThread().getId());
        webDriverForTest.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(webDriverForTest.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        pageFactory.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }







}
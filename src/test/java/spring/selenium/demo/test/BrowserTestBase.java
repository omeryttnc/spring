package spring.selenium.demo.test;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.selenium.demo.config.TestResultLoggerExtension;
import spring.selenium.demo.driver.DriverFactory;
import spring.selenium.demo.driver.DriverFactoryImplementation;
import spring.selenium.demo.pages.PageFactory;

import java.util.concurrent.TimeUnit;
@SpringBootTest
@ExtendWith(TestResultLoggerExtension.class)
public class BrowserTestBase {

    protected final Actions actions = new Actions(DriverFactoryImplementation.getInstance().getDriver());
    protected static final Logger LOG = LoggerFactory.getLogger(BrowserTestBase.class);
    protected final DriverFactory webDriverForTest = new DriverFactoryImplementation();

    @Autowired
    protected PageFactory pageFactory;

    @Before
    public void before() {
        LOG.info("before method initialized.. thread ID => " + Thread.currentThread().getId());
        webDriverForTest.getDriver().manage().timeouts().implicitlyWait(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown () {
        LOG.info("tear down method worked.. thread ID =>  " + Thread.currentThread().getId());
        webDriverForTest.removeDriver();
    }



}

package spring.selenium.demo.util;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spring.selenium.demo.config.TestResultLoggerExtension;
import spring.selenium.demo.driver.DriverFactoryImplementation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@ExtendWith(TestResultLoggerExtension.class)
public abstract class ReusableMethods {


    private static final Logger LOG = LoggerFactory.getLogger(ReusableMethods.class);

    public static void awsPageWait(String name){
        int count=0;
        while(count<10)
        {
            try {
                DriverFactoryImplementation.getInstance().getDriver().manage().timeouts().implicitlyWait(Integer.MAX_VALUE, TimeUnit.SECONDS);
                DriverFactoryImplementation.getInstance().getDriver().get(name);
                count=count+1;
            }
            catch(Exception e) {
                count=count+1;
                LOG.warn("....times out....count: " + count );
            }
        }
    }



    public static String getScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) DriverFactoryImplementation.getInstance().getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    //========Switching Window=====//
    public static void switchToWindow(String targetTitle) {
        String origin = DriverFactoryImplementation.getInstance().getDriver().getWindowHandle();
        for (String handle : DriverFactoryImplementation.getInstance().getDriver().getWindowHandles()) {
            DriverFactoryImplementation.getInstance().getDriver().switchTo().window(handle);
            if (DriverFactoryImplementation.getInstance().getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        DriverFactoryImplementation.getInstance().getDriver().switchTo().window(origin);
    }

    //========Hover Over=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(DriverFactoryImplementation.getInstance().getDriver());
        actions.moveToElement(element).perform();
    }

    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = DriverFactoryImplementation.getInstance().getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //===============Explicit Wait==============//
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    //======Fluent Wait====//
//    public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
//        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getWebDriver())
//                .withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS)
//                .ignoring(NoSuchElementException.class);
//        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return webElement;
//            }
//        });
//        return element;
//    }

    //======== Slider Ayarlama =========//
    public static void setSliderBall(WebElement element, int sliderStartPoint, int target) {
        Actions actions = new Actions(DriverFactoryImplementation.getInstance().getDriver());
        String value = "";
        actions.clickAndHold(element).perform();
        for (int i = 0; i < sliderStartPoint; i++) {
            if (sliderStartPoint > 0) {
                actions.sendKeys(Keys.ARROW_LEFT).perform();
            }
            value = element.getAttribute("value");
            if (value.equals("0")) {
                for (int j = 0; j < target; j++) {
                    actions.sendKeys(Keys.ARROW_RIGHT).perform();
                }
            }
        }
    }

    // ======= RGB to HEX ==== //

    public static String getHexColor(WebElement element, String cssValue) {
        String color = element.getCssValue(cssValue);
        String hex = "";
        int r, g, b = 0;
        if (color.contains("rgba")) {
            String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
            r = Integer.parseInt(numbers[0].trim());
            g = Integer.parseInt(numbers[1].trim());
            b = Integer.parseInt(numbers[2].trim());
            hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
        } else {
            String[] numbers = color.replace("rgb(", "").replace(")", "").split(",");
            r = Integer.parseInt(numbers[0].trim());
            g = Integer.parseInt(numbers[1].trim());
            b = Integer.parseInt(numbers[2].trim());
            hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
        }
        return hex;
    }

    //---------Random String-------------//
    public static String randomString (int number){
        Random ran = new Random();
        String data ="";
        for (int i=0;i<number;i++){
            int x = ran.nextInt(25) + 97;
            data = data + (char)(x);
        }
        return data;
    }
    //---------Random Integer-------------//
    public static int randomInteger (int number){
        Random ran = new Random();
        int x = ran.nextInt(number) + 0;
        return x;
    }




}
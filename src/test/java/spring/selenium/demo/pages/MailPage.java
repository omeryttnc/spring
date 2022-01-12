package spring.selenium.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spring.selenium.demo.driver.DriverFactoryImplementation;

import java.util.List;

public class MailPage {

    public MailPage() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='inbox']/h2")
    public WebElement mail_address;

    @FindBy(xpath = "//div[@class='inbox']/h3")
    public WebElement new_message_count;

    @FindBy(xpath = "//strong[@class='ng-binding']")
    public List<WebElement> all_message;

    @FindBy(xpath = "(//div[@class='column'])")
    public WebElement message;



}

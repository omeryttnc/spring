package spring.selenium.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spring.selenium.demo.driver.DriverFactoryImplementation;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='QS5gu sy4vM'])[2]")
    public WebElement accept;
    @FindBy(xpath = "//input[@id='search-input']")
    public WebElement searchBox;
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    public WebElement googleSearchBox;
    @FindBy(xpath = "//div[@id='faceted-search-list-total']")
    public WebElement searchResultsText;

}

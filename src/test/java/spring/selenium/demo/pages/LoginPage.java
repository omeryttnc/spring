package spring.selenium.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spring.selenium.demo.driver.DriverFactoryImplementation;

import java.util.List;

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


    @FindBy(xpath = "(//a[contains(text(),'Login')])[1]")
    public WebElement firstLogin;

    @FindBy(linkText = "Login")
    public WebElement loginLink;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement loginEmailBox;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement loginPasswordBox;

    @FindBy(xpath = "//button[@class='btn alazea-btn']")
    public WebElement loginButton;

    @FindBy (xpath="//div[@class='Toastify__toast Toastify__toast--error']")
    public WebElement hataMesaji;

    @FindBy(xpath = "//div[@class='MapNavbar_iconsContainer__1SZiu']")
    public List<WebElement> loginMenuList;

    @FindBy(linkText = "Logout")
    public WebElement logoutLink;

    @FindBy(xpath = "//*[@class='Navbar_textLink__f6_Al cursor-pointer ml-4 mr-3 text-capitalize']")
    public WebElement loggedInUserName;

    @FindBy(xpath ="(//div[@class='text-center pr-0 SocialLogins_login_btn__2b3rz'])[1]")
    public WebElement googleLink;

    @FindBy(xpath = "(//div[@class='text-center pr-0 SocialLogins_login_btn__2b3rz'])[2]")
    public WebElement facebookLink;

    @FindBy(xpath ="(//div[@class='text-center pr-0 SocialLogins_login_btn__2b3rz'])[3]")
    public WebElement appleLink;

    @FindBy(xpath = "//a[@class='col-6 AuthLayout_tab_header__a1Lli AuthLayout_tab_header_active__38vIi']]")
    public WebElement loginsection;


}

package spring.selenium.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spring.selenium.demo.driver.DriverFactoryImplementation;

import java.util.List;


public class HomePage {


    public HomePage() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='QS5gu sy4vM'])[2]")
    public WebElement accept;
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;
    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    public WebElement googleSearchBox;
    @FindBy(xpath = "//div[@id='faceted-search-list-total']")
    public WebElement searchResultsText;


    @FindBy(css = " a > div > svg")
    public WebElement logo;
    @FindBy(className = "Navbar_navbar-anchor__2WQhH")
    public WebElement supportButton;
    @FindBy(className = "Navbar_linkContainer__2jWIM")
    public List<WebElement> menuBarList;
    @FindBy(xpath = "//div[@class='MapNavbar_iconsContainer__1SZiu']")
    public WebElement categoriesBarList;
    @FindBy(xpath = "//div[@class='Navbar_addHub__USGHm']")
    public WebElement startSellingButton;
    @FindBy(xpath = "//div[.='Start earning by selling your gardening products']")
    public WebElement startSellingMessage;
    @FindBy(xpath = "//span[@class='Navbar_cartText__1jkrK']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='BasketDropdown_container__15BpD]")
    public WebElement cartButtonMoveTo;
    @FindBy(css = "#__next > div:nth-child(4) > div.Navbar_navbarContainer__1aspX.sticky-top > div.Navbar_linkContainer__2jWIM > div.d-flex.justify-content-center.align-items-center > div:nth-child(3) > div")
    public WebElement cartText;

    @FindBy(xpath = "//tbody[1]")
    public WebElement getTableInfo;
    @FindBy(xpath = "//div[@class='BasketDropdown_container__15BpD']")
    public WebElement moveAndGetInfoCart;


    @FindBy(xpath = "//th[@class='py-3 align-middle']")
    public WebElement selectedProductSee;
    @FindBy(xpath = "//*[@id='searchMapButton']")
    public WebElement homeSearchBox;
    @FindBy(xpath = "//*[@id='mapSearchBox']")
    public WebElement productSearchBox;
    @FindBy(id = "location")
    public WebElement distanceSearchBox;
    @FindBy(xpath = "//*[@id='location']/option[3]")
    public WebElement searchInMiles;
    @FindBy(id = "allCategories")
    public WebElement categoriesSearchBox;
    @FindBy(xpath = "//*[@id='allCategories']/option[2]")
    public WebElement searchCategoriesList;
    @FindBy(xpath = "//button[@class='btn p-0 SearchBarOptions_sliderButton__1oak8']")
    public WebElement searchFilterButton;
    @FindBy(id = "deliveryFilterAny")
    public WebElement deliveryTypeBox;
    @FindBy(id = "unitTypeFilterAny")
    public WebElement unitTypeBox;
    @FindBy(id = "searchMapButton")
    public WebElement searchButton;
    @FindBy(xpath = "//span[@class='SearchBarOptions_slider__1xZ3L SearchBarOptions_round__3BMhA']")
    public WebElement onlyOrganicSwicthButton;
    @FindBy(xpath = "//div[@class='Results_ratingDropdown__14Ksc']")
    public WebElement ratingDropDown;
    @FindBy(xpath = "//div[@class='Results_favouriteIcon__3YKpD']")
    public WebElement favoriteButton;
    @FindBy(id = "productSortSelect")
    public WebElement sortByDropDown;
    @FindBy(xpath = "//button[@class='btn p-0 ml-2 Results_sliderButton__1whxf']")
    public WebElement localSellerFilterButton;
    @FindBy(xpath = "//*[contains(text(),'There is no local grower in this view.')]")
    public WebElement beFirstMessaage;
    @FindBy(xpath = "//span[@class='btn alazea-btn w-100']")
    public WebElement beFirstButton;
    @FindBy(xpath = "//div[@aria-roledescription='map']")
    public WebElement map;
    @FindBy(id = "buttonTop")
    public WebElement searchButtonOnMap;
    @FindBy(xpath = "//div[@title='Current Location']")
    public WebElement currentLocationSign;
    @FindBy(xpath = "//span[@class='Event_eventBarText__2R8Yg']")
    public WebElement eventsBar;
    @FindBy(xpath = "//p[@class='Event_containerTopTitle__2TP-0']")
    public List<WebElement> eventsListONBar;
    @FindBy(xpath = "//p[@class='Event_eventsHeaderTitle__3Mcqk']")
    public WebElement eventsHeaderOnBarList;
    @FindBy(xpath = "(//div[@class='Event_cardContainer__2lFgq'])[1]")
    public WebElement firstEventDetailsOnEventBar;
    @FindBy(xpath = "//button[@class='Event_buttonRegister__1SHDV']")
    public WebElement eventsBarListRegisterButton;
    @FindBy(xpath = "(//span[@class='Notifications_notificationIconContainer__2jS5E'])[1]")
    public WebElement notificationButton;
    @FindBy(css = "a.Navbar_textLink__f6_Al.ml-2.mr-4")
    public WebElement logoutButton;
    @FindBy(xpath = "//html/head/title")
    public WebElement title;
    @FindBy(xpath = "//button[@class='col-12 mt-2 w-75 btn btn-success ProductCard_addCartBtn___oxgf'][2]")
    public WebElement availableTradeButton;
    @FindBy(xpath = "//button[@class='col-12 mt-2 w-75 btn btn-success FeaturedProductCard_addCartBtn__2QCpK'][2]")
    public WebElement tradeButtonInCart;
    @FindBy(xpath = "//input[@class='Chat_input__1XjY8']")
    public WebElement messageLine;
    @FindBy(xpath = "//*[@class='col-8 pb-5 Chat_conversation_card_container__D00UY']")
    public List<WebElement> messageText;
    @FindBy(xpath = "//div[contains(@class,'col-4' )and contains(@class,'D00')]/div")
    public List<WebElement> chatBuyer;

    @FindBy(xpath = "//div[contains(@class,'1R')]")
    public WebElement chatButton;

    @FindBy(css = ".Chat_input__1XjY8")
    public WebElement enter_to_send;

    @FindBy(css = ".Chat_conversation_card_container__D00UY > div > i")
    public List<WebElement> last_message_time;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart') and contains(@class,'col-12')]")
    public List<WebElement> addToCart_List;

    @FindBy(xpath = "//div[contains(@class,'pr')]//p[(@class='ProductCard_productTitle__3K4rg')]")
    public List<WebElement> productName_List;

    @FindBy(xpath = "//span[@class='h4']")
    public WebElement popUp;

    @FindBy(xpath = "//span[contains(@class,'badge')]")
    public WebElement messageCount;

    @FindBy(css = "div.row.d-flex.justify-content-center > div > input")
    public List<WebElement> add_amount_to_cart;




    @FindBy(xpath = "(//a[contains(@class,'mr')])[1]")
    public WebElement n_about_us;

    @FindBy(xpath = "(//a[contains(@class,'mr')])[2]")
    public WebElement n_login;

    @FindBy(xpath = "(//a[contains(@class,'mr')])[3]")
    public WebElement n_register;
    @FindBy(css = "[name='message']")
    public WebElement n_send_chat_message;
    @FindBy(css = "#rw-messages > div.rw-group-message.rw-from-response > div > div > div > div > p")
    public WebElement n_first_response;

    @FindBy(xpath = "//button[contains(@class,'')]")
    public List<WebElement> n_button;

    @FindBy(css = "p.ProductCard_userName__MaY5h")
    public List<WebElement> saticiIsimleri;

    @FindBy(css = ".col-11.pb-2.pt-2.text-center")
    public WebElement popup_link;

    @FindBy(linkText = "Weekly order")
    public WebElement weeklyorder;

    @FindBy(xpath = "//div[@class='Notifications_notificationNavContent__2SCct'][1]")
    public WebElement notification;

    @FindBy(xpath = "//button[@class='btn p-0 SearchBarOptions_sliderButton__1oak8']")
    public WebElement homebutton;

    @FindBy(xpath = "//div[@class='undefined custom-control mr-sm-2']")
    public WebElement choses;

    @FindBy(xpath ="//div[@class='Footer_footer-container__3MCq-']")
    public WebElement footers;

    @FindBy(xpath ="(//a[@ href='/auth/register'])[6]")
    public WebElement homeFooter;

    @FindBy(linkText ="coming soon")
    public WebElement comingSoon;

    @FindBy(xpath ="//a[@href='/about']")
    public WebElement aboutfooter;

    @FindBy(xpath ="//a[@href='/privacy_policy']")
    public WebElement privacy_policy;

    @FindBy(xpath ="//a[@ href='/terms_of_service']")
    public WebElement terms_of_service;

    @FindBy(xpath ="//a[@ href='https://www.facebook.com/urbanicfarmstead']")
    public WebElement facebookFooter;

    @FindBy(xpath ="//a[@ href='https://www.linkedin.com/company/urbanicfarm/']")
    public WebElement linkedinFooter;


}

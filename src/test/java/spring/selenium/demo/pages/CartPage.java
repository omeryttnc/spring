package spring.selenium.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spring.selenium.demo.driver.DriverFactoryImplementation;

import java.util.List;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);
    }
    @FindBy(xpath = "//div[contains(text(),'Your cart is empty')]")
    public WebElement cartIsEmpty;

    @FindBy(xpath = "//button[text()='Yes']")
    public WebElement confirmToDelete;

    @FindBy(xpath = "//td[@class='py-3 align-middle text-end']/*[local-name()='svg']")
    public List<WebElement> removeItemFromCart;

    @FindBy(xpath = "//table/tbody/tr/td[5]")
    public List<WebElement> removeItemFromCartSon;

    @FindBy(xpath = "//th[contains(@class,'middle')]")
    public List<WebElement> productNames_intheCart_list;

    @FindBy(css = "p.review_review__sub--container__1V1uj")
    public List<WebElement> proceed_saticiList;

    @FindBy(xpath = "//div[contains(@class,'review_review--container__2ItAx')]/div")
    public List<WebElement> proceed_productList;

    @FindBy(xpath = "//div[@class='d-flex flex-column justify-content-center align-items-center cursor-pointer']")
    public List<WebElement> saticiName;

    @FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
    public WebElement PROCEEDTOCHECKOUT;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement ProceedToNext;

    @FindBy(xpath = "//button[.='PROCEED TO CHECKOUT']")
    public WebElement CheckoutToProceed;

    @FindBy(xpath = "(//button[@type='submit'])")
    public WebElement ProceedToNext_2;

    @FindBy(xpath = "//button[.='Go To Payment']")//button:nth-child(2)
    public WebElement Go_To_Payment;

    @FindBy(xpath = "(//div[@class='adress_box__CVDYk '])[1]")
    public WebElement Address_Select;//button[.='Next']

    @FindBy(xpath = "//button[.='Next']")
    public WebElement AddressSelectAhmet;

    @FindBy(xpath = "//span[contains(@class,'ltr-h')]")
    public WebElement Paypal_Amount;


    @FindBy(xpath = "//div[contains(@class,'2Q')]/span")
    public List<WebElement> sub_del_total_2;

    @FindBy(xpath = "//td[@class='text-end py-3']")
    public List<WebElement> sub_del_total_1;

    @FindBy(xpath = "//button[contains(@class,'plus')]")
    public List<WebElement> increase_amount;

    @FindBy(xpath = "//button[contains(@class,'minus')]")
    public List<WebElement> decrease_amount;

    @FindBy(xpath = "(//tbody)/tr/th[contains(@class,'py-3 a')]")
    public List<WebElement> product_name;

    @FindBy(xpath = "(//tbody)/tr/td[contains(@class,'py-3 a')]/div/input")
    public List<WebElement> product_quantity;

    @FindBy(xpath = "(//tbody)/tr/td[contains(@class,'py-3 a')]")
    public List<WebElement> product_price_total;


    @FindBy(xpath = "//div[contains(@class,'toast-body')]")
    public WebElement toast_message;

    @FindBy(css = "#marker1064")
    public List<WebElement> productHome;


}

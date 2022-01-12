package spring.selenium.demo.test.suite3;


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
import spring.selenium.demo.util.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Epic("EP002")
@Story("US004")
@ExtendWith(TestResultLoggerExtension.class)
public class HomePage2BrowserTest extends BrowserTestBase {

    @Value("${appUrl}")
    private String HOME_PAGE;

    @Value("${urban}")
    private String URBAN_HOME;

    @Value("${alici_username}")
    private String alici_username;

    @Value("${alici_password}")
    private String alici_password;


    @Test
    @DisplayName("TC004001")
    public void OpenBrowser1() {
        LOG.info("open browser TC004001 test ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        elements.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Test
    @DisplayName("TC004002")
    public void OpenBrowser2() {
        LOG.info("open browser TC004002 test  ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        elements.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Test
    @DisplayName("TC004003")
    public void OpenBrowser3() {
        LOG.info("open browser TC004003 test  ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        elements.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Test
    @DisplayName("TC004004")
    public void OpenBrowser4() {
        LOG.info("open browser TC004004 test  ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(URBAN_HOME);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Urbanic Farm"),
                "Page title is not correct");
        // elements.getHomePage().searchBox.sendKeys("test1");
        //actions.sendKeys(Keys.ENTER).perform();
    }

    @Test
    @DisplayName("TC004005")
    public void OpenBrowser5() {
        LOG.info("open browser TC004005 test  ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(HOME_PAGE);
        Assertions.assertTrue(Driver.getDriver().getTitle().contains("Amazon"),
                "Page title is not correct");
        elements.getHomePage().searchBox.sendKeys("test1");
        actions.sendKeys(Keys.ENTER).perform();
    }


    @Test()
    @DisplayName("TC004006")
    public void AddProductFromMap() {
        LOG.info("open browser TC004006 test  ***  " + Thread.currentThread().getId());
        Driver.getDriver().get(URBAN_HOME);
        ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.waitFor(3);
        elements.getLoginPage().loginEmailBox.sendKeys(alici_username);
        elements.getLoginPage().loginPasswordBox.sendKeys(alici_password);
        elements.getLoginPage().loginButton.click();
        ReusableMethods.waitFor(5);
        ReusableMethods.waitFor(2);

        List<String> ProductList_fromMap = new ArrayList<>();
        List<String> ProductList_fromCart = new ArrayList<>();
        for (int i = 0; i < elements.getHomePage().addToCart_List.size(); i++) {
            ReusableMethods.waitFor(5);
            ReusableMethods.waitForClickablility(elements.getHomePage().addToCart_List.get(i), 100);
            actions.moveToElement(elements.getHomePage().addToCart_List.get(i));
           (elements.getHomePage().addToCart_List.get(i)).click();
            ReusableMethods.waitFor(3);
            if (elements.getCartPage().toast_message.getText().contains("added to your basket")) {
                ProductList_fromMap.add(elements.getHomePage().productName_List.get(i).getText());
            }
        }
        if (elements.getHomePage().popUp.isDisplayed()) {
            elements.getHomePage().popUp.click();
        }
        ReusableMethods.waitFor(3);
        elements.getHomePage().addToCartButton.click();
        for (int q = 0; q < elements.getCartPage().productNames_intheCart_list.size(); q++) {
            ProductList_fromCart.add(elements.getCartPage().productNames_intheCart_list.get(q).getText());
        }
        for (int i = 0; i < ProductList_fromMap.size(); i++) {
            int finalI = i;
            Assertions.assertTrue(ProductList_fromCart.stream().anyMatch(t -> t.contains(ProductList_fromMap.get(finalI))));
        }
        ReusableMethods.waitFor(2);

        //  elements.getLoginPage().logout();

    }


//    @Test()
//    @DisplayName("TC004006")
//    public void buyProduct() {
//        ReusableMethods.aliciTest_login();
//
//
//        ReusableMethods.waitForClickablility(elements.getHomePage().addToCartButton, 200);
//        if (elements.getHomePage().addToCartButton.getText().equals("0")) {
//            AddProductFromMap();
//        } else {
//
//            elements.getHomePage().addToCartButton.click();
//        }
//        Map<Integer, Products> int_Product_Quantity_Price_Total = new HashMap<>();
//        int id = 1;
//        int i = 2;
//
//        for (int j = 0; j < elements.getCartPage().product_quantity.size(); j++) {
//            int_Product_Quantity_Price_Total.put(id,
//                    new Products(
//                            elements.getCartPage().product_name.get(j).getText(),
//                            elements.getCartPage().product_quantity.get(j).getAttribute("value"),
//                            elements.getCartPage().product_price_total.get(i).getText().substring(1),
//                            elements.getCartPage().product_price_total.get(i + 1).getText().substring(1)
//                    )
//            );
//            i += 5;
//            id++;
//        }
//
//        for (int k = 1; k <= int_Product_Quantity_Price_Total.size(); k++) {
//            Assert.assertEquals(Double.parseDouble(int_Product_Quantity_Price_Total.get(k).price) *
//                            Double.parseDouble(int_Product_Quantity_Price_Total.get(k).quantity),
//                    Double.parseDouble(int_Product_Quantity_Price_Total.get(k).total));
//        }
//
//
//        ReusableMethods.waitForVisibility(elements.getCartPage().sub_del_total_1.get(0), 10);
//        double Subtotal_d = Double.parseDouble(elements.getCartPage().sub_del_total_1.get(0).getText().substring(1));
//        double Delivery_Cost_d = Double.parseDouble(elements.getCartPage().sub_del_total_1.get(1).getText().substring(1));
//        double Total_d = Double.parseDouble(elements.getCartPage().sub_del_total_1.get(2).getText().substring(1));
//        ReusableMethods.refreshPage();
//        ReusableMethods.waitForVisibility(elements.getCartPage().PROCEEDTOCHECKOUT, 10);
//
//
//        elements.getCartPage().PROCEEDTOCHECKOUT.click();
//        ReusableMethods.waitForVisibility(elements.getCartPage().sub_del_total_2.get(0), 10);
//        ReusableMethods.wait(2);
//        double Subtotal2_d = Double.parseDouble(elements.getCartPage().sub_del_total_2.get(0).getText().substring(1));
//        double Delivery_Cost2_d = Double.parseDouble(elements.getCartPage().sub_del_total_2.get(2).getText().substring(1));
//        double Total2_d = Double.parseDouble(elements.getCartPage().sub_del_total_2.get(4).getText().substring(1));
//
//        Assert.assertEquals(Subtotal_d, Subtotal2_d);
//        Assert.assertEquals(Delivery_Cost_d, Delivery_Cost2_d);
//        Assert.assertEquals(Total_d, Total2_d);
//        elements.getCartPage().ProceedToNext.click();
//        elements.getCartPage().Address_Select.click();
//        ReusableMethods.wait(1);
//        elements.getCartPage().ProceedToNext_2.click();
//        ReusableMethods.waitForPageToLoad(10);
//        ReusableMethods.wait(5);
//        ReusableMethods.payment_Normal_Paypal(elements.getCartPage().Go_To_Payment);
//    }
//
//    @Test()
//    @DisplayName("TC004007")
//    public void satisSonrasiMail() {
//
//        Driver.getDriver().get(ConfigurationReader.getProperty("loginUFUrl"));
//        ReusableMethods.beforeMethod_Logout();
//        if (ReusableMethods.isExist(elements.getHomePage().n_login)) {
//            elements.getHomePage().n_login.click();
//        }
//        ReusableMethods.waitForPageToLoad(20);
//
//        ReusableMethods.wait(3);
//        ReusableMethods.aliciTest_login();
//
//
//        ReusableMethods.waitForPageToLoad(100);
//        ReusableMethods.wait(5);
//        ReusableMethods.waitForClickablility(elements.getHomePage().addToCartButton, 100);
//
//        List<String> ProductList_fromMap = new ArrayList<>();
//        for (int i = 0; i < elements.getHomePage().addToCart_List.size(); i++) {
//            ReusableMethods.waitForClickablility(elements.getHomePage().addToCart_List.get(i), 100);
//            if (elements.getHomePage().saticiIsimleri.get(i).getText().equals("saticiTest")) {
//                ReusableMethods.wait(5);
//                actionBuilder.moveToElement(elements.getHomePage().addToCart_List.get(i));
//                ReusableMethods.clickWithJS(elements.getHomePage().addToCart_List.get(i));
//                ReusableMethods.wait(3);
//                if (elements.getCartPage().toast_message.getText().contains("added to your basket")) {
//                    ProductList_fromMap.add(elements.getHomePage().productName_List.get(i).getText());
//                }
//            }
//        }
//        if (elements.getHomePage().popUp.isDisplayed()) {
//            elements.getHomePage().popUp.click();
//        }
//        ReusableMethods.wait(3);
//
//        elements.getHomePage().addToCartButton.click();
//
//        // mail icerisine product bilgileri eklendiginde kullanilacak
//        Map<Integer, Products> int_Product_Quantity_Price_Total = new HashMap<>();
//        int id = 1;
//        int i = 2;
//
//        for (int j = 0; j < elements.getCartPage().product_quantity.size(); j++) {
//            int_Product_Quantity_Price_Total.put(id,
//                    new Products(
//                            elements.getCartPage().product_name.get(j).getText(),
//                            elements.getCartPage().product_quantity.get(j).getAttribute("value"),
//                            elements.getCartPage().product_price_total.get(i).getText().substring(1),
//                            elements.getCartPage().product_price_total.get(i + 1).getText().substring(1)
//                    )
//            );
//            i += 5;
//            id++;
//        }
//
//        ReusableMethods.refreshPage();
//
//
//        ReusableMethods.waitForVisibility(elements.getCartPage().PROCEEDTOCHECKOUT, 10);
//        ReusableMethods.wait(3);
//        String Delivery_Cost2_d = elements.getCartPage().sub_del_total_1.get(1).getText().substring(1);
//        elements.getCartPage().PROCEEDTOCHECKOUT.click();
//        ReusableMethods.waitForVisibility(elements.getCartPage().sub_del_total_2.get(0), 10);
//        ReusableMethods.wait(2);
//
//        String Subtotal2_d = elements.getCartPage().sub_del_total_2.get(0).getText().substring(1);
//
//        //gelen mailde total olmadigi icin assertioni yapilamadi
//        String Total2_d = elements.getCartPage().sub_del_total_2.get(4).getText().substring(1);
//
//        elements.getCartPage().ProceedToNext.click();
//        elements.getCartPage().Address_Select.click();
//        ReusableMethods.wait(1);
//        elements.getCartPage().ProceedToNext_2.click();
//
//        ReusableMethods.waitForPageToLoad(10);
//        ReusableMethods.wait(5);
//        ReusableMethods.payment_Normal_Paypal(elements.getCartPage().Go_To_Payment);
//
//        String satici_last_mail = last_mail(ConfigurationReader.getProperty("saticiTest_username"));
//        String alici_last_mail = last_mail(ConfigurationReader.getProperty("aliciTest_username"));
//
//        System.out.println(satici_last_mail);
//        System.out.println(alici_last_mail);
//
//        // iki mail arasinda karsilastirma yapiyor
//        Assert.assertEquals(mailPojo(satici_last_mail).getDate(), mailPojo(alici_last_mail).getDate());
//        Assert.assertEquals(mailPojo(satici_last_mail).getDeliveryCost(), mailPojo(alici_last_mail).getDeliveryCost());
//        Assert.assertEquals(mailPojo(satici_last_mail).getSubTotal(), mailPojo(alici_last_mail).getSubTotal());
//
//        // alici mailindeki bilgilerle hesap bilgileri ayni diye mi bakiyor
//        Assert.assertEquals(mailPojo(alici_last_mail).getSubTotal(), Subtotal2_d);
//        Assert.assertEquals(mailPojo(alici_last_mail).getDeliveryCost(), Delivery_Cost2_d);
//        Assert.assertEquals(mailPojo(alici_last_mail).getSellerName(), "aliciTest");
//        Assert.assertEquals(mailPojo(alici_last_mail).getDate(), ReusableMethods.getCurrentDate());
//
//    }
//
//

}
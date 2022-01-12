package spring.selenium.demo.test.suite4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import spring.selenium.demo.test.BrowserTestBase;
import spring.selenium.demo.util.ReusableMethods;

import java.util.*;

public class a extends BrowserTestBase {

    String aliciTest_username = "alici_test_2022@mailsac.com";
    String aliciTest_password = "AQ4LPPAASQVuCLf";
    String saticiTest_username = "satici_test_2022@mailsac.com";
    String saticiTest_password = "3AJygjifmqYcjv5";

    public void alici_login() {
        Driver.getDriver().get("https://test.urbanicfarm.com/auth/login");
        ReusableMethods.waitForPageToLoad(20);
        ReusableMethods.waitFor(3);
        elements.getLoginPage().loginEmailBox.sendKeys(aliciTest_username);
        elements.getLoginPage().loginPasswordBox.sendKeys(aliciTest_password);
        elements.getLoginPage().loginButton.click();
        ReusableMethods.waitFor(5);
    }

    public void remove_all_from_cart() {
        ReusableMethods.waitForPageToLoad(100);
        ReusableMethods.waitFor(5);
        ReusableMethods.waitForClickablility(elements.getHomePage().cartText, 100);
        elements.getHomePage().cartText.click();
        ReusableMethods.waitFor(2);
        for (int j = 0; j < 1; j--) {
            WebElement element = Driver.getDriver().findElement(By.cssSelector(" div.d-flex.justify-content-center.align-items-center > div:nth-child(3) > div > span"));
            if (!element.getText().equals("0")) {
                ReusableMethods.waitFor(2);
                elements.getHomePage().cartText.click();
                ReusableMethods.waitFor(2);
                if (!ReusableMethods.isElementVisible(elements.getCartPage().cartIsEmpty)) {
                    ReusableMethods.waitForVisibility(elements.getCartPage().removeItemFromCart.get(0), 10);
                    for (int i = 0; i < elements.getCartPage().removeItemFromCart.size(); i++) {
                        ReusableMethods.waitFor(3);
                        elements.getCartPage().removeItemFromCart.get(0).click();
                        ReusableMethods.waitForVisibility(elements.getCartPage().confirmToDelete, 10);
                        elements.getCartPage().confirmToDelete.click();
                        ReusableMethods.waitFor(3);
                    }
                    Driver.getDriver().navigate().back();
                    ReusableMethods.waitFor(5);
                }
            }
            if (element.getText().equals("0")) {
                break;
            }
        }

    }


    @Test()
    public void way1_empty_cart() {
        alici_login();
        remove_all_from_cart();
        ReusableMethods.waitFor(5);
        elements.getLoginPage().logout();
    }

    @Test()
    public void AddProductFromMap() {
        alici_login();
        ReusableMethods.waitFor(2);

        List<String> ProductList_fromMap = new ArrayList<>();
        List<String> ProductList_fromCart = new ArrayList<>();
        for (int i = 0; i < elements.getHomePage().addToCart_List.size(); i++) {
            ReusableMethods.waitFor(5);
            ReusableMethods.waitForClickablility(elements.getHomePage().addToCart_List.get(i), 100);
            actions.moveToElement(elements.getHomePage().addToCart_List.get(i));
            ReusableMethods.clickWithJS(elements.getHomePage().addToCart_List.get(i));
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
        ReusableMethods.localClear();

    }

//    @Test
//    public void addCartFromFavorite() {
//    }


    @Test()
    public void buyProduct() {
        alici_login();

        ReusableMethods.waitForClickablility(elements.getHomePage().addToCartButton, 200);

        // eger cart bos ise doldurmak icin
        if (elements.getHomePage().addToCartButton.getText().equals("0")) {
            for (int i = 0; i < elements.getHomePage().addToCart_List.size(); i++) {
                ReusableMethods.waitFor(5);
                ReusableMethods.waitForClickablility(elements.getHomePage().addToCart_List.get(i), 100);
                actions.moveToElement(elements.getHomePage().addToCart_List.get(i));
                ReusableMethods.clickWithJS(elements.getHomePage().addToCart_List.get(i));
                ReusableMethods.waitFor(3);
            }
            if (elements.getHomePage().popUp.isDisplayed()) {
                elements.getHomePage().popUp.click();
            }
        }

        elements.getHomePage().addToCartButton.click();

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
//            Assertions.assertEquals(Double.parseDouble(int_Product_Quantity_Price_Total.get(k).price) *
//                            Double.parseDouble(int_Product_Quantity_Price_Total.get(k).quantity),
//                    Double.parseDouble(int_Product_Quantity_Price_Total.get(k).total));
//        }


        ReusableMethods.waitForVisibility(elements.getCartPage().sub_del_total_1.get(0), 10);
        double Subtotal_d = Double.parseDouble(elements.getCartPage().sub_del_total_1.get(0).getText().substring(1));
        double Delivery_Cost_d = Double.parseDouble(elements.getCartPage().sub_del_total_1.get(1).getText().substring(1));
        double Total_d = Double.parseDouble(elements.getCartPage().sub_del_total_1.get(2).getText().substring(1));
        ReusableMethods.refreshPage();
        ReusableMethods.waitForVisibility(elements.getCartPage().PROCEEDTOCHECKOUT, 10);


        elements.getCartPage().PROCEEDTOCHECKOUT.click();
        ReusableMethods.waitForVisibility(elements.getCartPage().sub_del_total_2.get(0), 10);
        ReusableMethods.waitFor(2);
        double Subtotal2_d = Double.parseDouble(elements.getCartPage().sub_del_total_2.get(0).getText().substring(1));
        double Delivery_Cost2_d = Double.parseDouble(elements.getCartPage().sub_del_total_2.get(2).getText().substring(1));
        double Total2_d = Double.parseDouble(elements.getCartPage().sub_del_total_2.get(4).getText().substring(1));

        Assertions.assertEquals(Subtotal_d, Subtotal2_d);
        Assertions.assertEquals(Delivery_Cost_d, Delivery_Cost2_d);
        Assertions.assertEquals(Total_d, Total2_d);
        elements.getCartPage().ProceedToNext.click();
        elements.getCartPage().Address_Select.click();
        ReusableMethods.waitFor(1);
        elements.getCartPage().ProceedToNext_2.click();
        ReusableMethods.waitForPageToLoad(10);
        ReusableMethods.waitFor(5);
       // ReusableMethods.payment_Normal_Paypal(elements.getCartPage().Go_To_Payment);
        ReusableMethods.localClear();

    }

    @Test()
    public void increaseAmountOnTheCart() {
        alici_login();
        elements.getHomePage().addToCartButton.click();
        Map<Integer, List<Object>> int_Product_Quantity_Price_Total = new HashMap<>();

        int id = 1;
        int i = 2;
        for (int j = 0; j < elements.getCartPage().product_quantity.size(); j++) {
            int_Product_Quantity_Price_Total.put(id,
                    Arrays.asList(elements.getCartPage().product_name.get(j).getText(),
                            elements.getCartPage().product_quantity.get(j).getAttribute("value"),
                            elements.getCartPage().product_price_total.get(i).getText().substring(1),
                            elements.getCartPage().product_price_total.get(i + 1).getText().substring(1)));
            i += 5;
            id++;
        }
        for (int j = 0; j < elements.getCartPage().product_quantity.size(); j++) {
            elements.getCartPage().increase_amount.get(j).click();
            ReusableMethods.waitFor(2);
            Assertions.assertTrue(elements.getCartPage().toast_message.getText().equals("You've reached the maximum amount in the stock.") ||
                    elements.getCartPage().toast_message.getText().contains(" added to your basket!"));
        }
        ReusableMethods.waitFor(3);
        for (int j = 0; j < elements.getCartPage().product_quantity.size(); j++) {
            elements.getCartPage().decrease_amount.get(j).click();
            ReusableMethods.waitFor(2);
            Assertions.assertTrue(elements.getCartPage().toast_message.getText().contains("removed from your cart!") ||
                    !ReusableMethods.isExist(elements.getCartPage().toast_message));
        }
        elements.getLoginPage().logout();
        ReusableMethods.localClear();

    }

//    @Test()
//    public void stock_0_olabilmesi() {
//        alici_login();
//        String productName = elements.getHomePage().productName_List.get(0).getText();
//        elements.getHomePage().add_amount_to_cart.get(0).sendKeys(elements.getHomePage().add_amount_to_cart.get(0).getAttribute("max"));
//        elements.getHomePage().addToCart_List.get(0).click();
//        ReusableMethods.payment_Normal_Paypal();
//        ReusableMethods.waitForPageToLoad(10);
////        ReusableMethods.satici_login();
//        Driver.getDriver().get("https://test.urbanicfarm.com/account/hub/VEGETABLES_AND_FRUITS_HUB");
//        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//div[@class='row m-0 p-2 ']/a/span"));
//        for (int i = 0; i < elements.size(); i++) {
//            if (elements.get(i).getText().equals(productName)) {
//                Assertions.assertEquals(elements.get(i + 2).getText(), "Stock: 0 Pound");
//                break;
//            }
//        }
//        ReusableMethods.localClear();
//
//    }


//    @Test()
//    public void satisSonrasiMail() {
//
//
//        ReusableMethods.fastLogin("alici test", "");
//
//        ReusableMethods.waitForPageToLoad(100);
//        ReusableMethods.waitFor(50);
//        ReusableMethods.waitForClickablility(elements.getHomePage().addToCartButton, 100);
//
//        List<String> ProductList_fromMap = new ArrayList<>();
//        for (int i = 0; i < elements.getHomePage().addToCart_List.size(); i++) {
//            ReusableMethods.waitForClickablility(elements.getHomePage().addToCart_List.get(i), 100);
//            if (elements.getHomePage().saticiIsimleri.get(i).getText().equals("saticiTest")) {
//                ReusableMethods.waitFor(5);
//                actions.moveToElement(elements.getHomePage().addToCart_List.get(i));
//                ReusableMethods.clickWithJS(elements.getHomePage().addToCart_List.get(i));
//                ReusableMethods.waitFor(3);
//                if (elements.getCartPage().toast_message.getText().contains("added to your basket")) {
//                    ProductList_fromMap.add(elements.getHomePage().productName_List.get(i).getText());
//                }
//            }
//        }
//        if (ReusableMethods.isExist(elements.getHomePage().popUp)) {
//            elements.getHomePage().popUp.click();
//        }
//        ReusableMethods.waitFor(3);
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
//        ReusableMethods.waitFor(3);
//        String Delivery_Cost2_d = elements.getCartPage().sub_del_total_1.get(1).getText().substring(1);
//        elements.getCartPage().PROCEEDTOCHECKOUT.click();
//        ReusableMethods.waitForVisibility(elements.getCartPage().sub_del_total_2.get(0), 10);
//        ReusableMethods.waitFor(2);
//
//        String Subtotal2_d = elements.getCartPage().sub_del_total_2.get(0).getText().substring(1);
//
//        //gelen mailde total olmadigi icin assertioni yapilamadi
//        String Total2_d = elements.getCartPage().sub_del_total_2.get(4).getText().substring(1);
//
//        elements.getCartPage().ProceedToNext.click();
//        elements.getCartPage().Address_Select.click();
//        ReusableMethods.waitFor(1);
//        elements.getCartPage().ProceedToNext_2.click();
//
//        ReusableMethods.waitForPageToLoad(10);
//        ReusableMethods.waitFor(5);
//        ReusableMethods.payment_Normal_Paypal(elements.getCartPage().Go_To_Payment);
//
//        String satici_last_mail = last_mail(saticiTest_username);
//        String alici_last_mail = last_mail(aliciTest_username);
//
//        System.out.println(satici_last_mail);
//        System.out.println(alici_last_mail);
//
//        // iki mail arasinda karsilastirma yapiyor
//        Assertions.assertEquals(mailPojo(satici_last_mail).getDate(), mailPojo(alici_last_mail).getDate());
//        Assertions.assertEquals(mailPojo(satici_last_mail).getDeliveryCost(), mailPojo(alici_last_mail).getDeliveryCost());
//        Assertions.assertEquals(mailPojo(satici_last_mail).getSubTotal(), mailPojo(alici_last_mail).getSubTotal());
//
//        // alici mailindeki bilgilerle hesap bilgileri ayni diye mi bakiyor
//        Assertions.assertEquals(mailPojo(alici_last_mail).getSubTotal(), Subtotal2_d);
//        Assertions.assertEquals(mailPojo(alici_last_mail).getDeliveryCost(), Delivery_Cost2_d);
//        Assertions.assertEquals(mailPojo(alici_last_mail).getSellerName(), "aliciTest");
//        Assertions.assertEquals(mailPojo(alici_last_mail).getDate(), ReusableMethods.getCurrentDate());
//        ReusableMethods.localClear();
//
//    }

    public String last_mail(String mail) {
        Driver.getDriver().get("https://mailsac.com/inbox/" + mail);
        elements.getMailPage().all_message.get(0).click();
        return elements.getMailPage().message.getText();

    }

    @AfterEach
    public void tear(){
        ReusableMethods.localClear();
    }

}

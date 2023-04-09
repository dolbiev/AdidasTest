package org.demoblaze;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.demoblaze.pages.CartPage;
import org.demoblaze.pages.ProductPage;
import org.demoblaze.pages.TitlePage;
import org.demoblaze.pages.modalPages.PlaceOrderPage;
import org.junit.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.demoblaze.pages.modalPages.PlaceOrderPage.getElementId;
import static org.demoblaze.pages.modalPages.PlaceOrderPage.getTotal;

public class MainTest {
    @Test
    public static void main(String[] args) {
        //Variables
        final String productOne = "Sony vaio i5";
        final String productTwo = "Dell i7 8gb";

        //Before test
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        //Navigate to the URL and initialize the TitlePage object
        driver.get("https://www.demoblaze.com/index.html");
        TitlePage titlePage = new TitlePage(driver);

        //Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
        titlePage.pressLaptops();
        ProductPage productPage = titlePage.pressProduct(productOne);
        productPage.addToCart();
        titlePage = productPage.clickLogo();

        //Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
        titlePage.pressLaptops();
        productPage = titlePage.pressProduct(productTwo);
        productPage.addToCart();

        //Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
        CartPage cartPage = productPage.pressCart();
        cartPage.deleteProduct(productTwo);

        //Click on "Place order".
        PlaceOrderPage placeOrderPage = cartPage.clickPlaceOrder();

        //Fill in all web form fields.
        placeOrderPage.setName("Grish");
        placeOrderPage.setCity("Bilbao");
        placeOrderPage.setCountry("Pais Vasco");
        placeOrderPage.setCard("42069");
        placeOrderPage.setYear("1984");
        placeOrderPage.setMonth("Noviembre");

        //Click on "Purchase"
        placeOrderPage.pressPurchase();

        //Capture and log purchase Id and Amount.
        String text = getElementId(driver);
        int start = text.indexOf("Amount: ") + "Amount: ".length();
        int end = text.indexOf(" USD", start);
        String amount = text.substring(start, end);
        int startId = text.indexOf("Id: ") + "Id: ".length();
        int endId = text.indexOf("\n", startId);
        String id = text.substring(startId, endId);

        //Click on "Ok"
        placeOrderPage.clickOK();

        //Get total amount
        String total = getTotal(driver).replaceAll("[^0-9]", "");

        //Assert purchase amount equals expected.
        int expectedAmount = Integer.parseInt(total);
        int actualAmount = Integer.parseInt(amount);
        if (expectedAmount == actualAmount) {
            System.out.println("Purchase amount (ID:" + id + ") is expected. We were not deceived. The store is as good as the tester who wrote this code!");
        } else {
            System.out.println("Purchase amount (ID:" + id + ") doesn't expected. It's just an unfortunate misunderstanding.");
        }

        //Quit the WebDriver
        driver.close();
        driver.quit();
    }
}
package org.demoblaze.pages;

import org.demoblaze.pages.modalPages.PlaceOrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends TitlePage {
    /**
     * Logo
     */
    @FindBy(id = "nava")
    WebElement logo;
    /**
     * Button "Place Order"
     */
    @FindBy(xpath = "//button[normalize-space(text())='Place Order']")
    WebElement placeOrderButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Back to TitlePage
    public TitlePage clickLogo() {
        logo.click();
        final TitlePage titlePage = new TitlePage(driver);
        return titlePage;
    }

    //Delete product
    public void deleteProduct(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[normalize-space(text())='" + name + "']/following-sibling::td/a[normalize-space(text())='Delete']")));
        delete.click();
        driver.navigate().refresh();
    }

    //Go to Place Order
    public PlaceOrderPage clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space(text())='Place Order']")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", placeOrderButton);
        placeOrderButton.click();
        final PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        return placeOrderPage;
    }
}

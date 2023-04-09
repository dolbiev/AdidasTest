package org.demoblaze.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends TitlePage {
    /**
     * Logo
     */
    @FindBy(id = "nava")
    WebElement logo;
    /**
     * Button "Add to cart"
     */
    @FindBy(xpath = "//a[normalize-space(text())='Add to cart']")
    WebElement addButton;
    /**
     * Upper Menu "Cart"
     */
    @FindBy(xpath = "//a[normalize-space(text())='Cart']")
    WebElement cartMenu;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addButton));
        addButton.click();
        try {
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (NoSuchElementException e) {
            System.out.println("Alert window did not appear after clicking 'Add to cart' button");
        }
    }

    //Back to TitlePage
    public TitlePage clickLogo() {
        logo.click();
        final TitlePage titlePage = new TitlePage(driver);
        return titlePage;
    }

    //Press "Cart" in upper Menu
    public CartPage pressCart() {
        cartMenu.click();
        return new CartPage(driver);
    }
}

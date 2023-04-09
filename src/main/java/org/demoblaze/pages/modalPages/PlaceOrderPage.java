package org.demoblaze.pages.modalPages;

import org.demoblaze.pages.TitlePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaceOrderPage extends TitlePage {
    /**
     * Field "Name"
     */
    @FindBy(id = "name")
    WebElement nameInput;
    /**
     * Field "Country"
     */
    @FindBy(id = "country")
    WebElement countryInput;
    /**
     * Field "City"
     */
    @FindBy(id = "city")
    WebElement cityInput;
    /**
     * Field "Credit card"
     */
    @FindBy(id = "card")
    WebElement cardInput;
    /**
     * Field "Month"
     */
    @FindBy(id = "month")
    WebElement monthInput;
    /**
     * Field "Year"
     */
    @FindBy(id = "year")
    WebElement yearInput;
    /**
     * Button "Purchase"
     */
    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;
    /**
     * Button "OK"
     */
    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    WebElement confirmButton;

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
    }

    //Set "Name"
    public void setName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    //Set "Country"
    public void setCountry(String country) {
        countryInput.clear();
        countryInput.sendKeys(country);
    }

    //Set "City"
    public void setCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    //Set "Credit card"
    public void setCard(String card) {
        cardInput.clear();
        cardInput.sendKeys(card);
    }

    //Set "Month"
    public void setMonth(String month) {
        monthInput.clear();
        monthInput.sendKeys(month);
    }

    //Set "Year"
    public void setYear(String year) {
        yearInput.clear();
        yearInput.sendKeys(year);
    }

    //Click on "Purchase"
    public void pressPurchase() {
        purchaseButton.click();
    }

    //Get element
    public static String getTotal(WebDriver driver) {
        WebElement element = driver.findElement(By.id("totalp"));
        String elementId = element.getText();
        return elementId;
    }

    //Get element
    public static String getElementId(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//p[@class='lead text-muted ']"));
        String elementId = element.getText();
        return elementId;
    }

    //Click "OK"
    public TitlePage clickOK() {
        confirmButton.click();
        final TitlePage titlePage = new TitlePage(driver);
        return titlePage;
    }
}

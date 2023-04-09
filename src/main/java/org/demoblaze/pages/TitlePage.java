package org.demoblaze.pages;

import org.demoblaze.pages.modalPages.AboutUsPage;
import org.demoblaze.pages.modalPages.ContactPage;
import org.demoblaze.pages.modalPages.LogInPage;
import org.demoblaze.pages.modalPages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Main Page (Title)
 *
 * @author Grigoriy Dolbiev
 */
public class TitlePage {
    /**
     * Selenium web driver
     */
    protected WebDriver driver;
    /**
     * Logo
     */
    @FindBy(id = "nava")
    WebElement logo;
    /**
     * Upper Menu "Home"
     */
    @FindBy(xpath = "//a[normalize-space(text())='Home']")
    WebElement homeMenu;
    /**
     * Upper Menu "Contact"
     */
    @FindBy(xpath = "//a[normalize-space(text())='Contact']")
    WebElement contactMenu;
    /**
     * Upper Menu "About us"
     */
    @FindBy(xpath = "//a[normalize-space(text())='About us']")
    WebElement aboutUsMenu;
    /**
     * Upper Menu "Cart"
     */
    @FindBy(xpath = "//a[normalize-space(text())='Cart']")
    WebElement cartMenu;
    /**
     * Upper Menu "Log In"
     */
    @FindBy(xpath = "//a[normalize-space(text())='Log In']")
    WebElement logInMenu;
    /**
     * Upper Menu "Sign Up"
     */
    @FindBy(xpath = "//a[normalize-space(text())='Sign Up']")
    WebElement signUpMenu;
    /**
     * Menu "Phones"
     */
    @FindBy(xpath = "//a[normalize-space(text())='Phones']")
    WebElement phonesMenu;
    /**
     * Menu "Laptops"
     */
    @FindBy(xpath = "//a[normalize-space(text())='Laptops']")
    WebElement laptopsMenu;
    /**
     * Menu "Monitors"
     */
    @FindBy(xpath = "//a[normalize-space(text())='Monitors']")
    WebElement monitorsMenu;
    /**
     * Button "Previous"
     */
    @FindBy(id = "prev2")
    WebElement prevButton;
    /**
     * Button "Next"
     */
    @FindBy(id = "next2")
    WebElement nextButton;

    public TitlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Press logo in upper left corner
    public void pressLogo() {
        logo.click();
    }

    //Press "Home" in upper Menu
    public void pressHome() {
        homeMenu.click();
    }

    //Press "Contact" in upper Menu
    public ContactPage pressContact() {
        contactMenu.click();
        return new ContactPage(driver);
    }

    //Press "About Us" in upper Menu
    public AboutUsPage pressAboutUs() {
        aboutUsMenu.click();
        return new AboutUsPage(driver);
    }

    //Press "Cart" in upper Menu
    public CartPage pressCart() {
        cartMenu.click();
        return new CartPage(driver);
    }

    //Press "Log In" in upper Menu
    public LogInPage pressLogIn() {
        logInMenu.click();
        return new LogInPage(driver);
    }

    //Press "Sign Up" in upper Menu
    public SignUpPage pressSignUp() {
        signUpMenu.click();
        return new SignUpPage(driver);
    }

    //Press "Phones" in Menu
    public void pressPhones() {
        phonesMenu.click();
    }

    //Press "Laptops" in Menu
    public void pressLaptops() {
        laptopsMenu.click();
    }

    //Press "Monitors" in Menu
    public void pressMonitors() {
        monitorsMenu.click();
    }

    public ProductPage pressProduct(String name) {
        boolean found = false;
        while (!found) {
            try {
                driver.findElement(By.xpath("//a[normalize-space(text())='" + name + "']")).click();
                found = true;
            } catch (NoSuchElementException e) {
                nextButton.click();
            }
        }
        return new ProductPage(driver);
    }
}

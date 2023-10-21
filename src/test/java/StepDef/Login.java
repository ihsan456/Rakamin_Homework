package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User in Login page")
    public void UserinLoginpage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertation
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click Login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on dashboard page")
    public void userInOnDashboardPage() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@class=\"inventory_item_label\"]//div[contains(text(), 'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(loginPageAssert, "Sauce Labs Backpack");
    }


    @And("Input invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("123123");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(loginPageAssert, "Epic sadface: Username and password do not match any user in this service");
    }

    @And("User click tab")
    public void userClickTab() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User click Logout")
    public void userClickLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @And("click Add to cart")
    public void clickAddToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("product added to cart")
    public void productAddedToCart() {
        String addcart = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
        Assert.assertEquals(addcart, "Remove");
    }
}

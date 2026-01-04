package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

//    private final WebDriver driver;
    private final By username = By.id("username");
    private final By password = By.id("password");
//    private final By loginButton = By.id("submit-login");

    @FindBy(id = "submit-login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage(){
        driver.get("https://practice.expandtesting.com/login");
    }
    public void enterUsername(String user){
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin(){
//        ((JavascriptExecutor) driver).executeScript(
//                "arguments[0].scrollIntoView({block: 'center'});",
//                loginButton
//        );
        clickWhenReady(loginButton);
    }
}

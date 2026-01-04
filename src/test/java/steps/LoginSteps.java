package steps;

import core.DriverFactory;
import flows.LoginFlow;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;


public class LoginSteps {
    WebDriver driver;
    LoginFlow loginFlow;

    @Given("user is on login page and logged in successfully")
    public void openLoginPage(){
        driver = DriverFactory.getDriver();
        loginFlow = new LoginFlow(driver);
        loginFlow.login();
    }

}

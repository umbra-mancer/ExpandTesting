package steps;

import core.DriverFactory;
import dao.LoginDAO;
import dto.LoginDTO;
import flows.LoginFlow;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    LoginFlow loginFlow;
    LoginDAO data;
    LoginDTO loginDTO;

    @Given("user is on login page and logged in successfully")
    public void openLoginPage(){
        driver = DriverFactory.getDriver();
        loginFlow = new LoginFlow(driver);
        loginFlow.login();
    }

}

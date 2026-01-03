package flows;

import dao.LoginDAO;
import dto.LoginDTO;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginFlow {

    private final LoginPage loginPage;
    private final LoginDAO loginDAO;

    public LoginFlow(WebDriver driver){
        this.loginPage = new LoginPage(driver);
        this.loginDAO = new LoginDAO();
    }
    public void login(){
        LoginDTO data = loginDAO.getValidCredentials();
        loginPage.openLoginPage();
        loginPage.enterUsername(data.getUsername());
        loginPage.enterPassword(data.getPassword());
        loginPage.clickLogin();
    }
}

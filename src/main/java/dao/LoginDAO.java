package dao;

import dto.LoginDTO;
import lombok.extern.java.Log;

public class LoginDAO {

    public LoginDTO getValidCredentials(){
        LoginDTO credentials = new LoginDTO();
        credentials.setUsername("practice");
        credentials.setPassword("SuperSecretPassword!");
        return credentials;
    }
}

package com.demoblaze.pages;

import com.demoblaze.utilities.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "loginusername")
    public WebElement usernameInput;
    @FindBy(id = "loginpassword")
    public WebElement passwordInput;
    @FindBy(css = "[onclick='logIn()']")
    public WebElement loginButton;
    public void login () {
        usernameInput.sendKeys(ConfigReader.get("username"));
        passwordInput.sendKeys(ConfigReader.get("password"));
        loginButton.click();
    }
    public void login (String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
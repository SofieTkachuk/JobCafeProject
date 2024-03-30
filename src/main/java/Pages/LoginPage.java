package Pages;

import Consts.Consts;

public class LoginPage extends BasePage{
    private static String LOGIN_PAGE_URL = "http://www.uitestingplayground.com/sampleapp";
    private static String USERNAME = "//input[@name='UserName']";
    private static String PASSWORD = "//input[@name='Password']";
    private static String LOGIN_BUTTON = "//button[@id='login']";
    private static String ERROR_MSG = "//*[text()='Invalid username/password']";

    public void navigateToLoginPage(){
        webDriver.get(LOGIN_PAGE_URL);
    }

   public void usernameInput(){
        sendTextToElementByXpath(USERNAME, "name1");
   }

    public void passwordInput(){
        sendTextToElementByXpath(PASSWORD, "pass1");
    }

    public void clickLoginButton(){
        clickElementByXpath(LOGIN_BUTTON);
    }

    public boolean isErrorVisible(){
        Boolean isErrorVisible = elementExists(ERROR_MSG);
        return isErrorVisible;
    }

    @Override
    public void verifyLogs() {
        super.verifyLogs();
    }
}

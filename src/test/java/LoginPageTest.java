import Pages.LoginPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends UseCaseBase {
    private static LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @BeforeAll
    public static void classSetup(){
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void beforeTest(){
        loginPage.navigateToLoginPage();
    }

    @Test
    public void loginTest(){
        loginPage.usernameInput();
        loginPage.passwordInput();
        loginPage.clickLoginButton();

        boolean isErrorMsgVisible = loginPage.isErrorVisible();
        assertTrue(isErrorMsgVisible);
    }
}

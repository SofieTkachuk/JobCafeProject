package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    protected void clickElementByXpath (String xpath) {
        findElementByXpath(xpath).click();
    }

    protected void sendTextToElementByXpath(String xpath, String text) {
        WebElement element = findElementByXpath(xpath);
        element.sendKeys(text);
    }

    protected boolean elementExists (String xpath) {
        try {
            webDriver.findElement(By.xpath(xpath));
            return true;
        }
        catch (Exception err){
            return false;
        }
    }

    protected WebElement findElementByXpath (String xpath){
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected String getCurrentPageURL(){
        return webDriver.getCurrentUrl();
    }

    public void verifyLogs() {
        LogEntries logs = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logs) {
            logger.debug(entry.getLevel() + ": " + entry.getMessage());
        }
    }
}

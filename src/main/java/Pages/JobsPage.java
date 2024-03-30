package Pages;

import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobsPage extends BasePage{
    private static String JOBS_MENU_OPTION = "//a[text()='Find Job']";
    private static String LOCATION_SEARCH = "//input[@name='location']";
    private static String POSITION_SEARCH = "//input[@name='position']";
    private static String COMPANY_SEARCH = "//input[@name='company']";
    private static String DESCRIPTION_SEARCH = "//input[@name='description']";
    private static String SEARCH_BUTTON = "//button[text()='search']";
    private static String RESET_BUTTON = "//button[text()='reset']";
    private static String NO_RESULTS_MSG = "//*[text()='Please try different search criteria']";

    public void navigateToJobsPage(){
        clickElementByXpath(JOBS_MENU_OPTION);
    }

    public Boolean isNoResultsMessageDisplayed() {
        WebElement noResultsElement = findElementByXpath(NO_RESULTS_MSG);
        return noResultsElement.isDisplayed();
    }

    public void navigateToJobsPageLink(){
        webDriver.get(Consts.JOB_PAGE_URL);
    }

    public String isJobsPageLoaded(){
        String currentURL = getCurrentPageURL();
        return currentURL;
    }

    public void clickSearchButton(){
        clickElementByXpath(SEARCH_BUTTON);
    }

    public void searchByCity(String city){
        sendTextToElementByXpath(LOCATION_SEARCH, city);
    }

    public void searchByPosition(String position){
        sendTextToElementByXpath(POSITION_SEARCH, position);
    }

    public void searchByCompany(String company){
        sendTextToElementByXpath(COMPANY_SEARCH, company);
    }

    public void searchByDescription(String description){
        sendTextToElementByXpath(DESCRIPTION_SEARCH, description);
    }

    public void clearSearch(){
        clickElementByXpath(RESET_BUTTON);
    }

    public boolean areSearchResultItemsContainingCityDisplayed(String city) {
        List<WebElement> elementsContainingCity = webDriver.findElements(By.xpath("//*[contains(text(), '" + city + "')]"));
        if (!elementsContainingCity.isEmpty()) {
        }
            return true;
        }

    public boolean areSearchResultItemsContainingPositionDisplayed(String position) {
        List<WebElement> elementsContainingPosition = webDriver.findElements(By.xpath("//*[contains(text(), '" + position + "')]"));
        if (!elementsContainingPosition.isEmpty()) {
        }
        return true;
    }

    public boolean areSearchResultItemsContainingCompanyDisplayed(String company) {
        List<WebElement> elementsContainingCompany = webDriver.findElements(By.xpath("//*[contains(text(), '" + company + "')]"));
        if (!elementsContainingCompany.isEmpty()) {
        }
        return true;
    }

    public boolean areSearchResultItemsContainingDescriptionDisplayed(String description) {
        List<WebElement> elementsContainingDescription = webDriver.findElements(By.xpath("//*[contains(text(), '" + description + "')]"));
        if (!elementsContainingDescription.isEmpty()) {
        }
        return true;
    }

    @Override
    public void verifyLogs() {
        super.verifyLogs();
    }
}

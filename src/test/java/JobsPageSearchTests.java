import Pages.HomePage;
import Pages.JobsPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobsPageSearchTests extends UseCaseBase {
    private static JobsPage jobsPage;
    private static final Logger logger = LogManager.getLogger(JobsPageSearchTests.class);

    @BeforeAll
    public static void classSetup(){
        jobsPage = new JobsPage();
    }

    // Navigate to the jobs page
    @BeforeEach
    public void beforeTest(){
        //jobsPage.navigateToJobsPageLink(); //THIS METHOD DOES NOT WORK
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        jobsPage.navigateToJobsPage();
    }

    @Test
    public void searchByLocationTests(){
        // Search for a location: Toronto, Tel-Aviv, Chicago, New-York
        jobsPage.searchByCity("Toronto");
        jobsPage.clickSearchButton();

        // Verify the results list is displayed for each city
        boolean torontoSearch = jobsPage.areSearchResultItemsContainingCityDisplayed("Toronto");
        assertTrue(torontoSearch);
        jobsPage.clearSearch();

        jobsPage.searchByCity("Tel-Aviv");
        jobsPage.clickSearchButton();
        boolean telAvivSearch = jobsPage.areSearchResultItemsContainingCityDisplayed("Tel-Aviv");
        assertTrue(telAvivSearch);
        jobsPage.clearSearch();

        jobsPage.searchByCity("Chicago");
        jobsPage.clickSearchButton();
        boolean chicagoSearch = jobsPage.areSearchResultItemsContainingCityDisplayed("Chicago");
        assertTrue(chicagoSearch);
        jobsPage.clearSearch();

        jobsPage.searchByCity("New-York");
        jobsPage.clickSearchButton();
        boolean newYorkSearch = jobsPage.areSearchResultItemsContainingCityDisplayed("New-York");
        assertTrue(newYorkSearch);
    }

    @Test
    public void searchByPositionTests() {
    // Search for a position: QA, Developer, Project Manager
        jobsPage.searchByPosition("QA");
        jobsPage.clickSearchButton();

        // Verify the results list is displayed for each position
        boolean qaSearch = jobsPage.areSearchResultItemsContainingPositionDisplayed("QA");
        assertTrue(qaSearch);
        jobsPage.clearSearch();

        jobsPage.searchByPosition("Developer");
        jobsPage.clickSearchButton();
        boolean developerSearch = jobsPage.areSearchResultItemsContainingPositionDisplayed("Developer");
        assertTrue(developerSearch);
        jobsPage.clearSearch();

        jobsPage.searchByPosition("Project Manager");
        jobsPage.clickSearchButton();
        boolean projectManagerSearch = jobsPage.areSearchResultItemsContainingPositionDisplayed("Project Manager");
        assertTrue(projectManagerSearch);
    }

    @Test
    public void searchByCompanyTests() {
        // Search for a company: Apple, Facebook, Google
        jobsPage.searchByCompany("Apple");
        jobsPage.clickSearchButton();

        // Verify the results list is displayed for each company
        boolean appleSearch = jobsPage.areSearchResultItemsContainingCompanyDisplayed("Apple");
        assertTrue(appleSearch);
        jobsPage.clearSearch();

        jobsPage.searchByCompany("Facebook");
        jobsPage.clickSearchButton();
        boolean facebookSearch = jobsPage.areSearchResultItemsContainingCompanyDisplayed("Facebook");
        assertTrue(facebookSearch);
        jobsPage.clearSearch();

        jobsPage.searchByCompany("Google");
        jobsPage.clickSearchButton();
        boolean googleSearch = jobsPage.areSearchResultItemsContainingCompanyDisplayed("Google");
        assertTrue(googleSearch);
    }

    @Test
    public void combinedSearchTest() {
        // Make a combined search - look for manager positions in Google in USA
        jobsPage.searchByPosition("Manager");
        jobsPage.searchByCompany("Google");
        jobsPage.searchByCity("USA");
        jobsPage.clickSearchButton();

        // Verify the results are visible
        boolean isCompanyDisplayed = jobsPage.areSearchResultItemsContainingCompanyDisplayed("Google");
        boolean isCityDisplayed = jobsPage.areSearchResultItemsContainingCityDisplayed("USA");
        boolean isPositionDisplayed = jobsPage.areSearchResultItemsContainingPositionDisplayed("Manager");
        assertTrue(isCompanyDisplayed && isCityDisplayed && isPositionDisplayed);
    }

    @Test
    public void noResultsTest() {
        // No results - enter abracadabra to position filter and press search button
        jobsPage.searchByPosition("abracadabra");
        jobsPage.clickSearchButton();

        // Verify "No results found! Please try different search criteria" message is displayed
        Boolean noResultsSearch = jobsPage.isNoResultsMessageDisplayed();
        assertTrue(noResultsSearch);
    }

    @Test
    public void resetTest() {
        // Populate all the edit boxes
        jobsPage.searchByPosition("Value1");
        jobsPage.searchByCity("Value2");
        jobsPage.searchByCompany("Value3");
        jobsPage.searchByDescription("Value4");

        // Click on the reset button
        jobsPage.clearSearch();

        // Verify that all input fields have been cleared
        boolean isValue1Cleared = jobsPage.areSearchResultItemsContainingPositionDisplayed("");
        boolean isValue2Cleared = jobsPage.areSearchResultItemsContainingCityDisplayed("");
        boolean isValue3Cleared = jobsPage.areSearchResultItemsContainingCompanyDisplayed("");
        boolean isValue4Cleared = jobsPage.areSearchResultItemsContainingDescriptionDisplayed("");

        assertTrue(isValue1Cleared);
        assertTrue(isValue2Cleared);
        assertTrue(isValue3Cleared);
        assertTrue(isValue4Cleared);
    }
}

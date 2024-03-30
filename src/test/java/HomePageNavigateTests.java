import Consts.Consts;
import Pages.AboutUsPage;
import Pages.HomePage;
import Pages.JobsPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageNavigateTests extends UseCaseBase {

    private static HomePage homePage;
    private static final Logger logger = LogManager.getLogger(HomePageNavigateTests.class);

    @BeforeAll
    public static void classSetup(){
        homePage = new HomePage();
    }

    // Navigate to Home Page http://167.99.178.249:3000/
    @BeforeEach
    public void beforeTest(){
        homePage.navigateToHomePage();
    }

    @Test
    public void homePageLoadTest(){
        // Verify the page is loaded
        String loaded = homePage.isHomePageLoaded();
        assertEquals(Consts.HOME_PAGE_URL, loaded);

        // Verify logo is visible
        boolean isLogoLoaded = homePage.isLogoVisible();
        assertTrue(isLogoLoaded);

        // Verify coming soon image is on the screen
        boolean isComingSoonImgLoaded = homePage.isComingSoonVisible();
        assertTrue(isComingSoonImgLoaded);
    }

    @Test
    public void clickOnAboutUsMenuOptionTest(){
        // From Home Page click on the About Us menu option
        AboutUsPage aboutUsPage = new AboutUsPage();
        aboutUsPage.navigateToAboutUsPage();

        // Verify about page is opened
        String loaded = aboutUsPage.isAboutUsPageLoaded();
        assertEquals(Consts.ABOUT_US_PAGE_URL, loaded);

        // Verify logo is visible
        boolean isLogoLoaded = aboutUsPage.isLogoVisible();
        assertTrue(isLogoLoaded);
    }

    @Test
    public void clickOnJobsMenuOptionTest(){
        // From Home Page click on the Jobs menu option
        JobsPage jobsPage = new JobsPage();
        jobsPage.navigateToJobsPage();

        // Verify jobs page is opened
        String loaded = jobsPage.isJobsPageLoaded();
        assertEquals(Consts.JOB_PAGE_URL, loaded);
    }
}

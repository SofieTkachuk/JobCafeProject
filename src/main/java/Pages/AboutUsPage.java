package Pages;

public class AboutUsPage extends BasePage {
    private static String LOGO_IMG = "//img[@src='/img/about.jpg']";
    private static String ABOUT_US_MENU_OPTION = "//a[text()='About Us']";

    public void navigateToAboutUsPage(){
        clickElementByXpath(ABOUT_US_MENU_OPTION);
    }

    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }

    public String isAboutUsPageLoaded(){
        String currentURL = getCurrentPageURL();
        return currentURL;
    }

    @Override
    public void verifyLogs() {
        super.verifyLogs();
    }
}

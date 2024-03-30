package Pages;

import Consts.Consts;

public class HomePage extends BasePage{
    private static String LOGO_IMG = "//img[@src='img/logo16.png']";
    private static String COMING_SOON_IMG = "//img[@alt='coming soon']";

    public void navigateToHomePage(){
        webDriver.get(Consts.HOME_PAGE_URL);
    }

    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }

    public boolean isComingSoonVisible(){
        Boolean isVisible = elementExists(COMING_SOON_IMG);
        return isVisible;
    }

    public String isHomePageLoaded(){
        String currentURL = getCurrentPageURL();
        return currentURL;
    }

    @Override
    public void verifyLogs() {
        super.verifyLogs();
    }
}

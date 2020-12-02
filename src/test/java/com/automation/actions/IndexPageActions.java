package com.automation.actions;

import com.automation.base.Base;
import com.automation.pages.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class IndexPageActions extends Base {

    Base base;
    WebDriver driver;
    IndexPage indexPage;

    public IndexPageActions(Base base) {
        this.base = base;
        this.driver = this.base.driver;
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isCoronaBarDisplayed() {
        return indexPage.getCoronaBar().isDisplayed();
    }

    public boolean isCookieBarDisplayed() {
        return indexPage.getCookieBar().isDisplayed();
    }

    public boolean getSelectableOption(String option) {
        if (option.equals("Accept")) {
            return indexPage.getAcceptCookiesLink().isDisplayed();
        } else if (option.equals("Reject")) {
            return indexPage.getRejectCookiesLink().isDisplayed();
        } else {
            return indexPage.getPrivacyPolicyCookiesLink().isDisplayed();
        }
    }

    public void selectOption(String option) {
        if (option.equals("Accept")) {
            indexPage.getAcceptCookiesLink().click();
        } else if (option.equals("Reject")) {
            indexPage.getRejectCookiesLink().click();
        } else {
            indexPage.getPrivacyPolicyCookiesLink().click();
        }
    }

    public void clickCloseBanner(String banner) {
        if (banner.equals("COVID")) {
            indexPage.getCoronaBarCloseIcon().click();
        } else {

        }
    }

    public boolean isBannerVisible(String banner) {
        return false;
    }
}

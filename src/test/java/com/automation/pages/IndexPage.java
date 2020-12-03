package com.automation.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class IndexPage {
    @FindBy(css = "#coronabar")
    WebElement coronaBar;

    @FindBy(css = "#cookie-notice")
    WebElement cookieBar;

    @FindBy(css = ".cb-close-icon")
    WebElement coronaBarCloseIcon;

    @FindBy(linkText = "Accept")
    WebElement acceptCookiesLink;

    @FindBy(linkText = "Reject")
    WebElement rejectCookiesLink;

    @FindBy(linkText = "Privacy policy")
    WebElement privacyPolicyCookiesLink;

    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

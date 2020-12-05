package com.automation.stepdefs;

import com.automation.actions.IndexPageActions;
import com.automation.base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IndexPageSteps extends Base {

    Base base;
    IndexPageActions indexPageActions;
    private String BASE_URL = "http://www.thestudiolivingston.com";

    public IndexPageSteps(Base base) {
        this.base = base;
        indexPageActions = new IndexPageActions(base);
    }

    @Given("I am on the {string} page")
    public void iAmOnThePage(String page) {
        if (page.equals("index")) {
            indexPageActions.getUrl(BASE_URL);
        } else {
            assertThat(String.format("%s page is visible", page),
                    indexPageActions.getCurrentUrl(),
                    containsString(page));
        }
    }

    @Given("the COVID banner is visible")
    public void theCovidBannerIsVisible() {
        assertThat("COVID banner is visible",
                indexPageActions.isCoronaBarDisplayed(),
                is(true));
    }

    @Given("the Cookie banner is visible")
    public void theCookieBannerIsVisible() {
        assertThat("Cookie banner is visible",
                indexPageActions.isCookieBarDisplayed(),
                is(true));
    }

    @Given("the {string} option is selectable")
    public void theOptionIsSelectable(String option) {
        assertThat(String.format("The %s is selectable", option),
                indexPageActions.getSelectableOption(option),
                is(true));
    }

    @When("I select {string}")
    public void iSelect(String option) {
        indexPageActions.selectOption(option);
    }

    @When("I see the following information associated with each header")
    public void iSeeTheFollowingInformationAssociatedWithEachHeader(List<Map<String, String>> headerValue) {
        for (Map<String, String> keyPair : headerValue) {
            keyPair.containsValue("Get value from element");
        }
    }

    @Then("I can close the COVID banner successfully")
    public void iCanCloseTheCovidBannerSuccessfully() {
        indexPageActions.clickCloseBanner("COVID");
        assertThat("COVID banner is no longer visible",
                indexPageActions.isBannerVisible("COVID"),
                is(false));
    }

    @Then("I can close the Cookie banner successfully")
    public void iCanCloseTheCookieBannerSuccessfully() {
        indexPageActions.clickCloseBanner("Cookie");
        assertThat("COVID banner is no longer visible",
                indexPageActions.isBannerVisible("COVID"),
                is(false));
    }
}

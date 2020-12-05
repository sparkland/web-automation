package com.automation.hooks;

import com.automation.base.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

public class Hooks extends Base {

    private Base base;

    public Hooks(Base base) {
        this.base = base;
        this.driver = this.base.driver;
    }

    @Before
    public void setup() throws MalformedURLException {
        String driverSelection = System.getProperty("driver") == null ? "chrome" : System.getProperty("driver");
        base.getDriver(driverSelection);
    }

    @AfterStep
    public void stepTeardown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "Scenario Failure Screenshot");
        }
    }

    @After
    public void teardown() {
        base.quitDriver();
    }
}

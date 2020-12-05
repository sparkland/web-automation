package com.automation.hooks;

import com.automation.base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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

    @After
    public void teardown() {
        base.quitDriver();
    }
}

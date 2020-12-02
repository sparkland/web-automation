package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

    public WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "drivers/mac/chromedriver");
            driver = new ChromeDriver(new ChromeOptions().addArguments("--incognito"));
        }
        return driver;
    }

    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}

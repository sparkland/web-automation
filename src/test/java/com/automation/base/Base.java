package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    public WebDriver driver;

    public WebDriver getDriver(String driverType) throws MalformedURLException {
        if (driverType.equals("chrome")) {
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", "drivers/mac/chromedriver");
                driver = new ChromeDriver(new ChromeOptions().addArguments("--incognito"));
            }
        } else if (driverType.equals("remote")) {
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", "drivers/mac/chromedriver");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            }
        }
        return driver;
    }

    public void quitDriver() {
        driver.close();
        driver.quit();
    }
}

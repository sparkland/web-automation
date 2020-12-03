package com.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue={"com.automation"},
        features = "src/test/resources",
        plugin = { "pretty", "html:target/cucumber-pretty", "json:target/jsonReports/cucumber.json"})
public class RunCucumberIT {

}

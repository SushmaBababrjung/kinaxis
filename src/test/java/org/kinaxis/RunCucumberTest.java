package org.kinaxis;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.kinaxis.steps",
        plugin = {"pretty", "html:target/cucumber-reports", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}
)
public class RunCucumberTest {
}
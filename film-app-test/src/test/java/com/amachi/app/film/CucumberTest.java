
package com.amachi.app.film;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", plugin = {"pretty", "json:target/cucumber-report.json", "html:target/cucumber-report.html"})
public class CucumberTest {

}
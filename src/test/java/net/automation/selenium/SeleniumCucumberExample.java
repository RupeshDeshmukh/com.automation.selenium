package net.automation.selenium;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Selenium - Cucumber basic example.
 * 
 * <ul>
 * <li>Refer to <code>net.wl.selenium.SearchSteps</code> for steps
 * definition.</li>
 * <li>Refer to <code>net.wl.selenium.search.feature</code> for related feature
 * file.</li>
 * </ul>
 * 
 * @author Rupesh Deshmukh
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/html"}, monochrome = true, features = {"src/test/resources/"})
public class SeleniumCucumberExample {
}

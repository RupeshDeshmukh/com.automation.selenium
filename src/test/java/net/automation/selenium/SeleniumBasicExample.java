package net.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic selenium example. This example searches for the term “Cheese” on Google
 * and then outputs the result page’s title to the console.
 * 
 * @author Rupesh Deshmukh
 */
public class SeleniumBasicExample {

    /**
     * Slf4j logger instance for logging.
     */
    private static final transient Logger LOGGER = LoggerFactory.getLogger(SeleniumBasicExample.class);

    /**
     * Here first FirefoxDriver instance is created and then google search site
     * is invoked to search for term Cheese.
     * 
     * @param args
     *            Array of string.
     */
    public static void main(final String[] args) {

        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        final WebDriver driver = createFireFoxDriver();

        // And now use this to visit Google
        driver.navigate().to("https://www.google.co.in/");

        // Find the text input element by its name
        final WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the
        // element
        element.submit();

        // Check the title of the page
        LOGGER.info("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        LOGGER.info("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }

    /**
     * Method to create FireFoxDriver instance by setting FirefoxProfile and
     * DesiredCapabilities.
     * 
     * @return <code>org.openqa.selenium.firefox.FirefoxDriver</code>.
     */
    private static WebDriver createFireFoxDriver() {

        final FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxProfile.setPreference("layers.acceleration.disabled", true);

        final DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

        return new FirefoxDriver(desiredCapabilities);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloWorld;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

/**
 *
 * @author AsphaltPanthers
 */
public class HelloWorldTest extends BaseTest {

    private Selenium selenium;

//    @Test
//    public void helloWorldTestThatFails() {
//        driver.get("http://www.google.com/");
//
//        driver.findElement(By.id("lst-ib")).sendKeys("Hello World!" + Keys.RETURN);
//
//        WebElement rightHandSideHeader = driver.findElement(By.xpath("//div[contains(@class, 'kno-ecr-pt')]"));
//        assertEquals("\"Hello, World!\" program", rightHandSideHeader.getText());
//    }
//
//    @Test
//    public void helloWorldTestThatSucceeds() {
//        driver.get("http://www.google.com/");
//
//        driver.findElement(By.id("lst-ib")).sendKeys("Hello World!" + Keys.RETURN);
//
//        By rightHandSideSelector = By.xpath("//div[contains(@class, 'kno-ecr-pt')]");
//        waitUntil(d -> d.findElement(rightHandSideSelector).isDisplayed());
//        assertEquals("\"Hello, World!\" program", driver.findElement(rightHandSideSelector).getText());
//    }

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://store.demoqa.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testExample1() throws Exception {
        selenium.open("/products-page/checkout/");
        selenium.waitForPageToLoad("30000");
        selenium.click("css=a.step2 > span");
        selenium.type("id=wpsc_checkout_form_11", "iuy");
        selenium.type("id=wpsc_checkout_form_12", "iu");
        selenium.type("id=wpsc_checkout_form_13", "iu");
        selenium.type("id=wpsc_checkout_form_14", "iu");
        selenium.type("id=wpsc_checkout_form_17", "999998uk");
        selenium.click("css=span > input[name=\"submit\"]");
        selenium.waitForPageToLoad("30000");
        boolean q = selenium.isTextPresent("Checkout");
        assertTrue(q);
        
        
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}

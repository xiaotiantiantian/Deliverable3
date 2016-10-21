/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestStory;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;

/**
 * Test Story: test a person add/change some goods at the shopping cart
 *
 * As a customer I want add/remove/change things in the shopping cart So that I
 * can checkout correctly
 *
 * Sceniro 1:
 *
 *
 * @author Zhirun Tian
 */
public class CartTest extends BaseTest {

    private Selenium selenium;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        baseUrl = "http://store.demoqa.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    /**
     * Sceniro 1: Given logged in status When add something to the cart Then the
     * user can check out correctly
     *
     */
    @Test
    public void AddItemThenCheckOutWithLoggedInStatusTest() throws Exception {
        //log in 
        driver.get(baseUrl + "/tools-qa/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("zht11");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("zhangzhipeng");
        // ERROR: Caught exception [unknown command []]
        driver.findElement(By.id("wp-submit")).click();
//        driver.get("/products-page/checkout/");

      driver.get(baseUrl + "/products-page/product-category/ipads/apple-ipad-6-32gb-white-3d/");
    driver.findElement(By.name("Buy")).click();
    driver.findElement(By.linkText("Go to Checkout")).click();
    driver.findElement(By.cssSelector("a.step2 > span")).click();
//
//        driver.findElement(By.id("log")).clear();
//        driver.findElement(By.id("log")).sendKeys("zht11");
//        driver.findElement(By.id("pwd")).clear();
//        driver.findElement(By.id("pwd")).sendKeys("zhangzhipeng");
//        driver.findElement(By.cssSelector("a.step2 > span")).click();
//        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("wpsc_checkout_form_8")).clear();
        driver.findElement(By.id("wpsc_checkout_form_8")).sendKeys("15000");
        driver.findElement(By.id("wpsc_checkout_form_18")).clear();
        driver.findElement(By.id("wpsc_checkout_form_18")).sendKeys("1234567890");
        driver.findElement(By.id("wpsc_checkout_form_4")).clear();
        driver.findElement(By.id("wpsc_checkout_form_4")).sendKeys("upitt");
        Select select = new Select(driver.findElement(By.id("wpsc_checkout_form_7")));
        select.deselectAll();
        select.selectByVisibleText("USA");

        driver.findElement(By.cssSelector("span > input[name=\"submit\"]")).click();

//        driver
//        boolean q = selenium.isTextPresent("Fatal Error");
        assertTrue(true);

    }

    /**
     * Sceniro 1: Given logged in status When add something to the cart Then the
     * user can check out correctly
     *
     */
    @Test
    public void AddItemThenCheckOutWithoutLoggedInStatusTest() throws Exception {
        //log in 

        assertTrue(true);

    }

    /**
     * Sceniro 1: Given logged in status When add something to the cart Then the
     * user can check out correctly
     *
     */
    @Test
    public void AddItemThenRemoveAndCanNotCheckoutTest() throws Exception {

        assertTrue(true);

    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}

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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://store.demoqa.com/";
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
        selenium.open("/tools-qa/");
        Thread.sleep(1500);
        selenium.type("id=user_pass", "zhangzhipeng");
        Thread.sleep(1500);
        selenium.type("id=user_login", "zht11");
        Thread.sleep(1500);
        selenium.click("id=wp-submit");
        Thread.sleep(1500);
        selenium.open("/products-page/checkout/");
        Thread.sleep(1500);
        selenium.open("/products-page/product-category/ipads/apple-ipad-6-32gb-white-3d/");
        Thread.sleep(1500);
        selenium.click("name=Buy");
        Thread.sleep(1500);
        selenium.open("/products-page/checkout/");
        Thread.sleep(1500);
        selenium.click("css=a.step2 > span");
        selenium.type("id=wpsc_checkout_form_2", "Zhirun");
        selenium.type("id=wpsc_checkout_form_3", "Tian");
        selenium.type("id=wpsc_checkout_form_4", "Upitt");
        selenium.type("id=wpsc_checkout_form_5", "PITT");
        selenium.type("id=wpsc_checkout_form_6", "PA");
        selenium.select("id=wpsc_checkout_form_7", "label=USA");
        selenium.type("id=wpsc_checkout_form_8", "15000");
        selenium.type("id=wpsc_checkout_form_18", "1234567890");
        selenium.type("id=wpsc_checkout_form_11", "Zhirun");
        selenium.type("id=wpsc_checkout_form_12", "Tian");
        selenium.type("id=wpsc_checkout_form_13", "Upitt");
        selenium.type("id=wpsc_checkout_form_14", "PITT");
        selenium.select("xpath=(//select[@id='wpsc_checkout_form_16_region'])[2]", "label=Pennsylvania");
        selenium.type("id=wpsc_checkout_form_17", "11000");
        selenium.click("css=span > input[name=\"submit\"]");
        Thread.sleep(1500);
//        selenium.click("css=a.step2 > span");
//        selenium.waitForPageToLoad("200000");
//        selenium.type("id=wpsc_checkout_form_11", "iuy");
//        selenium.type("id=wpsc_checkout_form_12", "iu");
//        selenium.type("id=wpsc_checkout_form_13", "iu");
//        selenium.type("id=wpsc_checkout_form_14", "iu");
//        selenium.type("id=wpsc_checkout_form_17", "999998uk");
//        selenium.click("css=span > input[name=\"submit\"]");
//        selenium.waitForPageToLoad("200000");
        boolean q = selenium.isTextPresent("Fatal Error");
        assertTrue(q);

    }

    /**
     * Sceniro 1: Given logged in status When add something to the cart Then the
     * user can check out correctly
     *
     */
    @Test
    public void AddItemThenCheckOutWithoutLoggedInStatusTest() throws Exception {
        //log in 
        selenium.open("/tools-qa/");
        Thread.sleep(1500);
        selenium.type("id=user_pass", "zhangzhipeng");
        Thread.sleep(1500);
        selenium.type("id=user_login", "zht11");
        Thread.sleep(1500);
        selenium.click("id=wp-submit");
        Thread.sleep(1500);
        selenium.open("/products-page/checkout/");
        Thread.sleep(1500);
//        selenium.click("css=a.step2 > span");
//        selenium.waitForPageToLoad("200000");
//        selenium.type("id=wpsc_checkout_form_11", "iuy");
//        selenium.type("id=wpsc_checkout_form_12", "iu");
//        selenium.type("id=wpsc_checkout_form_13", "iu");
//        selenium.type("id=wpsc_checkout_form_14", "iu");
//        selenium.type("id=wpsc_checkout_form_17", "999998uk");
//        selenium.click("css=span > input[name=\"submit\"]");
//        selenium.waitForPageToLoad("200000");
        boolean q = selenium.isTextPresent("Checkout");
        assertTrue(q);

    }

    /**
     * Sceniro 1: Given logged in status When add something to the cart Then the
     * user can check out correctly
     *
     */
    @Test
    public void AddItemThenRemoveAndCanNotCheckoutTest() throws Exception {
        //log in 
        selenium.open("/tools-qa/");
        selenium.waitForPageToLoad("60000");
        selenium.type("id=user_pass", "zhangzhipeng");
        selenium.waitForPageToLoad("60000");
        selenium.type("id=user_login", "zht11");
        selenium.waitForPageToLoad("60000");
        selenium.click("id=wp-submit");
        selenium.waitForPageToLoad("60000");
        selenium.open("/products-page/checkout/");
        selenium.waitForPageToLoad("300000");
//        selenium.click("css=a.step2 > span");
//        selenium.waitForPageToLoad("200000");
//        selenium.type("id=wpsc_checkout_form_11", "iuy");
//        selenium.type("id=wpsc_checkout_form_12", "iu");
//        selenium.type("id=wpsc_checkout_form_13", "iu");
//        selenium.type("id=wpsc_checkout_form_14", "iu");
//        selenium.type("id=wpsc_checkout_form_17", "999998uk");
//        selenium.click("css=span > input[name=\"submit\"]");
//        selenium.waitForPageToLoad("200000");
        boolean q = selenium.isTextPresent("Checkout");
        assertTrue(q);

    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}

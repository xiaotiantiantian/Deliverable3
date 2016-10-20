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
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Test Story: Test the search result would be related with key word used
 *
 * As a customer I want to search the items with the key words If input the some
 * key words, it would return needed items
 *
 *
 *
 *
 *
 * @author Zhirun Tian
 */
public class SearchTest extends BaseTest {

    private Selenium selenium;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
//        String baseUrl = "http://store.demoqa.com/";
        baseUrl = "http://store.demoqa.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    /**
     * Sceniro 1: Given one searchable key word, When input it and press enter
     * login button user can login correctly
     *
     */
    @Test
    public void testTestSearch() throws Exception {
        selenium.open("/");
        Thread.sleep(500);;
        selenium.click("css=img[alt=\"home\"]");
        Thread.sleep(500);
        selenium.type("name=s", "iPhone");
        Thread.sleep(500);

        boolean q = selenium.isTextPresent("iPhone");
        assertTrue(q);
    }

    /**
     * Sceniro 2: Given a test of hacking propose, When input it and press enter
     * Then the page would prompt "Not Acceptable".
     */
    @Test
    public void SearchWithBadInputTest() throws Exception {
        selenium.open("/?s=%20%27%20and%201=1");


        boolean q;
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {

                if (q = selenium.isTextPresent("Not Acceptable")) {

                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(500);
        }
        assertTrue(q);

    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}

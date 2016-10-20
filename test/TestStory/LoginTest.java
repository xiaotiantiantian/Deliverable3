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
 * Test Story: test a person login with correct or error username and password
 *
 * As a customer I want to login with correct password and could not login with
 * uncorrect password and username
 *
 * can checkout correctly
 *
 *
 *
 *
 * @author Zhirun Tian
 */
public class LoginTest extends BaseTest {

    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://store.demoqa.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    /**
     * Sceniro 1: Given correct username and password, When input it and press
     * login button user can login correctly
     *
     */
    @Test
    public void LoginWithWordPressPageCorrectTest() throws Exception {
        //log in 
        selenium.open("/tools-qa/");
        selenium.waitForPageToLoad("60000");
        selenium.type("id=user_pass", "zhangzhipeng");
        selenium.waitForPageToLoad("60000");
        selenium.type("id=user_login", "zht11");
        selenium.waitForPageToLoad("60000");
        selenium.click("id=wp-submit");
        selenium.waitForPageToLoad("160000");
        boolean q = selenium.isTextPresent("Howdy");
        assertTrue(q);

    }

    /**
     * Sceniro 2: 
     * Given correct username and wrong password, 
     * When input it and press login button user can login correctly
     * Then the page would prompt ERROR: Invalid login credentials.
     */
    @Test
    public void LoginWithWordPressPageWrongPasswordTest() throws Exception {
        //log in 
        selenium.open("/tools-qa/");
        selenium.waitForPageToLoad("60000");
        selenium.type("id=user_pass", "zhangzhieng");
        selenium.waitForPageToLoad("60000");
        selenium.type("id=user_login", "zht11");
        selenium.waitForPageToLoad("60000");
        selenium.click("id=wp-submit");
        selenium.waitForPageToLoad("160000");

        boolean q = selenium.isTextPresent("ERROR: Invalid login credentials.");
        assertTrue(q);

    }

    /**
     * Sceniro 3: 
     * Given correct password and wrong username, 
     * When input it and press login button user can login correctly
     * Then the page would prompt ERROR: Invalid login credentials.
     *
     */
    @Test
    public void LoginWithWordPressPageWrongUserNameTest() throws Exception {
        //log in 
        selenium.open("/tools-qa/");
        selenium.waitForPageToLoad("60000");
        selenium.type("id=user_pass", "zhangzhipeng");
        selenium.waitForPageToLoad("60000");
        selenium.type("id=user_login", "zhwrong");
        selenium.waitForPageToLoad("60000");
        selenium.click("id=wp-submit");
        selenium.waitForPageToLoad("160000");
        boolean q = selenium.isTextPresent("ERROR: Invalid login credentials.");
        assertTrue(q);

    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}

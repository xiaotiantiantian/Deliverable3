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

/**
 * Test Story: test a person login with correct or error username and password
 *
 * As a customer I want to login with correct password and could not login with
 * uncorrect password and username
 *
 *
 *
 *
 * @author Zhirun Tian
 */
public class LoginTest extends BaseTest {

    private Selenium selenium;
    String baseUrl = "http://store.demoqa.com/";

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://store.demoqa.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    /**
     * Sceniro 1: 
     * Given correct username and password, 
     * When input it and press
     * login button
     * Then user can login correctly
     *
     */
    @Test
    public void LoginWithWordPressPageCorrectTest() throws Exception {
        //log in 
        driver.get(baseUrl + "/tools-qa/");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("zht11");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("zhangzhipeng");

        driver.findElement(By.id("wp-submit")).click();

        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*css=div\\.wp-menu-name[\\s\\S]*$"));
        } catch (Error e) {

        }

    }

    /**
     * Sceniro 2: Given correct username and wrong password, When input it and
     * press login button user can login correctly Then the page would prompt
     * ERROR: Invalid login credentials.
     */
    @Test
    public void LoginWithWordPressPageWrongPasswordTest() throws Exception {
        driver.get(baseUrl + "/tools-qa/");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("zht11");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("zhangz99ng");
        driver.findElement(By.id("wp-submit")).click();

        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*id=login_error[\\s\\S]*$"));
        } catch (Error e) {

        }

    }

    /**
     * Sceniro 3: Given correct password and wrong username, When input it and
     * press login button user can login correctly Then the page would prompt
     * ERROR: Invalid login credentials.
     *
     */
    @Test
    public void LoginWithWordPressPageWrongUserNameTest() throws Exception {
        driver.get(baseUrl + "/tools-qa/");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("zht1");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("zhangzhipeng");
        driver.findElement(By.id("wp-submit")).click();
        // Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*id=login_error[\\s\\S]*$"));
        } catch (Error e) {
        }

    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}

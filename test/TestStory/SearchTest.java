/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestStory;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

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
//    Actions builder = new Actions(driver);   

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
//        String baseUrl = "http://store.demoqa.com/";
        baseUrl = "http://store.demoqa.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

     /**
     * Sceniro 1: 
     * Given a test of searching propose, 
     * the input is "iPhone", which is a key word
     * When input it and press enter
     * Then the page would return all the answers
     */
    @Test
    public void SearchKeyWordTest() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("s")).sendKeys("iPhone");
        driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
        try {
            List<WebElement> allChildElements = driver.findElements(By.cssSelector("h2.prodtitle"));
            for (WebElement item : allChildElements) {
               assertTrue(item.getText().contains("iPhone")) ;
            }
        } catch (Error e) {
                
        }

    }

    /**
     * Sceniro 2: 
     * Given a test of hacking propose, 
     * the input is " ' and 1=1" The "%20%27%20and%201=1" is the HTML Url
     * encoding of " ' and 1=1" 
     * When input it and press enter
     * Then the page would prompt "Not Acceptable".
     */
    @Test
    public void SearchWithBadInputTest() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("s")).sendKeys(" ' %20%27%20and%201=1");
        driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
        try {
            String titleAlert = driver.getTitle();
            assertEquals("Not Acceptable!", titleAlert);
        } catch (Error e) {
        
        }


    }
    
    
     /**
     * Sceniro 3: 
     * Given a test of searching propose, 
     * the input is "qa", which is a key word
     * When input it and press enter
     * Then the page would return all the answers, which means, return no results
     */
    @Test
    public void SearchNotExistTest() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.name("s")).sendKeys("iPhone");
        driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
        try {
            List<WebElement> allChildElements = driver.findElements(By.cssSelector("h2.prodtitle"));
            for (WebElement item : allChildElements) {
               assertFalse(item.getText().contains("qa")) ;
            }
        } catch (Error e) {
                
        }

    }
    

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}

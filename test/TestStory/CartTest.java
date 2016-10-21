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
import org.openqa.selenium.support.ui.ExpectedConditions;
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
     * Sceniro 1: Given logged in status When add item to the cart Then the user
     * can go to check out page correctly
     *
     */
    @Test
    public void AddItemThenGoToCheckOutTest() throws Exception {
        //log in 
        driver.get(baseUrl + "/tools-qa/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("zht11");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("zhangzhipeng");
        driver.findElement(By.id("wp-submit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wp-admin-bar-my-account")));
        driver.get(baseUrl + "/products-page/product-category/ipads/apple-ipad-6-32gb-white-3d/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Buy")));
        driver.findElement(By.name("Buy")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Go to Checkout")));
        driver.findElement(By.linkText("Go to Checkout")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#checkout_page_container .step2")));
        String s = driver.findElement(By.cssSelector("BODY")).getText();
        boolean q = s.contains("Checkout");
        assertTrue(q);

    }

    /**
     * Sceniro 2: Given logged out status When add something to the cart Then
     * the user can go to check out page correctly
     *
     */
    @Test
    public void AddItemThenCheckOutWithoutLoggedInStatusTest() throws Exception {
        //log in 
        driver.get(baseUrl + "/tools-qa/?action=logout");
        driver.get(baseUrl + "/products-page/product-category/ipads/apple-ipad-6-32gb-white-3d/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Buy")));
        driver.findElement(By.name("Buy")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Go to Checkout")));
        driver.findElement(By.linkText("Go to Checkout")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#checkout_page_container .step2")));
        String s = driver.findElement(By.cssSelector("BODY")).getText();
        boolean q = s.contains("Checkout");
        assertTrue(q);

    }

    /**
     * Sceniro 3: Given logged in status with item in shopping cart in Checkout
     * page When change the item number and press update then user can find the
     * nubmer of item updated correctly
     *
     */
    @Test
    public void UpdateItemNumberWhenCheckOutTest() throws Exception {
        driver.get(baseUrl + "/tools-qa/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("zht11");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("zhangzhipeng");
        driver.findElement(By.id("wp-submit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wp-admin-bar-my-account")));
        driver.get(baseUrl + "/products-page/product-category/ipads/apple-ipad-6-32gb-white-3d/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Buy")));
        driver.findElement(By.name("Buy")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Go to Checkout")));
        driver.findElement(By.linkText("Go to Checkout")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#checkout_page_container .step2")));

        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("2");
        driver.findElement(By.name("submit")).click();

        String s = driver.findElement(By.cssSelector("BODY")).getText();
        boolean q = s.contains("2");
        assertTrue(q);

    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}

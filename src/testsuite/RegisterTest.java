package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 3. Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * * click on the ‘Create an Account’ link
 * * Verify the text ‘Create New Customer Account’
 * 2. userShouldRegisterAccountSuccessfully
 * * click on the ‘Create an Account’ link
 * * Enter First name
 * * Enter Last name
 * * Click on checkbox Sign Up for Newsletter
 * * Enter Email
 * * Enter Password
 * * Enter Confirm Password
 * * Click on Create an Account button
 * * Verify the text 'Thank you for
 * registering with Main Website Store.’
 * * Click on down aero near Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        //click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//a[text() ='Create an Account']")).click();

        //Verify the text ‘Create New Customer Account’
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.className("base")).getText();
        System.out.println(actualText);
        Assert.assertEquals("Error Message is not Displayed", expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//a[text() ='Create an Account']")).click();
        //Enter First name in First name field
        driver.findElement(By.xpath("//input[@id='firstname' and @name='firstname']")).sendKeys("Gery");
        //Enter Last name in Last name field
        driver.findElement(By.xpath("//input[@id='lastname' and @name='lastname']")).sendKeys("John");
        //Enter Email Address in Email Address field
        driver.findElement(By.xpath("//input[starts-with(@id,'email')]")).sendKeys("geryjohn56@gmail.com");
        //Enter Password in Password field
        driver.findElement(By.xpath("//input[@id='password' or @name ='password']")).sendKeys("123456A!12");
        //Enter Confirm Password in Confirm Password field
        driver.findElement(By.id("password-confirmation")).sendKeys("123456A!12");
        //Click on Create an Account button
        driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
        //Verify the text 'Thank you for registering with Main Website Store.'
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[text() ='Thank you for registering with Main Website Store.']")).getText();
        Assert.assertEquals("Error Message",expectedText,actualText);
        //Click on drop down aero near Welcome
        driver.findElement(By.xpath("//button[@type ='button']")).click();
        //Click on Sign Out link
       // driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
        driver.findElement(By.xpath("//a[@href = 'https://magento.softwaretestingboard.com/customer/account/logout/']")).click();

        //Verify the text ‘You are signed out’
        String actualText1 = "You are signed out";
        String expectedText1 = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        Assert.assertEquals("Error Message",actualText1,expectedText1);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

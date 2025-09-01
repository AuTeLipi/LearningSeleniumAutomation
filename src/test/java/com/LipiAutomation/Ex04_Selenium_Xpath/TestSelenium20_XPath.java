package com.LipiAutomation.Ex04_Selenium_Xpath;

import com.LipiAutomation.utils.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium20_XPath extends CommonToAll {

    @Description("Verify that with Invalid cred, error message is shown on the test_katalon_login")
    @Test
    public void test_katalon_InvalidLogin() {

        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://katalon-demo-cura.herokuapp.com/");

        findElementByID(driver, "btn-make-appointment").click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");

        /*
        List<WebElement> username_input_box = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username_input_box.get(1).sendKeys("John Doe");

        List<WebElement> password_input_box = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password_input_box.get(1).sendKeys("ThisIsNotAPassword");

        WebElement login_input_box = driver.findElement(By.xpath("//button[@id=\"btn-login\"]"));
        login_input_box.click();
         */

        findElementByID(driver, "txt-username").sendKeys("John Doe");
        findElementByID(driver, "txt-password").sendKeys("abcd");
        findElementByID(driver, "btn-login").click();

        WebElement errmsg = driver.findElement(By.xpath("//p[@class='lead text-danger']"));
        System.out.println(errmsg.getText());

        Assert.assertEquals(errmsg.getText(), "Login failed! Please ensure the username and password are valid.");

        //driver.quit();

    }
}

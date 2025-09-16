package com.LipiAutomation.Tasks;

import com.LipiAutomation.Ex09_WaitHelper.WaitHelpers;
import com.LipiAutomation.utils.CommonToAll;
import com.LipiAutomation.utils.UtilExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class MiniProject_OrangeHRM_DataDrivenTesting extends CommonToAll {

    @Test(dataProvider = "getData")
    public void test_OrangeHRM_NegativeTC(String email, String password) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/hr/web/index.php/auth/login");
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));

        WebElement usernameInputBox = driver.findElement(By.name("username"));
        usernameInputBox.sendKeys(email);

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys(password);

        WebElement LoginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        LoginButton.click();

        new WaitHelpers().waitJVM(2000);

        WebElement ErrorMsg = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
        System.out.println("Negative TC - Error Message: " +ErrorMsg);

        Assert.assertEquals(ErrorMsg.getText(), "Invalid credentials");

        closeBrowser(driver);

    }

    @DataProvider
    public static Object[][] getData() {

        return UtilExcel.getTestDataFromExcel("sheet1");
    }

}

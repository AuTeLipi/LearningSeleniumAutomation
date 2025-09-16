package com.LipiAutomation.Tasks;

import com.LipiAutomation.Ex09_WaitHelper.WaitHelpers;
import com.LipiAutomation.utils.CommonToAll;
import com.LipiAutomation.utils.UtilExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class MiniProject_AppVWO_DataDrivenTesting extends CommonToAll {

    @Test(dataProvider = "getData")
    public void test_VWOLoginDataDriven_Login_NegativeTC(String email, String password) {

        //Using Data Driven Testing
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("Login - VWO"));

        WebElement usernameInputBox = driver.findElement(By.id("login-username"));
        usernameInputBox.sendKeys(email);

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys(password);

        WebElement RememberMe = driver.findElement(By.xpath("(//*[name()='svg' and contains(@class, 'checkbox-radio-icon')])[1]"));
        RememberMe.click();

        WebElement Button = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        Button.click();

        new WaitHelpers().waitJVM(3000);

        WebElement ErrorMsg = driver.findElement(By.xpath("//div[text()='Your email, password, IP address or location did not match']"));
        System.out.println("Error Message: " +ErrorMsg);

        Assert.assertEquals(ErrorMsg.getText(), "Your email, password, IP address or location did not match");

        closeBrowser(driver);

    }


    @Test(dataProvider = "getData")
    public void test_VWOLoginDataDriven_Login_PositiveTC(String email, String password) {

        //Using Data Driven Testing but required valid Login Credentials Only
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs("Login - VWO"));

        WebElement usernameInputBox = driver.findElement(By.id("login-username"));
        usernameInputBox.sendKeys(email);

        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys(password);

        WebElement RememberMe = driver.findElement(By.xpath("(//*[name()='svg' and contains(@class, 'checkbox-radio-icon')])[1]"));
        RememberMe.click();

        WebElement Button = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        Button.click();

        new WaitHelpers().waitJVM(9000);

        System.out.println(driver.getTitle());

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.titleIs("Dashboard"));

        closeBrowser(driver);

    }

    @DataProvider
    public static Object[][] getData() {
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return UtilExcel.getTestDataFromExcel("sheet1");
    }
}

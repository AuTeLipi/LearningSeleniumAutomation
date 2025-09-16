package com.LipiAutomation.Tasks;

import com.LipiAutomation.Ex09_WaitHelper.WaitHelpers;
import com.LipiAutomation.utils.CommonToAll;
import com.LipiAutomation.utils.UtilExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class MiniProject_OrangeHRM_DataDrivenTesting extends CommonToAll {

    @Test(dataProvider = "getData")
    public void test_OrangeHRM_NegativeTC(String email, String password) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        WebElement usernameInputBox = driver.findElement(By.xpath("//input[@name='username']"));
        usernameInputBox.sendKeys(email);

        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInputBox.sendKeys(password);

        WebElement LoginButton = driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']"));
        driver.findElement(with(By.xpath("//button[@type='submit']")).below(LoginButton));

        WebElement ErrorMsg = driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
        System.out.println("Negative TC - Error Message: " +ErrorMsg);

        new WaitHelpers().waitJVM(2000);

        Assert.assertEquals(ErrorMsg.getText(), "Invalid credentials");

    }

    @DataProvider
    public static Object[][] getData() {

        return UtilExcel.getTestDataFromExcel("sheet1");
    }
}

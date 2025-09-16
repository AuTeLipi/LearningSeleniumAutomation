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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class MiniProject_VWO_DataProvider extends CommonToAll {

    @Test(dataProvider = "getData")
    public void test_VWOLoginDataDriven(String email, String password) {

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

    }

    @DataProvider
    public static Object[][] getData() {
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return UtilExcel.getTestDataFromExcel("sheet1");
    }
}

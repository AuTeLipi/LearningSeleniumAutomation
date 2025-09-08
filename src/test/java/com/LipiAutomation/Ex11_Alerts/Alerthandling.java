package com.LipiAutomation.Ex11_Alerts;

import com.LipiAutomation.utils.CommonToAll;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerthandling extends CommonToAll {

    @Test
    public void test_AlertHandling() {

        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://the-internet.herokuapp.com/javascript_alerts");

        //JSAlert
        WebElement JSAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        JSAlert.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result, "You successfully clicked an alert");

        //JSConfirm
        WebElement JSConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        JSConfirm.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.alertIsPresent());

        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        WebElement resultJSConfirm = driver.findElement(By.id("result"));
        Assert.assertEquals(result, "You clicked: Ok");

        //JSConfirmCancel
        WebElement JSConfirmCancel = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        JSConfirm.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait2.until(ExpectedConditions.alertIsPresent());

        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();

        WebElement resultJSConfirmCancel = driver.findElement(By.id("result"));
        Assert.assertEquals(result, "You clicked: Cancel");

        //JSPrompt
        WebElement JSPrompt =driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        JSPrompt.click();

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait3.until(ExpectedConditions.alertIsPresent());

        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Lipi");
        alert3.accept();

        WebElement resultJSPrompt = driver.findElement(By.id("result"));
        Assert.assertEquals(result, "You entered: Lipi");

        //JSPromptCancel
        WebElement JSPromptCancel =driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        JSPromptCancel.click();

        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait4.until(ExpectedConditions.alertIsPresent());

        Alert alert4 = driver.switchTo().alert();
        alert4.dismiss();

        WebElement resultJSPromptCancel = driver.findElement(By.id("result"));
        Assert.assertEquals(result, "You entered: null");

        closeBrowser(driver);


    }
}

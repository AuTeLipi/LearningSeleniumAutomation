package com.LipiAutomation.Tasks;

import io.qameta.allure.Owner;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MiniProject_AppVWO_Trial_Invalid_Email_Message {

    @Description("TC#2 - Verify that with invalid trail login, error message is displayed!")
    @Owner("Lipi Dubbaka")
    @Test
    public void test_AppVWO_Trial_Invalid_Email_Message() {

        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.get("https://app.vwo.com/#/login");

        driver.findElement(By.cssSelector("a[data-qa='bericafeqo']")).click();
        driver.findElement(By.id("page-v1-step1-email")).sendKeys("invalid@com");
        driver.findElement(By.id("page-free-trial-step1-cu-gdpr-consent-checkbox")).click();
        driver.findElement(By.cssSelector("button[data-qa='page-su-submit']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        String errmessage = driver.findElement(By.cssSelector("div.invalid-reason")).getText();
        Assert.assertEquals(errmessage, "The email address you entered is incorrect.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        driver.quit();
    }
}

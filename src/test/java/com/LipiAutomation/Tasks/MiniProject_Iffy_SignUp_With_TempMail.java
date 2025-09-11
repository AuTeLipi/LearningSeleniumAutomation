package com.LipiAutomation.Tasks;

import com.LipiAutomation.Ex09_WaitHelper.WaitHelpers;
import com.LipiAutomation.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MiniProject_Iffy_SignUp_With_TempMail extends CommonToAll {

    @Test
    public void test_iffySignUp() {

        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://iffy.com/");

        driver.findElement(By.linkText("Sign up")).click();

        new WaitHelpers().waitJVM(2000);
        String FirstName = "Lipi";
        WebElement firstname = driver.findElement(By.id("firstName-field"));
        firstname.sendKeys(FirstName);

        String LastName = "Dubbaka";
        WebElement lastname = driver.findElement(By.id("lastName-field"));
        lastname.sendKeys(LastName);

        WebDriver driver1 = new ChromeDriver();
        openBrowser(driver1, "https://temp-mail.org/en");

        new WaitHelpers().waitJVM(12000);

        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail")));
        wait.until(d -> !emailInput.getAttribute("value").equalsIgnoreCase("Loading.."));
        String email = emailInput.getAttribute("value");
        System.out.println("Temp email = " +email);

        driver.switchTo();
        driver.findElement(By.id("emailAddress-field")).sendKeys(email);
        driver.findElement(By.xpath("//button[.//span[text()='Continue']]")).click();

        driver1.switchTo();
        WebElement mailBody = driver1.findElement(By.xpath("//a[contains(text(),' is your verification code')]"));
        mailBody.click();
        String sentence = driver1.findElement(By.xpath("//a[contains(text(),' is your verification code')]")).getText();
        System.out.println(sentence);
        String otp = sentence.split(" ")[0];
        System.out.println(otp);

        driver.switchTo();
        driver.findElement(By.xpath("//input[@autocomplete='one-time-code']")).sendKeys(otp);
        driver.findElement(By.xpath("//button[@data-localization-key='formButtonPrimary']")).click();
        



    }
}

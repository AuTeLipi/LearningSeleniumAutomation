package com.LipiAutomation.Tasks;

import com.LipiAutomation.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class MiniProject_Codepen_RelativeLocator extends CommonToAll {

    @Test
    public void RelativeLocator() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();

        driver.switchTo().frame("result");

        driver.findElement(By.xpath("//form[@id='form']/button")).click();

        // username input and error message
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement usernameError = driver.findElement(with(By.tagName("small")).below(usernameInput));
        String usernameErrorMsg = usernameError.getText();
        System.out.println("Username error: " + usernameErrorMsg);
        Assert.assertEquals(usernameErrorMsg, "Username must be at least 3 characters");

        // email input and error message
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement emailError = driver.findElement(with(By.tagName("small")).below(emailInput));
        String emailErrorMsg = emailError.getText();
        System.out.println("Email error: " + emailErrorMsg);
        Assert.assertEquals(emailErrorMsg, "Email is not invalid");

        // password input and error message
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement passwordError = driver.findElement(with(By.tagName("small")).below(passwordInput));
        String passwordErrorMsg = passwordError.getText();
        System.out.println("Password error: " + passwordErrorMsg);
        Assert.assertEquals(passwordErrorMsg, "Password must be at least 6 characters");

        // confirm password input and error message
        WebElement confirmPasswordInput = driver.findElement(By.id("password2"));
        WebElement confirmPasswordError = driver.findElement(with(By.tagName("small")).below(confirmPasswordInput));
        String confirmPasswordErrorMsg = confirmPasswordError.getText();
        System.out.println("Confirm password error: " + confirmPasswordErrorMsg);
        Assert.assertEquals(confirmPasswordErrorMsg, "Password2 is required");

        closeBrowser(driver);


    }
}

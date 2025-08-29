package com.LipiAutomation.Tasks;

import com.LipiAutomation.utils.CommonToAll;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MiniProject_EspoCRMDemo_LoginFunction extends CommonToAll {

    @Owner("Lipi Dubbaka")
    @Description("Verify Login Functionality of EspoCRM App.")
    @Test
    public void test_LoginFunctionOfEspoCRM() {

        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://demo.us.espocrm.com/");

        Assert.assertEquals(driver.getTitle(), "EspoCRM Demo");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.us.espocrm.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate username input
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        Assert.assertTrue(usernameInput.isDisplayed());

        // Locate language dropdown
        WebElement languageDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-language")));
        Select selectLang = new Select(languageDropdown);
        String selectedOptionLang = selectLang.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOptionLang, "English (UK)");

        driver.findElement(By.id("btn-login")).click();

        // Asserting unique elements like the sidebar with "Home" to verify new page is loaded successfully
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement homeLink = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Home']")));
        Assert.assertTrue(homeLink.isDisplayed());

        closeBrowser(driver);

    }
}

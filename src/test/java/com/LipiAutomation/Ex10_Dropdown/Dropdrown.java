package com.LipiAutomation.Ex10_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdrown {

    private static final Logger log = LoggerFactory.getLogger(Dropdrown.class);

    @Test
    public void test_HerokuappDropdown() {

        // https://the-internet.herokuapp.com/dropdown

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        Select select = new Select(dropdownOption);
        select.selectByVisibleText("Option 1");

        //select.selectByIndex(1);


        driver.quit();

    }
}

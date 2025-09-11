package com.LipiAutomation.Tasks;

import com.LipiAutomation.Ex09_WaitHelper.WaitHelpers;
import com.LipiAutomation.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MiniProject_MakeMyTrip_UsingActionsClass extends CommonToAll {

    @Test
    public  void searchDestination() {

        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']"))).click();

        WebElement fromCityField = driver.findElement(By.id("fromCity"));
        fromCityField.click();

        WebElement inputBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']")));

        inputBox.sendKeys("Hyderabad, India");

        List<WebElement> li = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        for(WebElement e: li) {
            System.out.println(e.getText());
            if(e.getText().contains("Hyderabad, India")) {
                e.click();
            }
        }

        //Assert.assertEquals(driver.findElement(By.xpath("//span[@class='commonModal__close']")).getText(), "Hyderabad");
    }
}

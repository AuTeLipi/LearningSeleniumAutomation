package com.LipiAutomation.Tasks;

import com.LipiAutomation.utils.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
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
import java.util.List;

public class MiniProject_Awesoneqa_Inputbox_Radio_Checkbox extends CommonToAll {

    @Owner("Lipi Dubbaka")
    @Description("Verify able to fill the form succesfully")
    @Test
    public void test_Form() {

        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://awesomeqa.com/practice.html");

        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/practice.html");

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Lipi");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Dubbaka");
        findElementByID(driver, "sex-1").click();
        findElementByID(driver, "exp-3").click();
        findElementByID(driver, "datepicker").sendKeys("12/10/2021");
        findElementByID(driver, "profession-1").click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continents")));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Asia");

        WebElement selectOption = select.getFirstSelectedOption();
        System.out.println("Selected: " + selectOption.getText());
        assert selectOption.getText().equals("Asia");

        WebElement SeleniumCommands = driver.findElement(By.id("selenium_commands"));
        Select select1 = new Select(SeleniumCommands);
        select1.selectByVisibleText("WebElement Commands");

        List<WebElement> selectedOptions = select1.getAllSelectedOptions();
        boolean isSelected = selectedOptions.stream()
                .anyMatch(option -> option.getText().equals("WebElement Commands"));

        Assert.assertTrue(isSelected, "'WebElement Commands' is not selected in the Selenium Commands dropdown");

        findElementByID(driver, "submit").click();

        closeBrowser(driver);

    }
}

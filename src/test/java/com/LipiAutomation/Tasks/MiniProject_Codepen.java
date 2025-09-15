package com.LipiAutomation.Tasks;

import com.LipiAutomation.Ex09_WaitHelper.WaitHelpers;
import com.LipiAutomation.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MiniProject_Codepen extends CommonToAll {

    @Test
    public void test_Codepen_RelativeLocator() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();

        Assert.assertEquals(driver.getCurrentUrl(), "https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        //Submit button is in iframe
        driver.switchTo().frame("result");
        driver.findElement(By.xpath("//form[@id='form']/button")).click();

        new WaitHelpers().waitJVM(2000);

        List<WebElement> locators = driver.findElements(By.xpath("//div[@class='form-control error']"));

        List<String> expectedErrors = Arrays.asList(
                "Username must be at least 3 characters",
                "Email is not invalid",
                "Password must be at least 6 characters",
                "Password2 is required"
        );

        for (int i = 0; i < locators.size(); i++) {
            WebElement smallElement = locators.get(i).findElement(By.tagName("small"));
            String actualMsg = smallElement.getText();
            String expectedMsg = expectedErrors.get(i);

            System.out.println("----------------------------------------------");
            System.out.println("Actual: " + actualMsg);
            System.out.println("Expected: " + expectedMsg);

            Assert.assertEquals(actualMsg, expectedMsg, "Mismatch at index " + i);
        }


        closeBrowser(driver);

    }
}

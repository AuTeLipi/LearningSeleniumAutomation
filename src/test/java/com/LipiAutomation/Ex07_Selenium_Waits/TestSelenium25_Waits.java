package com.LipiAutomation.Ex07_Selenium_Waits;

import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TestSelenium25_Waits {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://app.vwo.com");
        /// e1,e2,2
    }
}

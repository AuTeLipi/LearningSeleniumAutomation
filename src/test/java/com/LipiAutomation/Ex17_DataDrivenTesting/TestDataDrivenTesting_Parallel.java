package com.LipiAutomation.Ex17_DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDrivenTesting_Parallel {

    @DataProvider(name = "LoginData", parallel = true)
    public Object[][] getData() {
            return new Object[][] {
                    new Object[] {"admin@gmail.com", "pass123"},
                    new Object[] {"admin123@gmail.com", "password123" },
                    new Object[] {"administration@gmail.com", "password@admin" }
        };

    }

    @Test(dataProvider = "LoginData")
    public void loginTest(String email, String password) {
        System.out.println(email+ " | " +password);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

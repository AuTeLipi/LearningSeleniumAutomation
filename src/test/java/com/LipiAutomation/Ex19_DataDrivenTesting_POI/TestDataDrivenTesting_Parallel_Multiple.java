package com.LipiAutomation.Ex19_DataDrivenTesting_POI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDrivenTesting_Parallel_Multiple {

    @DataProvider(name = "LoginData", parallel = true)
    public Object[][] getData() {
            return new Object[][] {
                    new Object[] {"admin@gmail.com", "pass123"},
                    new Object[] {"admin123@gmail.com", "password123" },
                    new Object[] {"administration@gmail.com", "password@admin" }
        };

    }

    @DataProvider(name = "LoginData1", parallel = true)
    public Object[][] getData1() {
        return new Object[][] {
                new Object[] {"abc@gmail.com", "pass123"},
                new Object[] {"xyz123@gmail.com", "pass123xyz" },
                new Object[] {"ABC123@gmail.com", "password@ABC" }
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

    @Test(dataProvider = "LoginData1")
    public void loginTest1(String email, String password) {
        System.out.println(email+ " | " +password);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

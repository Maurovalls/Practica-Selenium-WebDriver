package org.practicaprovider.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class DataProviderPractica2 {
    WebDriver driver;
    String url = "https://www.google.com/";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "SearchProvider")
    public void testMethodA(String tester, String search) throws InterruptedException {
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(search);
        System.out.println("Welcome " + tester + " your search word is " + search);
        Thread.sleep(3000);
        String textValue = searchText.getAttribute("value");
        System.out.println("Test value es " + textValue + " and is equals to " + search);
        searchText.clear();
        Assert.assertTrue(textValue.equals(search));
    }

    @Test(dataProvider = "SearchProvider")
    public void testMethodB(String search) throws InterruptedException {
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(search);
        System.out.println("Welcome your search word is " + search);
        Thread.sleep(3000);
        String textValue = searchText.getAttribute("value");
        System.out.println("Test value es " + textValue + " and is equals to " + search);
        searchText.clear();
        Assert.assertTrue(textValue.equalsIgnoreCase(search));
    }

    @DataProvider(name = "SearchProvider")
    public Object[][] getDataFromDataProvider(Method m) {
        if (m.getName().equals("testMethodA")) {
            return new Object[][]{
                    {"Mauro", "Udemy"},
                    {"Constanza", "QA automation"},
                    {"Juan Ignacio", "Finanzas"}
            };
        } else {
            return new Object[][]{
                    {"Mexico"},
                    {"Argentina"},
                    {"EEUU"}
            };
        }
    }
}

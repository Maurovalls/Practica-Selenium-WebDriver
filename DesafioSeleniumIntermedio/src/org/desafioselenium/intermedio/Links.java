package org.desafioselenium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Links {
    WebDriver driver;

    public Links(WebDriver driver){ this.driver = driver; }

    public void linkMyBatis(String actualResult, String expectedResult){
        driver.findElement(By.linkText("www.mybatis.org")).click();
        actualResult = driver.getTitle();
        expectedResult = "The MyBatis Blog";
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }
}

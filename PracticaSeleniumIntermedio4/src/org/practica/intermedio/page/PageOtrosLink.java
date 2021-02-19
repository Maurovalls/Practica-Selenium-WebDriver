package org.practica.intermedio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;

public class PageOtrosLink {
    WebDriver driver;

    public PageOtrosLink(WebDriver driver){ this.driver=driver;}

    public void linkPage(String actualResult, String expectedResult,String link){
        driver.findElement(By.linkText(link)).click();
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "El resultado esperado no es igual");
        driver.navigate().back();
    }

    public void linkPage2(String actualResult, String expectedResult, String link){
        driver.switchTo().frame("navbar-iframe");
        driver.findElement(By.linkText(link)).click();
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "El resultado esperado no es igual");
        driver.navigate().back();
        driver.switchTo().parentFrame();
    }
}

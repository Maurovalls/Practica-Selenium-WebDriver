package org.practica.intermedio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageButton {
    WebDriver driver;

    public PageButton(WebDriver driver){
        this.driver=driver;
    }

    public void enabledDisabled(String css, boolean expected){
        boolean result = driver.findElement(By.cssSelector(css)).isEnabled();
        Assert.assertEquals(result,expected, "El resultado no es el esprado");
    }

    public void buttonName(String actualResult,String expectedResult,String xpath){
        actualResult = driver.findElement(By.xpath(xpath)).getText();
        Assert.assertEquals(actualResult,expectedResult,"No es igual al resultado esperado");
    }
}

package org.desafioselenium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Buscador {
    WebDriver driver;

    public Buscador(WebDriver driver){ this.driver = driver; }

    public void search(String actualResult, String expectedResult,String busqueda){
        driver.findElement(By.cssSelector("input[name ='keyword']")).sendKeys(busqueda);
        driver.findElement(By.cssSelector("input[name ='searchProducts']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(3)")).getText();
        expectedResult = "Finch";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es el correcto");

    }
}

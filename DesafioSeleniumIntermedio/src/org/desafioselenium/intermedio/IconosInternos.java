package org.desafioselenium.intermedio;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class IconosInternos {
    private WebDriver driver;

    public IconosInternos(WebDriver driver){ this.driver = driver; }

    public void iconoBirds(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//area[@href='Catalog.action?viewCategory=&categoryId=BIRDS']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(3) > td:nth-child(2)")).getText();
        expectedResult = "Finch";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

    public void iconoFish(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//area[@href='Catalog.action?viewCategory=&categoryId=FISH']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(4) > td:nth-child(2)")).getText();
        expectedResult = "Koi";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

    public void iconoDogs(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//area[@href='Catalog.action?viewCategory=&categoryId=DOGS']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(4) > td:nth-child(2)")).getText();
        expectedResult = "Dalmation";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

    public void iconoReptiles(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//area[@href='Catalog.action?viewCategory=&categoryId=REPTILES']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(3) > td:nth-child(2)")).getText();
        expectedResult = "Iguana";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

    public void iconoCats(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//area[@href='Catalog.action?viewCategory=&categoryId=CATS']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(3) > td:nth-child(2)")).getText();
        expectedResult = "Persian";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

    public void iconoBirds2(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//area[@href='Catalog.action?viewCategory=&categoryId=BIRDS']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > h2")).getText();
        expectedResult = "Birds";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

}

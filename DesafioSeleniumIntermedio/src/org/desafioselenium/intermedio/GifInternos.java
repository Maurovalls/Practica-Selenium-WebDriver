package org.desafioselenium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GifInternos {
    private WebDriver driver;

    public GifInternos(WebDriver driver){
        this.driver = driver;
    }

    public void gifFish(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//img[@src='../images/sm_fish.gif']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        expectedResult = "Angelfish";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

    public void gifDogs(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//img[@src='../images/sm_dogs.gif']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        expectedResult = "Bulldog";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

    public void gifReptiles(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//img[@src='../images/sm_reptiles.gif']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        expectedResult = "Rattlesnake";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

    public void gifCats(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//img[@src='../images/sm_cats.gif']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        expectedResult = "Manx";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

    public void gifBird(String actualResult, String expectedResult){
        driver.findElement(By.xpath("//img[@src='../images/sm_birds.gif']")).click();
        actualResult = driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        expectedResult = "Amazon Parrot";
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual");
    }

}

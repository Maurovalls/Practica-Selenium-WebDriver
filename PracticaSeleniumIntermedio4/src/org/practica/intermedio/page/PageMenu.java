package org.practica.intermedio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageMenu {
    WebDriver driver;

    public PageMenu(WebDriver driver){
        this.driver=driver;
    }

    public void menuHome(String actualResult,String expectedResult,String selectLink1,String verificar){
        if(verificar.equals("Home")) {
            driver.findElement(By.linkText(selectLink1)).click();
            actualResult = driver.getTitle();
            Assert.assertEquals(actualResult, expectedResult, "El resultado esperado no es igual");
            driver.navigate().back();
        }else if (verificar.equals("Blogs")){
            driver.findElement(By.linkText(verificar)).click();
            driver.findElement(By.linkText(selectLink1)).click();
            actualResult = driver.getTitle();
            Assert.assertEquals(actualResult, expectedResult, "El resultado esperado no es igual");
            driver.navigate().back();
        }
    }

}

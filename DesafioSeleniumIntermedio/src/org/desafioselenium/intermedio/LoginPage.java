package org.desafioselenium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){ this.driver = driver; }

    public void loginIncorrecto(String actualResult, String expectedResult, String userName, String password){
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).clear();
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name='signon']")).click();
        expectedResult = "Invalid username or password. Signon failed.";
        actualResult = driver.findElement(By.xpath("//*[@id=\"Content\"]/ul/li")).getText();
        Assert.assertEquals(actualResult,expectedResult,"Prueba fallida, no sale el texto");
    }
}

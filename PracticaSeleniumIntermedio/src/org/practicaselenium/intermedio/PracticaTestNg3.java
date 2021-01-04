package org.practicaselenium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
/*
1)Ir a la pagina https://demoqa.com/browser-windows
2) Hacer click en el boton New Tab
3) Verificar que la nueva pestaña tengo el texto This is a sample page
4) Cerrar navegador
 */
public class PracticaTestNg3 {
    String baseUrl = "https://demoqa.com/browser-windows";
    WebDriver driver;
    String actualResult = "";
    String expectedResult = "";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeTest
    public void lanzarNavegador(){
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test()
    public void newTab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.cssSelector("button[id='tabButton']")).click();
        Thread.sleep(3000);
        for(String newWindow : driver.getWindowHandles()){
            if(!originalWindow.contentEquals(newWindow)){
                driver.switchTo().window(newWindow);
                break;
            }
        }
        expectedResult = "This is a sample page";
        actualResult = driver.findElement(By.cssSelector("h1[id='sampleHeading']")).getText();
        Assert.assertEquals(actualResult,expectedResult," No son iguales");
    }

}

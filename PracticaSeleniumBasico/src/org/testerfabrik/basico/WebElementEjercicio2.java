package org.testerfabrik.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementEjercicio2 {

    public static void main(String [] args){
        WebDriver driver;
        String url = "http://live.demoguru99.com/index.php";
        String actualResult = "";
        String expectedResult = "TV";

        String chromePath = System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        driver.get(url);

        WebElement linkMobile = driver.findElement(By.linkText("TV"));
        linkMobile.click();

        actualResult = driver.getTitle();

        if(actualResult.contentEquals(expectedResult)){
            System.out.println("La prueba fue superada !!");
        }else{
            System.out.println("La prueba fue fallida !!");
        }

        driver.close();

    }
}

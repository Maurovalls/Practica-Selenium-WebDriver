package org.testerfabrik.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1)Navegar a la pagina http://live.demoguru99.com/index.php
2)Click en el link TV utilizando el locator link
3)Usar CSS selector para dar click en el boton Add to Cart
4)Imprimir en consola el resultado de la compracion del titulo obtenido contra el resultado esperado
5)Cerrar el navegador con quit
 */
public class Locators {

    public static void main(String [] args){
        WebDriver driver;
        String baseURL = "http://live.demoguru99.com/index.php";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("TV")).click();
        //Hacemos clik en el boton ADD TO CART usando el localizador path absoluto
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click();
        //Obtenemos el precio del objeto con el localizador selector
        actualResult = driver.findElement(By.cssSelector("#product-price-4")).getText();
        if(actualResult.contentEquals(expectedResult)){
            System.out.println("Prueba pasada !! el resultado es: "+ actualResult
                    + " es igual a " + expectedResult);
        }else{
            System.out.println("Pureba fallida !! el resultado es: "+actualResult
                    + "no es igual a " + expectedResult);
        }

        driver.quit();

    }
}

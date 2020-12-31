package org.testerfabrik.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1)Navegar a la pagina http://live.demoguru99.com/index.php
2)Click en el link TV utilizando el locator link
3)Usar CSS selector para dar click en el boton Add to Cart
4)Imprimir en consola el resultado de la compracion del titulo obtenido contra el resultado esperado
5)Cerrar el navegador
 */
public class WebElementEjercicio {

    public static void main(String [] args){
        WebDriver driver;

        //Variables
        String baseURL = "http://live.demoguru99.com/index.php";
        String actualResult = "";
        String expectedResult = "$700.00";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        //Click link TV
        WebElement linkTV = driver.findElement(By.linkText("TV"));
        linkTV.click();

        //Click boton ADD TO CART localizador xpath absoluto
        WebElement botonAddToCart = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[2]/div/div[3]/button/span/span"));
        botonAddToCart.click();

        //Obtener precio localizador
        WebElement subtotal = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span"));
        actualResult = subtotal.getText();

        if(actualResult.contentEquals(expectedResult)){
            System.out.println("Prueba pasada !! el resultado esperado es de: "
                    +expectedResult+ " y el resultado actual es: " +actualResult);
        }else{
            System.out.println("Prueba fallida !! el resultado esperado es de: "
                    +expectedResult + " y el resultado actial es de: "+actualResult);
        }

        driver.close();
    }
}

package org.testerfabrik.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1)Navegar a la pagina https://www.google.com/
2)Escribir para buscar Curso java
3)Hacer click en el boton buscar
4)Hacer click en el primer link que salga
5)Obtener el titulo de la pagina y compararlo con el resultado esperado
6)Cerrar el navegador
 */
public class Ejercicio2 {

    public static void main (String[] args) {
        WebDriver driver;
        String url = "https://www.google.com/";
        String actualResult = "";
        String expectedResult = "Cursos y Programas Ejecutivos sobre javascript";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@class = 'gLFyf gsfi']")).sendKeys("Curso java");
        driver.findElement(By.xpath("//input[@class = 'gNO89b']")).click();

        driver.findElement(By.xpath("//div[@class = 'cfxYMc JfZTW c4Djg MUxGbd v0nnCb']")).click();

        actualResult = driver.getTitle();

        if(actualResult.contentEquals(expectedResult)){
            System.out.println("Prueba superada !");
        }else{
            System.out.println("Prueba fallida !");
        }
        driver.quit();

    }
}

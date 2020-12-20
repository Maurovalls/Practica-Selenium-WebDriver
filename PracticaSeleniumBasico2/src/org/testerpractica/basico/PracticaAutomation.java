package org.testerpractica.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
/* Realizar pruebas automatizadas del sitio web http://compendiumdev.co.uk/selenium/testpages/calculate.php
  1) Abrir el navegador
  2) Maximizar la pantalla
  3) Ingresar 2 numeros
  4) Elegir la operacion a realizar
  5) Apretar el boton calcular
  6) Comparar que el resultado esperado sea como el actual
  7) Cerrar el navegador
  Estas pruebas se debera realizar con los 4 operadores
 */
public class PracticaAutomation {
    public static WebDriver driver;
    public static String url = "http://compendiumdev.co.uk/selenium/testpages/calculate.php";
    public static String actualResult = "";

    public static void main(String [] args){
        String pathChrome = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        //Llamada de metodos
        suma(pathChrome);
        multiplicar(pathChrome);
        restar(pathChrome);
        dividir(pathChrome);

    }
    public static void suma(String pathChrome){
        String expectedResult = "100";
        System.setProperty("webdriver.chrome.driver", pathChrome);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name = 'number1']")).sendKeys("40");
        driver.findElement(By.xpath("//input[@name = 'number2']")).sendKeys("60");
        Select op = new Select(driver.findElement(By.name("function")));
        op.selectByVisibleText("plus");
        driver.findElement(By.xpath("//input[@id = 'calculate']")).click();
        actualResult = driver.findElement(By.xpath("//span[@id = 'answer']")).getText();
        if(actualResult.contentEquals(expectedResult)){
            System.out.println("La prueba es superada! el resultado actual es: "+actualResult
                    +" y el resultado esperado es: "+expectedResult);
        }else{
            System.out.println("La prueba es fallida! el resultado actual es: "+actualResult
                    +" y el resultado esperado es: "+expectedResult);
        }
        driver.quit();
    }

    public static void multiplicar(String pathChrome){
        String expectedResult = "50";
        System.setProperty("webdriver.chrome.driver", pathChrome);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name = 'number1']")).sendKeys("5");
        driver.findElement(By.xpath("//input[@name = 'number2']")).sendKeys("10");
        Select op = new Select(driver.findElement(By.name("function")));
        op.selectByVisibleText("times");
        driver.findElement(By.xpath("//input[@id = 'calculate']")).click();
        actualResult = driver.findElement(By.xpath("//span[@id = 'answer']")).getText();
        if(actualResult.contentEquals(expectedResult)){
            System.out.println("La prueba es superada! el resultado actual es: "+actualResult
                    +" y el resultado esperado es: "+expectedResult);
        }else{
            System.out.println("La prueba es fallida! el resultado actual es: "+actualResult
                    +" y el resultado esperado es: "+expectedResult);
        }
        driver.quit();
    }

    public static void restar(String pathChrome){
        String expectedResult = "-28";
        System.setProperty("webdriver.chrome.driver", pathChrome);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name = 'number1']")).sendKeys("-10");
        driver.findElement(By.xpath("//input[@name = 'number2']")).sendKeys("18");
        Select op = new Select(driver.findElement(By.name("function")));
        op.selectByVisibleText("minus");
        driver.findElement(By.xpath("//input[@id = 'calculate']")).click();
        actualResult = driver.findElement(By.xpath("//span[@id = 'answer']")).getText();
        if(actualResult.contentEquals(expectedResult)){
            System.out.println("La prueba es superada! el resultado actual es: "+actualResult
                    +" y el resultado esperado es: "+expectedResult);
        }else{
            System.out.println("La prueba es fallida! el resultado actual es: "+actualResult
                    +" y el resultado esperado es: "+expectedResult);
        }
        driver.quit();
    }

    public static void dividir(String pathChrome){
        String expectedResult = "No se puede dividir por 0";
        System.setProperty("webdriver.chrome.driver", pathChrome);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name = 'number1']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@name = 'number2']")).sendKeys("0");
        Select op = new Select(driver.findElement(By.name("function")));
        op.selectByVisibleText("divide");
        driver.findElement(By.xpath("//input[@id = 'calculate']")).click();
        actualResult = driver.findElement(By.xpath("//span[@id = 'answer']")).getText();
        if(actualResult.contentEquals(expectedResult)){
            System.out.println("La prueba es superada! el resultado actual es: "+actualResult
                    +" y el resultado esperado es: "+expectedResult);
        }else{
            System.out.println("La prueba es fallida! el resultado actual es: "+actualResult
                    +" y el resultado esperado es: "+expectedResult);
        }
        driver.quit();
    }
}

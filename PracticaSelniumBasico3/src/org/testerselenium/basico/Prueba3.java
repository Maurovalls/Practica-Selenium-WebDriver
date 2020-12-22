package org.testerselenium.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    1)Navegar a la pagina http://compendiumdev.co.uk/selenium/testpages/alerts.html
    2)Hacer click en el primer boton Show alert box
    3)Mostrar el mensaje de la alerta
    4)Apretar aceptar y salir de la alerta
    5)Hacer click en el segundo boton show confirm box
    6)Mostrar el mensaje de la alerta
    7)Apretar cancelar y salir de la alerta
    8)Verificar si a dar cancelar da false el texto en la pagina
    9)Hacer click en el tercer boton Show prompt box
    10)Escribir tu nombre
    11)Apretar aceptar y cerrar alerta
    12)Verificar si el texto en la pagina es el mismo que el que introduciste en la alerta
     */
public class Prueba3 {
    public static WebDriver driver;
    public static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    public static String url = "http://compendiumdev.co.uk/selenium/testpages/alerts.html";
    public static String expectedResult1 = "false";
    public static String expectedResult2 = "Mauro";

    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        try{
            driver.findElement(By.xpath("//input[@id = 'alertexamples']")).click();
            Alert alertOne = driver.switchTo().alert();
            String alerTextOne = alertOne.getText();
            System.out.println("El texto de la primer alerta es: "+alerTextOne);
            alertOne.accept();
            driver.findElement(By.xpath("//input[@id = 'confirmexample']")).click();
            Alert alertTwo = driver.switchTo().alert();
            String alerTextTwo = alertTwo.getText();
            System.out.println("El texto de la segunda alerta es: "+alerTextTwo);
            alertTwo.dismiss();
            String actualResult1 = driver.findElement(By.xpath("//p[@id= 'confirmreturn']")).getText();
            if(actualResult1.contentEquals(expectedResult1)){
                System.out.println("Prueba superada ! el resultado actual es "
                        +actualResult1+" y el resultado esperado es: "+expectedResult1);
            }else{
                System.out.println("Prueba fallida ! el resultado actual es "
                        +actualResult1+" y el resultado esperado es: "+expectedResult1);
            }
            driver.findElement(By.xpath("//input[@id = 'promptexample']")).click();
            Alert alerThree = driver.switchTo().alert();
            alerThree.sendKeys("Mauro");
            alerThree.accept();
            String actualResult2 = driver.findElement(By.xpath("//p[@id = 'promptreturn']")).getText();
            if(actualResult2.contentEquals(expectedResult2)){
                System.out.println("Prueba superada ! el resultado actual es "
                        +actualResult2+" y el resultado esperado es: "+expectedResult2);
            }else{
                System.out.println("Prueba fallida ! el resultado actual es "
                        +actualResult2+" y el resultado esperado es: "+expectedResult2);
            }

        }catch(NoSuchElementException e){
            System.out.println("No se encontro el elemento: "+e.getMessage());
        }catch(NoAlertPresentException ex){
            System.out.println("No se encontro la alerta: "+ex.getMessage());
        }catch(WebDriverException exx){
            System.out.println("Error en WebDriver :"+exx.getMessage());
        }catch(Exception exxx){
            System.out.println("Error: "+exxx.getMessage());
        }finally {
            driver.quit();
        }

    }
}

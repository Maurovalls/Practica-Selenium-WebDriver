package org.testerselenium.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1)Navegar a la pagina http://compendiumdev.co.uk/selenium/testpages/alert.html
2)Hacer click en el boton Show alert Box
3)Obtener el texto de la alerta
4)Dar aceptar a la alerta para cerrarla
5)Verificar el texto de la alerta con el esperado
6)Cerrar el navegador
 */
public class Prueba2 {
    public static WebDriver driver;
    public static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    public static String url = "http://compendiumdev.co.uk/selenium/testpages/alert.html";
    public static String alertResul = "";
    public static String expectedResultado = "I am an alert box!";

    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        try{
            driver.findElement(By.xpath("//input[@id = 'alertexamples']")).click();
            Alert alertWindoww = driver.switchTo().alert();
            alertResul = alertWindoww.getText();
            System.out.println(alertResul);
            alertWindoww.accept();
            if(alertResul.contentEquals(expectedResultado)){
                System.out.println("La prueba fue superada !");
            }else{
                System.out.println("La prueba fue fallida !");
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

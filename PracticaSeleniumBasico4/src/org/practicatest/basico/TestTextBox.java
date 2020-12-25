package org.practicatest.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1)Abrir el navegador en la pagina https://demoqa.com/text-box
2)Completar el todos los datos
3)Hacer click en el boton submit
4)Cerrar el navegador
 */

public class TestTextBox {
    public static WebDriver driver;
    public static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    public static String url = "https://demoqa.com/text-box";

    public static void main(String [] args){

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        try{
            driver.findElement(By.id("userName")).sendKeys("Mauro Valls");
            driver.findElement(By.id("userEmail")).sendKeys("pituvalls@hotmail.com");
            driver.findElement(By.xpath("//textarea[@class = 'form-control']")).sendKeys("Hola");
            WebElement permanentAddres = driver.findElement(By.cssSelector("textarea[id = 'permanentAddress']"));
            permanentAddres.sendKeys("Buen dia");
            permanentAddres.submit();

        }catch(NoSuchElementException e){
            System.out.println("No se encontro el lemento: "+e.getMessage());
        }catch(NoSuchFrameException ee){
            System.out.println("No se encontro el frame : "+ ee.getMessage());
        }catch(WebDriverException eee){
            System.out.println("Error de webdriver : "+eee.getMessage());
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }finally {
            driver.quit();
        }
    }
    }




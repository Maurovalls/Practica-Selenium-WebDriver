package org.testerselenium.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
/*
1) Navegar a la pagina https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt
2) Cambia al inframe del boton try
3)Espera que se pueda dar click en el boton try
4)Click en el boton try
5)Espera a que se muestre la alerta
6)Obtener el texto de la alerta
7)Escribir sobre la alerta y cerrarla
8)Verifica que el texto contenga lo que ingresaste en el paso 7
10)Cierra el navegador
 */
public class Prueba {
    public static WebDriver driver;
    public static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver",chromePath);
        String url = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait waitVar = new WebDriverWait(driver,10);
        try{
            driver.switchTo().frame("iframeResult");
            WebElement botonTry = driver.findElement(By.xpath("/html/body/button"));
            waitVar.until(ExpectedConditions.elementToBeClickable(botonTry));
            botonTry.click();
            waitVar.until(ExpectedConditions.alertIsPresent());
            Alert alertWindow = driver.switchTo().alert();
            String alertText = "Hello Buen dia campeon! How are you today?";
            System.out.println(alertText);
            alertWindow.sendKeys("Buen dia campeon");
            alertWindow.accept();
            String result = driver.findElement(By.id("demo")).getText();
            if(alertText.contentEquals(result)){
                System.out.println("Prueba superada !");
            }else{
                System.out.println("Prueba fallida !");
            }
        }catch(NoSuchElementException e){
            System.out.println("No se encontro el elemento : "+e.getMessage());
        }catch(NoSuchFrameException ee){
            System.out.println("No se encontro el frame : "+ee.getMessage());
        }catch(NoAlertPresentException x){
            System.out.println("No se encontro el alerta : "+x.getMessage());
        }catch(TimeoutException xx){
            System.out.println("El tiempo de espera se excedio: "+xx.getMessage());
        }catch(WebDriverException nn){
            System.out.println("Ocurrio un error con WebDrvier :"+nn.getMessage());
        }catch(Exception ex){
            System.out.println("Error :"+ex.getMessage());
        }finally {
            driver.quit();
        }

    }
}

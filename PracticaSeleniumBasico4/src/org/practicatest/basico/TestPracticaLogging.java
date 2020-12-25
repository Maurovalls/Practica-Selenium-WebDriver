package org.practicatest.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 1) Abrir el navegador en la pagina https://the-internet.herokuapp.com/login
 2) Maximizar ventana
 3) Ingresar el nombre de usuario correcto (tomsmith)
 4) Ingresar la contraseña correcta (SuperSecretPassword!)
 5) Hacer click en el boton Logging
 6) Verificar que el Logging fue correcto
 (tendria que salir un mensajea Welcome to the Secure Area. When you are done click logout below.!)
 9) Cerrar el navegador

 */
public class TestPracticaLogging {
    public static WebDriver driver;
    public static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    public static String url = "https://the-internet.herokuapp.com/login";
    public static String expectedResult = "Welcome to the Secure Area. When you are done click logout below.";

    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        try {
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("SuperSecretPassword!");
            password.submit();
            String texto = driver.findElement(By.xpath("//h4[@class = 'subheader']")).getText();
            if(texto.contentEquals(expectedResult)){
                System.out.println("Prueba superada !! se logeo corectamente, el resultado obtenido es: "+texto);
            }else{
                System.out.println("Prueba fallida !! se logeo incorrectamente, el resultado obtenido es: "+texto);
            }

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

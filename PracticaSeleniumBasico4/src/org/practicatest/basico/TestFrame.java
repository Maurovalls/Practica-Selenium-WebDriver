package org.practicatest.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1)Abrir el navegador en la pagina https://demoqa.com/frames
2)Mostrar por pantalla el texto del primer frame
3)Mostrar por pantalla el texto del segundo frame
4)Verificar que los dos textos sean iguales
5)Cerrar el navegador

 */
public class TestFrame {
    public static WebDriver driver;
    public static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    public static String url = "https://demoqa.com/frames";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        try {
            WebElement frame1 = driver.findElement(By.cssSelector("iframe[id = 'frame1']"));
            driver.switchTo().frame(frame1);
            String texto1 = driver.findElement(By.cssSelector("h1[id = 'sampleHeading']")).getText();
            System.out.println("El texto del frame1 es: "+texto1);
            driver.switchTo().parentFrame();
            WebElement frame2 = driver.findElement(By.cssSelector("iframe[id = 'frame2']"));
            driver.switchTo().frame(frame2);
            String texto2 = driver.findElement(By.cssSelector("h1[id = 'sampleHeading']")).getText();
            System.out.println("El texto del frame2 es: "+texto2);
            if(texto1.contentEquals(texto2)){
                System.out.println("Pureba superada !! son iguales");
            }else{
                System.out.println("Prueba fallida !! no son iguales");
            }

        } catch (NoSuchElementException e) {
            System.out.println("No se encontro el lemento: " + e.getMessage());
        } catch (NoSuchFrameException ee) {
            System.out.println("No se encontro el frame : " + ee.getMessage());
        } catch (WebDriverException eee) {
            System.out.println("Error de webdriver : " + eee.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            driver.quit();
        }
    }
}

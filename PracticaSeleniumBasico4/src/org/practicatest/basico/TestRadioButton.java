package org.practicatest.basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1) Abrir el navegador en la pagina https://demoqa.com/radio-button
2) Hacer click en Yes
3) Verificar que el mensaje que diga You have selected Yes
4) Luego hacer click en Impressive
5) Verificar que el mensaje diga You have selected Impressive
 */

public class TestRadioButton {
    public static WebDriver driver;
    public static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    public static String url = "https://demoqa.com/radio-button";
    public static String expectedResult1 = "Yes";
    public static String expectedResult2 = "Impressive";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        try {
            driver.findElement(By.cssSelector("label[for = 'yesRadio']")).click();
            String actualResult1 = driver.findElement(By.cssSelector("span[class = 'text-success']")).getText();
            if (actualResult1.contentEquals(expectedResult1)) {
                System.out.println("Prueba superada !! el resultado es You have selected: "+actualResult1);
            } else {
                System.out.println("Prueba fallida !! el resultado es You have selected: "+actualResult1);
            }
            driver.findElement(By.cssSelector("label[for = 'impressiveRadio']")).click();
            String actualResult2 = driver.findElement(By.cssSelector("span[class = 'text-success']")).getText();
            if (actualResult2.contentEquals(expectedResult2)) {
                System.out.println("Prueba superada !! el resultado es: You have selected " + actualResult2);
            } else {
                System.out.println("Prueba fallida !! el resultado es: You have selected " + actualResult2);
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

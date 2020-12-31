package org.testerfabrik.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1)Navegar a la pagina de inicio de "https://www.phptravels.net/home"
2) Verificar el titulo de la pagina
3)Imprimir en sonsola el resultado de la compracion de titulo obtenido con resultado esperado
4)Cerrar el navegador
 */
public class Ejemplo1 {

    public static void main(String [] args){
        WebDriver driver;
        String baseURL = "https://www.phptravels.net/home";
        String actualResult = "";
        String expectedResult = "PHPTRAVELS | Travel Technology Partner";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "\\drivers\\chromedriver.exe " );

        driver = new ChromeDriver();
        driver.get(baseURL);
        actualResult = driver.getTitle();
        System.out.println(actualResult.contentEquals(expectedResult)? "La prueba fue superada !!"
                + actualResult : "La pureba fallo");

        driver.close();

    }
}

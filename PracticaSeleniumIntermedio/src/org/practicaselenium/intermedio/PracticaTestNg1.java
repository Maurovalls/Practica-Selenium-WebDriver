package org.practicaselenium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
/*
Debemos probar la siguiente pagina https://www.timeanddate.com/
Vamos hacer click en los siguientes links
(World Clock,Calendar,Time Zones,Weather,Sun & Moon,Timers,Calculators,Apps & API,Free Fun)
Tendremos que verificar el titulo de la pagina con el esperado al hacer click en cada link
La post condicion sera siempre regrezar a la pagina principal y comprar que el titulo sea igual que el esperado
1)Navegar a la pagina https://www.timeanddate.com/
2)Antes de cada prueba verificar el titulo d ela pagina principal
3)Dar click en los los links dados
4)Despues de cada prueba volver a la pagina principal
5)Ordenar los casos de prueba
6)Cerrar el navegador antes de terminar las pruebas
7)Verificar que los resultados de TestNG
 */
public class PracticaTestNg1 {
    String baseURL = "https://www.timeanddate.com/";
    WebDriver driver;
    String expectedResult = "";
    String actualResult = "";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeTest
    public void lanzarNavegador(){
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @BeforeMethod
    public void verificarNombrePagina(){
        expectedResult = "timeanddate.com";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }

    @AfterMethod
    public void volverPaginaBlog() { driver.navigate().back(); }

    @AfterTest
    public void tearDown(){ driver.quit(); }

    @Test
    public void worldClock(){
        driver.findElement(By.linkText("World Clock")).click();
        expectedResult = "The World Clock — Worldwide";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }

    @Test
    public void calendar(){
        driver.findElement(By.linkText("Calendar")).click();
        expectedResult = "Calendar 2020";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }

    @Test
    public void timeZones(){
        driver.findElement(By.linkText("Time Zones")).click();
        expectedResult = "Time Overview";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }

    @Test
    public void weather(){
        driver.findElement(By.linkText("Weather")).click();
        expectedResult = "World Temperatures — Weather Around The World";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }

    @Test
    public void sunMoon(){
        driver.findElement(By.linkText("Sun & Moon")).click();
        expectedResult = "Astronomy - Sun - Moon - Eclipses";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }

    @Test
    public void timers(){
        driver.findElement(By.linkText("Timers")).click();
        expectedResult = "Countdown Counters and Timers";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }

    @Test
    public void calculators(){
        driver.findElement(By.linkText("Calculators")).click();
        expectedResult = "Calculators & converters for Time, Dates, Sunrise etc";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }

    @Test
    public void appsAPI(){
        driver.findElement(By.linkText("Apps & API")).click();
        expectedResult = "Apps, API, plug-ins and tools for your site";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }

    @Test
    public void freeFun(){
        driver.findElement(By.linkText("Free Fun")).click();
        expectedResult = "Free countdown for your webpage etc";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult,"El titulo no es igual");
    }




}

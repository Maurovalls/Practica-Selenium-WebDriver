package org.desafioselenium.intermedio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/*
1) Abrir el navegador en la pagina https://petstore.octoperf.com/actions/Catalog.action
2) Verificar si funcionan correctamente todos los gif
3) Verificar que funcionan correctamente todos los iconos,
4) Hacer un login incorrecto donde se verifique el mensaje esperado
5) Verificar que funciona el buscador ingresando la palabra f
6) Verificar que funciona el enlace  www.mybatis.org
7) Cada vez que se purebe un test se debera volver atras a la pagina principal
8)Cerrar el navegador
 */
public class TestSeleniumPetStore {
    String url = "https://petstore.octoperf.com/actions/Catalog.action";
    WebDriver driver;
    String actualResult = "";
    String expectedResult = "";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @BeforeMethod
    public void beforeMethod(){

    }

    @AfterMethod
    public void afterMethod(){
        driver.navigate().back();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void linkFish(){
        GifInternos gif = new GifInternos(driver);
        gif.gifFish(actualResult,expectedResult);
    }

    @Test
    public void linkDogs(){
        GifInternos gif = new GifInternos(driver);
        gif.gifDogs(actualResult,expectedResult);
    }

    @Test
    public void linkReptiles(){
        GifInternos gif = new GifInternos(driver);
        gif.gifReptiles(actualResult,expectedResult);
    }

    @Test
    public void linkCats(){
        GifInternos gif = new GifInternos(driver);
        gif.gifCats(actualResult,expectedResult);
    }

     @Test
    public void linkBirds(){
        GifInternos gif = new GifInternos(driver);
        gif.gifBird(actualResult,expectedResult);
     }

     @Test
     public void iconoBirds(){
        IconosInternos icono = new IconosInternos(driver);
        icono.iconoBirds(actualResult,expectedResult);
     }

     @Test
    public void iconoFish(){
        IconosInternos icono = new IconosInternos(driver);
        icono.iconoFish(actualResult,expectedResult);
     }

    @Test
    public void iconoDogs(){
        IconosInternos icono = new IconosInternos(driver);
        icono.iconoDogs(actualResult,expectedResult);
    }

    @Test
    public void iconoReptiles(){
        IconosInternos icono = new IconosInternos(driver);
        icono.iconoReptiles(actualResult,expectedResult);
    }

    @Test
    public void iconoCats(){
        IconosInternos icono = new IconosInternos(driver);
        icono.iconoCats(actualResult,expectedResult);
    }

    @Test
    public void iconoBirds2(){
        IconosInternos icono = new IconosInternos(driver);
        icono.iconoBirds2(actualResult,expectedResult);
    }

    @Test
    public void loginPage(){
        String userName = "Pitu";
        String password = "1234";
        LoginPage login = new LoginPage(driver);
        login.loginIncorrecto(actualResult,expectedResult,userName,password);
    }

    @Test
    public void search(){
        Buscador buscar = new Buscador(driver);
        String busqueda = "f";
        buscar.search(actualResult,expectedResult,busqueda);
    }

    @Test
    public void linkMyBetis(){
        Links link = new Links(driver);
        link.linkMyBatis(actualResult,expectedResult);
    }









}

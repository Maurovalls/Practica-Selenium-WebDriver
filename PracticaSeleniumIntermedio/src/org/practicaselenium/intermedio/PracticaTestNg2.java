package org.practicaselenium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
/*
1)Navegar a la pagina https://testsheepnz.github.io/BasicCalculator.html
2) Debemos probar todas las operaciones de la calculadora con el prototipo 1
3) Cada vez que probamos una operacion hacer un refresh de la pagina
4) Cerrar el navegador
 */
public class PracticaTestNg2 {
    String baseUrl = "https://testsheepnz.github.io/BasicCalculator.html";
    WebDriver driver;
    String actualResult = "";
    String expectedResult = "";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeTest
    public void lanzarNavegador(){
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @BeforeMethod
    public void select(){
        Select build = new Select(driver.findElement(By.cssSelector("select[id='selectBuild']")));
        build.selectByVisibleText("1");
    }

    @AfterMethod
    public void clear(){
        driver.navigate().refresh();
    }

    @AfterTest
    public void cerrar(){
        driver.quit();
    }

    @Test(priority = 0)
    public void add(){
        OperationPractica2 add = new OperationPractica2(driver);
        String num1 = "600";
        String num2 = "600";
        String ope = "Add";
        expectedResult = "1200";
        add.operaciones(num1,num2,ope,actualResult,expectedResult);
    }

    @Test(priority = 1)
    public void subtract(){
        OperationPractica2 subtract = new OperationPractica2(driver);
        String num1 = "-200";
        String num2 = "-400";
        String ope = "Subtract";
        expectedResult = "200";
        subtract.operaciones(num1,num2,ope,actualResult,expectedResult);
    }

    @Test(priority = 2)
    public void multiply(){
        OperationPractica2 multiply = new OperationPractica2(driver);
        String num1 = "4";
        String num2 = "400";
        String ope = "Multiply";
        expectedResult = "1600";
        multiply.operaciones(num1,num2,ope,actualResult,expectedResult);
    }

    @Test(priority = 4)
    public void divide(){
        OperationPractica2 divide = new OperationPractica2(driver);
        String num1 = "8";
        String num2 = "0";
        String ope = "Divide";
        expectedResult = "Divide by zero error!";
        divide.operaciones(num1,num2,ope,actualResult,expectedResult);
    }

    @Test(priority = 3)
    public void concatenate(){
        OperationPractica2 concatenate = new OperationPractica2(driver);
        String num1 = "100";
        String num2 = "100";
        String ope = "Concatenate";
        expectedResult = "100100";
        concatenate.operaciones(num1,num2,ope,actualResult,expectedResult);
    }






}

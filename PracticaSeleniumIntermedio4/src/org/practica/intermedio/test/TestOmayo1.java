package org.practica.intermedio.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.practica.intermedio.listeners.RealTimeReport;
import org.practica.intermedio.page.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners(RealTimeReport.class)
public class TestOmayo1 {
    WebDriver driver;
    String url = "http://omayo.blogspot.com/";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    String actualResult = "";
    String expectedResult = "";
    PageMenu pageMenu;
    PageOtrosLink links;
    PageComboBox comboBox;
    PageButton pageButton;
    PageList pageList;

    @BeforeTest
    public void beforeTest(){
        System.out.println("================");
        System.out.println("Comienza la primer tanda de casos de prueba");
        System.out.println("================");
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        pageMenu = new PageMenu(driver);
        links = new PageOtrosLink(driver);
        comboBox = new PageComboBox(driver);
        pageButton = new PageButton(driver);
        pageList = new PageList(driver);
    }

    @BeforeMethod
    public void beforeMethod(){

    }

    @AfterMethod
    public void afterMethod(){

    }

    @AfterTest
    public void afterTest(){
        System.out.println("================");
        System.out.println("Finaliza la primer tanda primeros casos de prueba");
        System.out.println("================");
        driver.quit();
    }

    @Test(priority = 17)
    public void titlePage(){
        actualResult = driver.getTitle();
        expectedResult = "omayo (QAFox.com)";
        Assert.assertEquals(actualResult,expectedResult,"No son iguales");
    }

    @Test(priority = 1)
    public void testMenuHome(){
        String verificar = "Home";
        String selectLink1 = "Home";
        expectedResult = "omayo (QAFox.com)";
        pageMenu.menuHome(actualResult,expectedResult,selectLink1,verificar);
    }

    @Test(priority = 2)
    public void testMenuSelenium143(){
        String verificar = "Blogs";
        String selectLink1 = "Selenium143";
        expectedResult = "Selenium143";
        pageMenu.menuHome(actualResult,expectedResult,selectLink1,verificar);
    }

    @Test(priority = 3)
    public void testSeleniumByArun(){
        String verificar = "Blogs";
        String selectLink1 = "SeleniumByArun";
        expectedResult = "Selenium-By-Arun";
        pageMenu.menuHome(actualResult,expectedResult,selectLink1,verificar);
    }

    @Test(priority = 4)
    public void testSeleniumOneByArun(){
        String verificar = "Blogs";
        String selectLink1 = "SeleniumOneByArun";
        expectedResult = "SeleniumOne (QAFox.com)";
        pageMenu.menuHome(actualResult,expectedResult,selectLink1,verificar);
    }

    @Test(priority = 5)
    public void testSeleniumTwoByArun(){
        String verificar = "Blogs";
        String selectLink1 = "SeleniumTwoByArun";
        expectedResult = "SeleniumTwo (QAFox.com)";
        pageMenu.menuHome(actualResult,expectedResult,selectLink1,verificar);
    }

    @Test(priority = 6)
    public void testLinkOnePage(){
        String link = "Page One";
        expectedResult = "omayo (QAFox.com): Page One";
        links.linkPage(actualResult,expectedResult,link);
    }

    @Test(priority = 7)
    public void testCompendiumdev(){
        String link = "compendiumdev";
        expectedResult = "Basic Web Page Title";
        links.linkPage(actualResult,expectedResult,link);
    }

    @Test(priority = 8)
    public void testOnlyTestingBlog(){
        String link = "onlytestingblog";
        expectedResult = "Only Testing: TextBox";
        links.linkPage(actualResult,expectedResult,link);
    }

    @Test(priority = 9)
    public void testTwisely(){
        String link = "testwisely";
        expectedResult = "Demo - TestWisely";
        links.linkPage(actualResult,expectedResult,link);
    }

    @Test(priority = 10)
    public void testJquery(){
        String link = "jqueryui";
        expectedResult = "jQuery UI";
        links.linkPage(actualResult,expectedResult,link);
    }

    @Test(priority = 11)
    public void testTheTomatedTester(){
        String link = "theautomatedtester";
        expectedResult = "Selenium: Beginners Guide";
        links.linkPage(actualResult,expectedResult,link);
    }

    @Test(priority = 12)
    public void multiSelectBox1(){
        String css = "select[id='multiselect1']";
        String opcion = "Volvo";
        comboBox.multiSelectedBox(opcion,css);
    }

    @Test(priority = 13)
    public void multiSelectBox2(){
        String css = "select[id='multiselect1']";
        String opcion = "Hyundai";
        comboBox.multiSelectedBox(opcion,css);
    }

    @Test(priority = 14)
    public void multiSelectBox3() throws InterruptedException {
        String css = "select[name='SiteMap']";
        String opcion = "doc 4";
        comboBox.multiSelectedBox(opcion,css);
    }

    @Test(priority = 15)
    public void search1(){
        driver.switchTo().frame("navbar-iframe");
        driver.findElement(By.cssSelector("input[id='b-query']")).sendKeys("Java");
        driver.findElement(By.cssSelector("a[id='b-query-icon']")).click();
        driver.switchTo().parentFrame();
        actualResult = driver.findElement(By.cssSelector("div[class='status-msg-body']")).getText();
        expectedResult = "No posts matching the query: Java. Show all posts";
        Assert.assertEquals(actualResult,expectedResult,"No es el resultado esperado");
        driver.navigate().back();
    }

    @Test(priority = 16)
    public void search2(){
        driver.findElement(By.cssSelector("input[class='gsc-input']")).sendKeys("Page");
        driver.findElement(By.cssSelector("input[class='gsc-search-button']")).click();
        actualResult = driver.findElement(By.cssSelector("div[class='status-msg-body']")).getText();
        expectedResult = "Showing posts sorted by relevance for query Page. Sort by date Show all posts";
        Assert.assertEquals(actualResult,expectedResult,"No es el resultado esperado");
        driver.navigate().back();
    }
    @Test(priority = 18)
    public void TextBox(){
        WebElement caja = driver.findElement(By.cssSelector("input[id='textbox1']"));
        actualResult = caja.getAttribute("value");
        expectedResult = "Selenium WebDriver";
        Assert.assertEquals(actualResult,expectedResult, "No es igual al resultado esperado");
        caja.clear();
        caja.sendKeys("JAVA");
        actualResult = caja.getAttribute("value");
        expectedResult = "JAVA";
        Assert.assertEquals(actualResult,expectedResult, "No es igual al resultado esperado");
    }



    @Test(priority = 19)
    public void buttonEnabled(){
        String css = "button[id='but2']";
        boolean expected = true;
        pageButton.enabledDisabled(css,expected);
    }

    @Test(priority = 20)
    public void buttonDisabled(){
        String css = "button[id='but1']";
        boolean expected = false;
        pageButton.enabledDisabled(css,expected);
    }

    @Test(priority = 21)
    public void textBox(){
        boolean result = driver.findElement(By.cssSelector("input[id='tb2']")).isEnabled();
        Assert.assertEquals(result,false,"No es igual al resultado esperado");
    }

    @Test(priority = 22)
    public void buttonSubmit(){
        String xpath = "//*[@id=\"HTML10\"]/div[1]/button[1]";
        expectedResult = "Submit";
        pageButton.buttonName(actualResult,expectedResult,xpath);
    }

    @Test(priority = 23)
    public void buttonLogin(){
        String xpath = "//*[@id=\"HTML10\"]/div[1]/button[2]";
        expectedResult = "Login";
        pageButton.buttonName(actualResult,expectedResult,xpath);
    }

    @Test(priority = 24)
    public void buttonRegister(){
        String xpath = "//*[@id=\"HTML10\"]/div[1]/button[3]";
        expectedResult = "Register";
        pageButton.buttonName(actualResult,expectedResult,xpath);
    }

    @Test(priority = 25)
    public void orderedList(){
        String xpath ="//*[@id=\"HTML25\"]/div[1]/ol";
        String identificador = "ordered";
        pageList.listOrdered(xpath,identificador);
    }

    @Test(priority = 26)
    public void unOrderedList(){
        String xpath ="//*[@id=\"HTML26\"]/div[1]/ul";
        String identificador = "unordered";
        pageList.listOrdered(xpath,identificador);
    }

    @Test(priority = 27)
    public void clickAfterTextDissapears(){
        driver.findElement(By.cssSelector("input[id='alert2']")).click();
        Alert alert = driver.switchTo().alert();
        actualResult = alert.getText();
        expectedResult = "Hello";
        alert.dismiss();
        Assert.assertEquals(actualResult,expectedResult,"El resultado no es igual al esperado");
    }

    @Test(priority = 28)
    public void openaPopupwindow(){
        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Open a popup window")).click();
        for( String windowHandle : driver.getWindowHandles()){
            if(!originalWindow.contentEquals(windowHandle)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        actualResult = driver.findElement(By.cssSelector("p[id='para2']")).getText();
        expectedResult = "Another paragraph of text";
        driver.close();
        driver.switchTo().window(originalWindow);
        Assert.assertEquals(actualResult,expectedResult," El resultado no es igual al esperado");
    }

   @Test(priority = 29)
    public void buutonTry() throws InterruptedException {
       driver.findElement(By.cssSelector("#HTML44 > div.widget-content > button:nth-child(3)")).click();
       Thread.sleep(3000);
       boolean result = driver.findElement(By.cssSelector("button[id='myBtn']")).isEnabled();
       Assert.assertEquals(result,false,"El resultado no es igual al esperado");
   }

    @Test(priority = 30)
    public void textAreaField(){
         driver.findElement(By.id("ta1")).sendKeys("Mauro");
    }

    @Test(priority = 31)
    public void textAreaFieldTwo(){
        actualResult = driver.findElement(By.cssSelector("#HTML11 > div.widget-content > textarea")).getText();
        expectedResult = "The cat was playing in the garden.";
        Assert.assertEquals(actualResult,expectedResult,"No es igual al resultado esperado");
    }

    @Test(priority = 32)
    public void sumaEdades(){
        int edadKishore = Integer.parseInt(driver.findElement(By.cssSelector("#table1 > tbody > tr:nth-child(1) > td:nth-child(2)")).getText());
        int edadManish = Integer.parseInt(driver.findElement(By.cssSelector("#table1 > tbody > tr:nth-child(2) > td:nth-child(2)")).getText());
        int edadPraveen = Integer.parseInt(driver.findElement(By.cssSelector("#table1 > tbody > tr:nth-child(3) > td:nth-child(2)")).getText());
        int edadDheepthi = Integer.parseInt(driver.findElement(By.cssSelector("#table1 > tbody > tr:nth-child(4) > td:nth-child(2)")).getText());
        System.out.println("La suma de las edades es: "+(edadKishore+edadManish+edadPraveen+edadDheepthi));
    }

    @Test(priority = 33)
    public void loginSection(){
        WebElement userName = driver.findElement(By.cssSelector("input[name='userid']"));
        WebElement password = driver.findElement(By.cssSelector("input[name='pswrd']"));
        userName.sendKeys("pituvalls");
        password.sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"HTML42\"]/div[1]/form/input[4]")).click();
        String actualResult1 = userName.getAttribute("value");
        String actualResul2 = password.getAttribute("value");
        String expectedResult1 = "";
        String expectedResul2 = "";
        Assert.assertEquals(actualResult1,expectedResult1,"No es igual al resultado esperado");
        Assert.assertEquals(actualResul2,expectedResul2,"No es igual al resultado esperado");
        userName.sendKeys("pituvalls");
        password.sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"HTML42\"]/div[1]/form/input[3]")).click();
        Alert alert = driver.switchTo().alert();
        actualResult = alert.getText();
        alert.dismiss();
        expectedResult = "Error Password or Username";
        Assert.assertEquals(actualResult,expectedResult,"No es igual al resultado esperado");
    }

    @Test(priority = 34)
    public void buttonVGetPrompt(){
        driver.findElement(By.cssSelector("#prompt")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Buen dia");
        alert.accept();
    }
    @Test(priority = 35)
    public void buttonGetConfirmation(){
        driver.findElement(By.cssSelector("#confirm")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @Test(priority = 36)
    public void selectVehicle() throws InterruptedException {
        driver.findElement(By.cssSelector("#HTML32 > div.widget-content > input[type=radio]:nth-child(3)")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 37)
    public void selectMultipleOptions() throws InterruptedException {
        driver.findElement(By.cssSelector("#HTML33 > div.widget-content > input[type=checkbox]:nth-child(2)")).click();
        driver.findElement(By.cssSelector("#HTML33 > div.widget-content > input[type=checkbox]:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#HTML33 > div.widget-content > input[type=checkbox]:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#HTML33 > div.widget-content > input[type=checkbox]:nth-child(4)")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 38)
    public void dropDown() throws InterruptedException {
        driver.findElement(By.cssSelector("button[class='dropbtn']")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Facebook")).click();
        actualResult = driver.getTitle();
        expectedResult = "Facebook - Entrar o registrarse";
        driver.navigate().back();
        Assert.assertEquals(actualResult,expectedResult,"No es igual al resultado esperado");
    }

    @Test(priority = 39)
    public void doubleClickHere(){
        WebElement button = driver.findElement(By.cssSelector("#HTML46 > div.widget-content > button"));
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(button).doubleClick().build();
        action.perform();
        Alert alert = driver.switchTo().alert();
        actualResult = alert.getText();
        alert.accept();
        expectedResult = "Double Click Successfull";
        Assert.assertEquals(actualResult,expectedResult,"No es igual al resultado esperado");
    }
}

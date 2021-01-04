package org.practicaselenium.intermedio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OperationPractica2 {
    WebDriver driver;

    public OperationPractica2(WebDriver driver){ this.driver = driver; }

    public void operaciones(String num1, String num2, String ope, String actualResult, String expectedResult){
        driver.findElement(By.cssSelector("input[id='number1Field']")).sendKeys(num1);
        driver.findElement(By.cssSelector("input[id='number2Field']")).sendKeys(num2);
        Select operation = new Select(driver.findElement(By.cssSelector("select[id='selectOperationDropdown']")));
        operation.selectByVisibleText(ope);
        driver.findElement(By.cssSelector("input[id='calculateButton']")).click();
        if(ope.contentEquals("Divide")){
            actualResult = driver.findElement(By.cssSelector("label[id='errorMsgField']")).getText();
            Assert.assertEquals(actualResult,expectedResult,"No es el mismo resultado");
        }else {
            actualResult = driver.findElement(By.cssSelector("input[id='numberAnswerField']")).getAttribute("value");
            Assert.assertEquals(actualResult, expectedResult, "No es el mismo resultado");
        }
    }

}

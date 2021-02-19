package org.practica.intermedio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PageList {
    WebDriver driver;

    public PageList(WebDriver driver) {
        this.driver = driver;
    }

    public void listOrdered(String xpath,String identificador) {
        WebElement list = driver.findElement(By.xpath(xpath));
        boolean confirm = false;
        if(identificador.equals("ordered")) {
            List<WebElement> items = list.findElements(By.tagName("li"));
            int cantElement = items.size();
            Assert.assertEquals(cantElement, 6, "No es igual al esperado");
        }else if(identificador.equals("unordered")){
            List<WebElement> items = list.findElements(By.tagName("li"));
            for(int i =0; i<items.size(); i++){
                if(items.get(i).getText().equals("Pomegranate")){
                    confirm = true;
                    break;
                }
            }
            Assert.assertEquals(confirm,true);
        }
    }
}


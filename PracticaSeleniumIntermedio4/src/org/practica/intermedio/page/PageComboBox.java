package org.practica.intermedio.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageComboBox {
    WebDriver driver;

    public PageComboBox(WebDriver driver){ this.driver=driver; }

    public void multiSelectedBox(String opcion,String css){
        Select combo = new Select(driver.findElement(By.cssSelector(css)));
        combo.selectByVisibleText(opcion);
    }

}

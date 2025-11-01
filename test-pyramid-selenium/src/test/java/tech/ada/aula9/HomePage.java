package tech.ada.aula9;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void doLogout() {
        WebElement linkLogout = webDriver.findElement(By.linkText("Logout"));

        linkLogout.click();

        Alert alert = webDriver.switchTo().alert();

        alert.accept();
    }


}

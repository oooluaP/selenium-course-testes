package tech.ada.aula9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    WebDriver webDriver;
    WebElement username;
    WebElement email;
    WebElement password;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.username = webDriver.findElement(By.id("username"));
        this.email = webDriver.findElement(By.id("email"));
        this.password = webDriver.findElement(By.id("password"));
    }

    public void createDeveloper(Developer developer) {

        this.username.sendKeys(developer.getUsername());
        this.email.sendKeys(developer.getEmail());
        this.password.sendKeys(developer.getPassword());

        WebElement bio = webDriver.findElement(By.id("bio"));
        bio.sendKeys(developer.getBio());

        WebElement tShirt = webDriver.findElement(By.id("tShirt"));
        Select selectTShirt = new Select(tShirt);
        selectTShirt.selectByVisibleText(developer.gettShirt());

        WebElement backend = webDriver.findElement(By.id("backend"));
        backend.click();

        WebElement other = webDriver.findElement(By.id("other"));
        other.click();

        String preferredLanguage = switch (developer.getPreferredLanguage()) {
            case JAVA -> "preferred_language_java";
            case JS -> "preferred_language_javascript";
            case PYTHON -> "preferred_language_python";
        };

        WebElement radioJava = webDriver.findElement(By.id(preferredLanguage));
        radioJava.click();
    }
}

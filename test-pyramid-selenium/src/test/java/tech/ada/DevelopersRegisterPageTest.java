package tech.ada;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

public class DevelopersRegisterPageTest {

    static WebDriver webDriver;

    public DevelopersRegisterPageTest() {
        webDriver = new ChromeDriver();
    }

    @Test
    void deveCadastrarCorretamente() {

        webDriver.get(Constants.BASE_URL + "/register");

        WebElement firstName = webDriver.findElement(By.id("firstName"));
        firstName.sendKeys("Matheus");

        WebElement lastName = webDriver.findElement(By.id("lastName"));
        lastName.sendKeys("Cruz");

        WebElement email = webDriver.findElement(By.id("email"));
        email.sendKeys("matheus1@email.com");

        WebElement username = webDriver.findElement(By.id("username"));
        username.sendKeys("matheus3" + UUID.randomUUID());

        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("123456");

        // Se existir, você sempre deve utilizar o ID.
        WebElement button = webDriver.findElement(By.tagName("button"));

        button.click();

        WebElement message = webDriver.findElement(By.cssSelector(".text-white.text-lg"));

        Assertions.assertEquals("Registered with success!", message.getText());

        WebElement linkBackToLogin = webDriver.findElement(By.linkText("Back to login"));

        Assertions.assertTrue(linkBackToLogin.isDisplayed());

        webDriver.quit();
    }

}

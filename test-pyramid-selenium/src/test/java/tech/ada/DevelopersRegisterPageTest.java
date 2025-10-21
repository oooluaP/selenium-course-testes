package tech.ada;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
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

    @Test
    void deveMostrarErroQuandoOFirstNameDoFormularioForInvalido() {

        webDriver.get(Constants.BASE_URL + "/register");

        WebElement firstName = webDriver.findElement(By.id("firstName"));
        firstName.sendKeys("A"); // incorreto

        WebElement button = webDriver.findElement(By.tagName("button"));

        // submit
        button.click();

        List<WebElement> elements = webDriver.findElements(By.cssSelector(".text-rose-500.text-sm.w-full"));

        String expected = "First name must be at least 2 characters long";
//        boolean found = false;
//        for (WebElement element : elements) {
//            String elementText = element.getText();
//            found = elementText.equals(expected);
//            if (found) {
//                break;
//            }
//        }

        //        Assertions.assertTrue(found);


        boolean firstNameWithError = elements.stream()
                .anyMatch(webElement -> webElement.getText().equals(expected));

        Assertions.assertTrue(firstNameWithError);

        webDriver.quit();
    }


    @Test
    void naoDeveCadastrarUsuarioQueJaExiste() {

        // Se existir, você sempre deve utilizar o ID.

        String username = "matheus-" + UUID.randomUUID();

        preencherFormDeCadastro(username);

        WebElement button = webDriver.findElement(By.tagName("button"));

        button.click();

        WebElement linkBackToLogin = webDriver.findElement(By.linkText("Back to login"));

        Assertions.assertTrue(linkBackToLogin.isDisplayed());

        preencherFormDeCadastro(username);

        button = webDriver.findElement(By.tagName("button"));

        button.click();

        // a mensagem de sucesso n]ao deve aparecer
        Assertions.assertThrows(org.openqa.selenium.NoSuchElementException.class, () -> {
            webDriver.findElement(By.cssSelector(".text-white.text-lg"));
        });

        webDriver.quit();
    }

    void preencherFormDeCadastro(String username) {
        webDriver.get(Constants.BASE_URL + "/register");

        WebElement firstName = webDriver.findElement(By.id("firstName"));
        firstName.sendKeys("Matheus");

        WebElement lastName = webDriver.findElement(By.id("lastName"));
        lastName.sendKeys("Cruz");

        WebElement email = webDriver.findElement(By.id("email"));
        email.sendKeys("matheus1@email.com");

        WebElement usernameElement = webDriver.findElement(By.id("username"));
        usernameElement.sendKeys(username);

        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("1234561@123");

    }


}

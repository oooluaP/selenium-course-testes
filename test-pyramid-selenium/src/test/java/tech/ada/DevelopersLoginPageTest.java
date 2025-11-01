package tech.ada;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DevelopersLoginPageTest {

    static WebDriver webDriver;

    public DevelopersLoginPageTest() {
        webDriver = new ChromeDriver();
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Executa antes de todos os testes");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Executa antes de cada teste");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Executa depois de cada teste");
    }

    @AfterAll
    static void afterAll() {
        webDriver.quit();
    }

    @Test
    void testaTituloDevelopers() {

        webDriver.get(Constants.BASE_URL);

        String title = webDriver.getTitle();

        Assertions.assertEquals("Developers - Selenium Labs", title);
    }

    @Test
    void deveMostrarOLinkDeCadastro() {

        webDriver.get(Constants.BASE_URL);

        WebElement element = webDriver.findElement(By.linkText("Register here"));

        boolean displayed = element.isDisplayed();

        Assertions.assertTrue(displayed);
    }

    @Test
    void quandoClicarNoLinkDeCadastroDeveSerRedirecionadoParaAPaginaDeCadastro() {

        webDriver.get(Constants.BASE_URL);

        WebElement element = webDriver.findElement(By.linkText("Register here"));

        element.click();

        String title = webDriver.getTitle();

        String currentUrl = webDriver.getCurrentUrl();

        Assertions.assertEquals("Developers - Register", title);

        Assertions.assertEquals(Constants.BASE_URL + "/register", currentUrl);
    }

    
}

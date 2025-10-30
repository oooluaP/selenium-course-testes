package tech.ada;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CreateDeveloperPageTest {

    static WebDriver webDriver = new ChromeDriver();

    @AfterAll
    static void depoisDeTodos() {
        webDriver.quit();
    }

    @AfterEach
    void vaParaPaginaPrincipal() {
        webDriver.get(Constants.BASE_URL);
    }

    void realizarLoginComoAdmin() {
        webDriver.get(Constants.BASE_URL + "/login");

        WebElement usernameLogin = webDriver.findElement(By.id("username"));
        usernameLogin.sendKeys("admin");

        WebElement passwordLogin = webDriver.findElement(By.id("password"));
        passwordLogin.sendKeys("123456");

        WebElement buttonLogin = webDriver.findElement(By.tagName("button"));
        buttonLogin.click();
    }

    @Test
    void deveRealizarOLogoutCorretamente() {
        realizarLoginComoAdmin();

        WebElement linkLogout = webDriver.findElement(By.linkText("Logout"));
        linkLogout.click();

        Alert alert = webDriver.switchTo().alert();
        String textoDoAlerta = alert.getText();
        System.out.println("O texto do alerta é: " + textoDoAlerta);
        alert.accept();
    }


    @Test
    void naoDeveRealizarOLogoutQuandoOUsuarioClicarEmCancel() {
        realizarLoginComoAdmin();

        WebElement linkLogout = webDriver.findElement(By.linkText("Logout"));
        linkLogout.click();

        Alert alert = webDriver.switchTo().alert();
        alert.dismiss();

    }

    @Test
    void deveCadastrarUmDesenvolvedor() {

        realizarLoginComoAdmin();

        webDriver.get(Constants.BASE_URL + "/create-developer");

        WebElement username = webDriver.findElement(By.id("username"));
        username.sendKeys("marcos.suda");

        WebElement email = webDriver.findElement(By.id("email"));
        email.sendKeys("marcos.suda@email.com");

        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("marcos.123");

        WebElement bio = webDriver.findElement(By.id("bio"));
        bio.sendKeys("Sou um tester/programador que ama Java e Javascript " +
                "e GoLang e outras coisas e CSS e Javascript... e comprei um bolo na loja do " +
                "Bruno e também um pé de moleque e dei pro Edilson!");

        // Seleciona primeiro o G
        WebElement tShirt = webDriver.findElement(By.id("tShirt"));
        Select selectTShirt = new Select(tShirt);

        // <select id="tShirt" name="tShirt" class="w-full">
        //                <option disabled="" value="">Select a T-SHIRT</option> 0
        //                <option id="PP" value="PP">PP</option> 1
        //                <option id="P" value="P">P</option> 2
        //                <option id="M" value="M">M</option> 3
        //                <option id="G" value="G">G</option> 4
        //                <option id="GG" value="GG">GG</option> 5
        //                <option id="XG" value="XG">XG</option> 6
        //            </select>
        selectTShirt.selectByIndex(4); // Estou selecionando o índice 4, ou seja G.
        // Começa sempre no 0
//        Thread.sleep(2000);

        // Seleciona o GG
        // Seleciona pelo valor do atributo html value
//        <option id="GG" ----> value="GG">GG</option>
        selectTShirt.selectByValue("GG");

        // dorme 5 segundos
//        Thread.sleep(5000);

        // Seleciona o XG
        // Seleciona pelo texto visível
        selectTShirt.selectByVisibleText("XG");

        System.out.println("Todas as opções do select: ");
        for (WebElement option : selectTShirt.getOptions()) {
            System.out.println(option.getText());
            // aqui eu posso verificar se todas as opções estão presentes
            // o requisito pode falar: Tem que ter os tamanhos...
        }

        WebElement backend = webDriver.findElement(By.id("backend"));
        backend.click();

        WebElement other = webDriver.findElement(By.id("other"));
        other.click();

        WebElement radioJava = webDriver.findElement(By.id("preferred_language_java"));
        radioJava.click();

        WebElement addDeveloperButton = webDriver.findElement(By.id("submit-button"));
        addDeveloperButton.click();


        webDriver.get(Constants.BASE_URL + "/list-developers");
        // 1. Clicaria em listar developers
//By.cssSelector(".px-6.py-3") critério de busca
        List<WebElement> elements = webDriver.findElements(By.cssSelector(".px-6.py-3"));

        boolean encontrou = false;
        for (WebElement element : elements) {
            String text = element.getText();
            encontrou = text.equals("marcos.suda");
            if (encontrou) {
                break;
            }
        }

        Assertions.assertTrue(encontrou);
    }

    @Test
    void deveCadastrarUmProblemaCorretamente() throws InterruptedException {
        realizarLoginComoAdmin();
//        Thread.sleep(2000); // em homenagem ao Edi <3
        WebElement linkSupport = webDriver.findElement(By.linkText("Support"));
        linkSupport.click();

        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("Acabou o bolo na fábrica do Bruno!");
        alert.accept();

        // esperar até esse alerta aparecer, para que a gente não tenha NoAlertPresentException
        WebDriverWait webDriverQueSabeEsperar = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        Alert ticketCriado = webDriverQueSabeEsperar.until(ExpectedConditions.alertIsPresent());

        ticketCriado.accept();
    }

//    @Test
//    void quandoClicarNoBotaoStartDeveAparecerOTextoHelloWorld() {
//        webDriver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//
//        WebElement startButton = webDriver.findElement(By.tagName("button"));
//
//        startButton.click();
//
//        Wait<WebDriver> webDriverQueEspera = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));
//
//        WebElement helloWorld = webDriverQueEspera.until(ExpectedConditions.visibilityOf(element));
//        Assertions.assertEquals("Hello World!", helloWorld.getText());
//    }

    @Test
    void quandoClicarEmCriarAplicacaoDeveAparecerUmaMensagemNoAlerta() {
        realizarLoginComoAdmin();

        webDriver.findElement(By.id("create-application")).click();

        Alert alert = webDriver.switchTo().alert();

        String text = alert.getText();

        Assertions.assertEquals("New feature in development. Please wait until next week!", text);

        alert.accept();

    }
}

package tech.ada;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateDeveloperPageTest {

    WebDriver webDriver = new ChromeDriver();

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
    void deveCadastrarUmDesenvolvedor() throws InterruptedException {

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
        Thread.sleep(2000);

        // Seleciona o GG
        // Seleciona pelo valor do atributo html value
//        <option id="GG" ----> value="GG">GG</option>
        selectTShirt.selectByValue("GG");

        // dorme 5 segundos
        Thread.sleep(5000);

        // Seleciona o XG
        // Seleciona pelo texto visível
        selectTShirt.selectByVisibleText("XG");

        System.out.println("Todas as opções do select: ");
        for (WebElement option : selectTShirt.getOptions()) {
            System.out.println(option.getText());
            // aqui eu posso verificar se todas as opções estão presentes
            // o requisito pode falar: Tem que ter os tamanhos...
        }


    }


}

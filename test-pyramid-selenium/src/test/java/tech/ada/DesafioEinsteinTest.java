package tech.ada;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DesafioEinsteinTest {

    WebDriver webDriver = new ChromeDriver();

    @Test
    void desafio() {
        ChromeOptions chromeOptions = new ChromeOptions();
        webDriver.get("https://rachacuca.com.br/logica/problemas/teste-de-einstein/");
    }

}

package tech.ada;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DevelopersLoginPageTestPaulinho {

    //WebDriver que será usado em todos os testes
    static WebDriver wdNavegador;

    //construtor da classe de teste, instancia o webdriver
    public DevelopersLoginPageTestPaulinho() {
        wdNavegador = new ChromeDriver();
    }

    //Requisito 001 - O titulo deve ser Developers - Selenium Labs
    @Test
    void verificaSeAoEntrarNaAplicacaoOTituloCumpreRequisito() {
        String requisito = "Developers - Selenium Labs";
        wdNavegador.get(Constants.BASE_URL);
        String strTituloDaPagina = wdNavegador.getTitle();

        Assertions.assertEquals(requisito, strTituloDaPagina);

    }

    //Requisito 002 - Ao entrar na página de login da aplicação /login, o
    // usuário deve visualizar um link para cadastro contendo o
    // texto Register here.
    @Test
    void verificaSeAoEntrarNaAplicacaoOUsuarioVisualizaUmLInkParaCadastro() {
        wdNavegador.get(Constants.BASE_URL + "/login");
        String textodolinkparacadastro = "Register here";
        WebElement nododocumentohtml = wdNavegador.findElement(By.linkText(textodolinkparacadastro));
        boolean estaVisivel = nododocumentohtml.isDisplayed();

        Assertions.assertTrue(estaVisivel);

    }

    // Req 003 - Ao entrar na página de login da aplicacao /login, quando o usuario
    // clicar no link Register here ele deve ser redirecionado para a página de cadastro.
    @Test
    void UsuarioDeveSerRedirecionadoAPaginaDeCadastroAoClicarEmRegisterHere() {
        String textoDoBotaoRegisterHere = "Register here";
        String tituloDaPaginaDeCadastro = "Developers - Register";

        wdNavegador.get(Constants.BASE_URL + "/login");
        WebElement nodocumentohtml = wdNavegador.findElement(By.linkText(textoDoBotaoRegisterHere));
        nodocumentohtml.click();
        String titulo = wdNavegador.getTitle();
        String enderecoAtual = wdNavegador.getCurrentUrl();

        Assertions.assertEquals(tituloDaPaginaDeCadastro, titulo);
    }


    @AfterAll
    static void fechaTudo() {
        wdNavegador.quit();
    }


}

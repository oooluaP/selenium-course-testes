package tech.ada;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.UUID;

public class DevelopersRegisterPageTestPaulinho {

    static WebDriver wdNavegador;

    public DevelopersRegisterPageTestPaulinho() {
        wdNavegador = new ChromeDriver();
    }

    //REQ004 (Deve cadastrar um usuário com sucesso)
    //Ao entrar na página de cadastro o usuário pode preencher o formulário de cadastro,
    // quando o usuário preencher todos os campos corretamente (Ver REQ005), deve aparecer
    // uma mensagem na tela com o texto Registered with success! e um link para voltar para
    // a página de login com o texto Back to login.

    @Test
    void DeveCadastrarUmUsuarioComSucesso() {
        //abre a página
        wdNavegador.get(Constants.BASE_URL + "/register");

        //preenche os campos
        WebElement firstName = wdNavegador.findElement(By.id("firstName"));
        firstName.sendKeys("Paulin");
        WebElement lastName = wdNavegador.findElement(By.id("lastName"));
        lastName.sendKeys("Silva");
        WebElement email = wdNavegador.findElement(By.id("email"));
        email.sendKeys("paulin@silva.com");
        WebElement username = wdNavegador.findElement(By.id("username"));
        username.sendKeys("Paulin666" + UUID.randomUUID());
        WebElement password = wdNavegador.findElement(By.id("password"));
        password.sendKeys("negamaluk123");

        //clica em add developer
        WebElement button = wdNavegador.findElement(By.tagName("button"));
        button.click();

        //procura pelo elemento da mensagem
        WebElement message = wdNavegador.findElement(By.cssSelector(".text-white.text-lg"));

        //checa se a mensagem é a esperada
        Assertions.assertEquals("Registered with success!", message.getText());

        //procura pelo elemento back to login
        WebElement linkBackToLogin = wdNavegador.findElement(By.linkText("Back to login"));

        //checa se o elemento back to link esta sendo mostrado
        Assertions.assertTrue(linkBackToLogin.isDisplayed());
    }



    //REQ005 (Deve validar o formulário de cadastro)
    //Ao entrar na página de cadastro o usuário pode preencher o
    // formulário de cadastro, o formulário de cadastro do usuário contém algumas regras:
    //O campo First name deve ter no mínimo 2 caracteres.
    //O campo Last name deve ter no mínimo 2 caracteres.
    //O campo Email deve ser um endereço de e-mail válido.
    //O campo Username deve ter no mínimo 2 caracteres.
    //O campo Password deve ter no mínimo 8 caracteres e não pode ficar em branco.
    //Ao submeter o formulário de cadastro com dados inválidos, o usuário deve visualizar
    // mensagens de erro correspondentes a cada campo inválido.
    @Test
    void deveAparecerMensagemDeErroQuandoFirstNameForInvalid() {
        //acessa a pagina de login, preenche username com P e clica em register
        wdNavegador.get("http://localhost:8080/login");
        wdNavegador.findElement(By.cssSelector(".text-blue-300")).click();
        wdNavegador.findElement(By.id("firstName")).click();
        wdNavegador.findElement(By.id("firstName")).sendKeys("P");
        wdNavegador.findElement(By.id("register")).click();
        wdNavegador.findElement(By.cssSelector(".shadow-gray-700")).click();

        // buscar elementos que tenha o atributo class contendo text-rose-500, text-sm, w-full
        List<WebElement> elements = wdNavegador.findElements(By.cssSelector(".text-rose-500.text-sm.w-full"));

        boolean encontrou = verificaSeOElementoTemOTexto(elements, "First name must be at least 2 characters long");
        Assertions.assertTrue(encontrou);
    }

    private static boolean verificaSeOElementoTemOTexto(List<WebElement> elements, String textoEsperado) {
        for (WebElement element : elements) {
            String textoDoElemento = element.getText();
            if (textoDoElemento.equals(textoEsperado)) {
                // encontrou o elemento com o texto esperado
                return true;
            }
        }
        return false;
    }





    @AfterAll
    static void fechaTudo () {
        wdNavegador.quit();
    }
}

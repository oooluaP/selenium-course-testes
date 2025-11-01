package tech.ada;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    //valida o first name
    @Test
    void deveAparecerMensagemDeErroQuandoFirstNameForInvalido() {
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

    //validaOLastName
    @Test
    void deveAparecerMensagemDeErroQuandoLastNameForInvalido() {
        //acessa a pagina de login
        wdNavegador.get("http://localhost:8080/login");
        //clica em RegisterHere
        wdNavegador.findElement(By.cssSelector(".text-blue-300")).click();
        //Preenche o primeiro nome certo e o last name errado
        wdNavegador.findElement(By.id("firstName")).sendKeys("Felipe");
        WebElement lastName = wdNavegador.findElement(By.id("lastName"));
        lastName.sendKeys("D");
        //Clica em registrar
        wdNavegador.findElement(By.id("register")).click();
        // buscar elementos que tenha o atributo class contendo text-rose-500, text-sm, w-full pq a msg de erro é desse tipo
        List<WebElement> elements = wdNavegador.findElements(By.cssSelector(".text-rose-500.text-sm.w-full"));
        //confirma se nesse array de elementos tem a mensagem de erro pra quando o lastname ta incorreto
        boolean encontrou = verificaSeOElementoTemOTexto(elements, "Last name must be at least 2 characters long");

        Assertions.assertTrue(encontrou);
    }

    //valida o email
    @Test
    void deveAparecerMensagemDeErroQuandoOEmailForInvalido() {

        wdNavegador.get("http://localhost:8080/login");
        wdNavegador.findElement(By.cssSelector(".text-blue-300")).click();
        wdNavegador.findElement(By.id("email")).sendKeys("paulin.serrinha");
        wdNavegador.findElement(By.id("register")).click();
        wdNavegador.findElement(By.cssSelector(".shadow-gray-700")).click();

        // buscar elementos que tenha o atributo class contendo text-rose-500, text-sm, w-full
        List<WebElement> elements = wdNavegador.findElements(By.cssSelector(".text-rose-500.text-sm.w-full"));

        boolean encontrou = verificaSeOElementoTemOTexto(elements, "Email should be valid");

        Assertions.assertTrue(encontrou);
    }


    //Valida o username
    @Test
    void deveAparecerMensagemDeErroQuandoUsernameForInvalido() {

        wdNavegador.get("http://localhost:8080/login");
        wdNavegador.findElement(By.cssSelector(".text-blue-300")).click();
        wdNavegador.findElement(By.id("username")).sendKeys("j");
        wdNavegador.findElement(By.id("register")).click();
        wdNavegador.findElement(By.cssSelector(".shadow-gray-700")).click();

        // buscar elementos que tenha o atributo class contendo text-rose-500, text-sm, w-full
        List<WebElement> elements = wdNavegador.findElements(By.cssSelector(".text-rose-500.text-sm.w-full"));

        boolean encontrou = verificaSeOElementoTemOTexto(elements, "Username must be at least 2 characters long");

        Assertions.assertTrue(encontrou);
    }

    @Test
    //validaOPassword
    void deveAparecerMensagemDeErroQuandoOPasswordForInvalido() {

        wdNavegador.get("http://localhost:8080/login");
        wdNavegador.findElement(By.cssSelector(".text-blue-300")).click();
        wdNavegador.findElement(By.id("register")).click();
        wdNavegador.findElement(By.cssSelector(".shadow-gray-700")).click();

        // buscar elementos que tenha o atributo class contendo text-rose-500, text-sm, w-full
        List<WebElement> elements = wdNavegador.findElements(By.cssSelector(".text-rose-500.text-sm.w-full"));

        // flaky test
        boolean encontrou = verificaSeCadaTextoContemNoTextoDeUmElemento(elements,
                "Password must be at least 6 characters long", "must not be blank");

        Assertions.assertTrue(encontrou);
    }

    //REQ006 (Cadastro de um usuário que já existe)
    //Ao cadastrar um usuário no sistema que já existe, não deve redirecionar para a
    // página de cadastrado com sucesso, deve aparecer uma mensagem That username is taken.
    // Try another..

    @Test
    void naoDeveCadastrarUsuarioQueJaExiste() {

        // Se existir, você sempre deve utilizar o ID.
        String username = "sarinha-" + UUID.randomUUID();
        preencherFormDeCadastro(username);

        WebElement button = wdNavegador.findElement(By.tagName("button"));
        button.click();
        WebElement linkBackToLogin = wdNavegador.findElement(By.linkText("Back to login"));
        Assertions.assertTrue(linkBackToLogin.isDisplayed());
        preencherFormDeCadastro(username);
        button = wdNavegador.findElement(By.tagName("button"));
        button.click();
        // a mensagem de sucesso não deve aparecer
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            wdNavegador.findElement(By.cssSelector(".text-white.text-lg"));
        });
        wdNavegador.quit();
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

    private static boolean verificaSeCadaTextoContemNoTextoDeUmElemento(List<WebElement> elements, String... textosQueDevemEstarContidos) {
        for (WebElement element : elements) {
            int length = textosQueDevemEstarContidos.length;
            int i = 0;
            String textoDoElemento = element.getText();
            for (String textoQueDeveEstarContido : textosQueDevemEstarContidos) {
                boolean contains = textoDoElemento.contains(textoQueDeveEstarContido);
                if (contains) {
                    i++;
                } else {
                    break;
                }
            }
            if (length == i) {
                return true;
            }
        }
        return false;
    }

    void preencherFormDeCadastro(String username) {
        wdNavegador.get(Constants.BASE_URL + "/register");

        WebElement firstName = wdNavegador.findElement(By.id("firstName"));
        firstName.sendKeys("Sarah");

        WebElement lastName = wdNavegador.findElement(By.id("lastName"));
        lastName.sendKeys("Daniela");

        WebElement email = wdNavegador.findElement(By.id("email"));
        email.sendKeys("saropita@email.com");

        WebElement usernameElement = wdNavegador.findElement(By.id("username"));
        usernameElement.sendKeys(username);

        WebElement password = wdNavegador.findElement(By.id("password"));
        password.sendKeys("batatinha@123");

    }





    @AfterAll
    static void fechaTudo () {
        wdNavegador.quit();
    }
}

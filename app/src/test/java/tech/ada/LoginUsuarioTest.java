package tech.ada;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginUsuarioTest {


    @Test
    void deveRetornarTrueQuandoUsuarioESenhaForemValidos() {
        // dado
        LoginUsuario loginUsuario = new LoginUsuario();

        // quando
        boolean deuCerto = loginUsuario.realizarLogin("suda", "123456");

        // entao
        Assertions.assertTrue(deuCerto);
    }

    @Test
    void deveRetornarFalseQuandoUsuarioESenhaForeInvalidos() {
        // dado
        LoginUsuario loginUsuario = new LoginUsuario();

        // quando
        boolean deuCerto = loginUsuario.realizarLogin("matheus", "123456");

        // entao
        Assertions.assertFalse(deuCerto);
    }

    // E se...
    @Test
    void deveRetornarFalseQuandoUsuarioForNullESenhaValida() {
        // dado
        LoginUsuario loginUsuario = new LoginUsuario();

        // quando
        boolean deuCerto = loginUsuario.realizarLogin("                  ", "123456");

        // entao
        Assertions.assertFalse(deuCerto);
    }
}
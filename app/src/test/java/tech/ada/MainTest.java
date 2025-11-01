package tech.ada;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testeSoma() {
        // dado
        int x = 10;
        int y = 12;

        // quando
        int resultado = Main.soma(x, y);

        // entao
//        assert resultado == 22 : "Teste falhou: esperado 22, obtido " + resultado;
    }

    @Test
    void testeSubtrai() {
        int resultado = Main.subtrai(10, 4);
        assert resultado == 6 : "Teste falhou: esperado 6, obtido " + resultado;
    }

    @Test
    void testeMultiplica() {
        int resultado = Main.multiplica(3, 4);
        assert resultado == 12 : "Teste falhou: esperado 12, obtido " + resultado;
    }

    @Test
    void testeDivide() {
        // dado
        int x = 10;
        int y = 2;

        // quando
        int resultado = Main.divide(x, y);

        // entao
        Assertions.assertEquals(5, resultado);
    }

    @Test
    void testeDividePorZero() {
        // dado
        int x = 10;
        int y = 0;

        // quando
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int resultado = Main.divide(x, y);
        });
    }
}

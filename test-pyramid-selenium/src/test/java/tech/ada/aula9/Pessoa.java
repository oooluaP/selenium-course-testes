package tech.ada.aula9;

import java.math.BigDecimal;

public class Pessoa {

    // estado
    // atributo da classe Pessoa
    String nome;

    // comportamento
    // método da objeto
    public BigDecimal trabalhar() {

        return BigDecimal.TEN.multiply(BigDecimal.valueOf(1000));
    }
}

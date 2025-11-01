package tech.ada;

import org.junit.jupiter.api.Test;

import javax.print.Doc;

import static org.junit.jupiter.api.Assertions.*;

class FabricaDeDocesDoBrunoTest {


    @Test
    void simples() {

        Doce doceDeLaranja = new Doce("Doce de Laranja");
        Doce doceDeCocada = new Doce("Doce de Cocada");
        Doce peDeMoleque = new Doce("Pé de Moleque");

        System.out.println(doceDeCocada.getSabor());
        System.out.println(doceDeCocada.getNomeNoAdesivo());
        System.out.println(doceDeLaranja.getSabor());
        System.out.println(doceDeLaranja.getNomeNoAdesivo());
        System.out.println(peDeMoleque.getSabor());
        System.out.println(peDeMoleque.getNomeNoAdesivo());

    }
}
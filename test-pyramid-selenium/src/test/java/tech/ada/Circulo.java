package tech.ada;

public class Circulo {

    public static double PI = 3.14159265358979323846;

    public double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double calcularArea() {
        return PI * raio * raio;
    }
}

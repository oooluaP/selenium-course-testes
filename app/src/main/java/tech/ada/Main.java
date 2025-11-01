package tech.ada;

public class Main {

    public static void main(String[] args) {
        int soma = soma(10, 22);
        System.out.println("Soma é: " + soma);
    }

    /**
     * Soma dois inteiros.
     * @param x inteiro
     * @param y inteiro
     * @return inteiro que é a soma de x e y
     */
    public static int soma(int x, int y) {
        return x + y;
    }

    public static int subtrai(int x, int y) {
        return x - y;
    }

    public static int multiplica(int x, int y) {
        return x * y;
    }

    public static int divide(int x, int y) {
        return x / y;
    }


}

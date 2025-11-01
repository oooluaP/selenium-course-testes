package tech.ada;

public class MainCirculo {


        public static void main(String[] args) {
            Circulo circulo1 = new Circulo(1);
            Circulo circulo2 = new Circulo(10);

            System.out.println(circulo1.calcularArea());
            System.out.println(circulo2.calcularArea());

            System.out.println(Circulo.PI);
//            System.out.println(Circulo.raio);

            System.out.println(circulo1.PI);
            System.out.println(circulo1.raio);

        }

}

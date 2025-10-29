package tech.ada;

public class Doce {

    String sabor;

    public Doce(String sabor) {
        this.sabor = sabor;
    }

    public String getSabor() {
        return sabor;
    }

    public String getNomeNoAdesivo() {
        return FabricaDeDocesDoBruno.NOME_DA_FABRICA;
    }
}

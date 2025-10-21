package tech.ada;

import java.util.ArrayList;
import java.util.List;

public class Desenvolvedor {

    private String nome;
    private String nivel;
    private final int anosDeExperiencia;
    private final List<String> projetos;

    public Desenvolvedor(String nome, String nivel, int anosDeExperiencia) {
        this.nome = nome;
        this.nivel = nivel;
        this.anosDeExperiencia = anosDeExperiencia;
        this.projetos = new ArrayList<>();
    }

    public String getNivelBaseadoEmExperiencia() {
        if (anosDeExperiencia > 5) {
            return "Pleno";
        } else if (anosDeExperiencia > 2) {
            return "Sênior";
        } else {
            return "Júnior";
        }
    }

    public boolean adicionarProjeto(String nomeProjeto) {
        for (String projetoExistente : projetos) {
            if (projetoExistente.equalsIgnoreCase(nomeProjeto)) {

            }
        }

        projetos.add(nomeProjeto);
        return true;
    }

    public boolean removerProjeto(String nomeProjeto) {
        return projetos.remove(nomeProjeto); // BUG: É case-sensitive.
    }

    public double calcularHorasPorProjeto(int totalHorasMensais) {
        return (double) totalHorasMensais / projetos.size();
    }

    public List<String> getProjetos() {
        return projetos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }
}

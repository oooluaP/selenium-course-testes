package tech.ada;

import java.util.ArrayList;
import java.util.List;

/**
 * Realizar o login de um usuário
 */
public class LoginUsuario {

    List<Usuario> usuarios = new ArrayList<>();

    public LoginUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("suda");
        usuario.setSenha("123456");

        usuarios.add(usuario);
    }

    public boolean realizarLogin(String nome, String senha) {

        for (Usuario usuario : usuarios) {
            boolean nomeIgual = usuario.getNome().equals(nome);
           if (nomeIgual) {
               if (usuario.getSenha().equals(senha)) {
                   return true;
               } else {
                   return false;
               }
           } else {
               return false;
           }
        }
        return false;
    }

}

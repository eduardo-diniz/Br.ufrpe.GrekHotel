/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio;

import br.ufrpe.GrekHotel.Dados.RepUsuarios;
import br.ufrpe.GrekHotel.beans.Usuario;

/**
 *
 * @author fight
 */
public class ControladorUsuario {
    private RepUsuarios usuarios;
    private static ControladorUsuario instance;

    private ControladorUsuario() {
        this.usuarios = RepUsuarios.getInstance();
    }
    
    public static ControladorUsuario getInstance(){
        if(instance == null){
            instance = new ControladorUsuario();
        }
        return instance;
    }
    
    public boolean cadastrarUsuario(Usuario u){
        return usuarios.cadastrar(u);
    }
    
    public Usuario efetuarLogin(String login, String senha){
        return usuarios.procurar(login, senha);
    }
    
    public boolean removerUsuario(Usuario u){
        return usuarios.remover(u);
    }
    
}

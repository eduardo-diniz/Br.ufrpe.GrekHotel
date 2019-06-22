/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Dados;

import br.ufrpe.GrekHotel.Excecoes.*;
import br.ufrpe.GrekHotel.Negocio.beans.Funcionario;
import br.ufrpe.GrekHotel.Negocio.beans.Usuario;
import java.util.ArrayList;

/**
 *
 * @author fight
 */
public class RepUsuarios {
    private ArrayList<Usuario> usuarios;
    private static RepUsuarios instance;
    
    
    private RepUsuarios(){
        usuarios = new ArrayList();
        usuarios.add(new Funcionario("admin", "admin"));
    }
    public static RepUsuarios getInstance(){
        if(instance == null){
            instance = new RepUsuarios();
        }
        return instance;
    }
    public boolean cadastrar(Usuario u) throws AUException{
        boolean resultado = false;
        if(!usuarios.contains(u)){
            usuarios.add(u);
            resultado = true;
        }else{
            AUException aue = new AUException();
            throw aue;
        }
        return resultado;
    }
    public Usuario procurar(String login, String senha){
        Usuario encontrado = null;
        for(Usuario u : usuarios){
            if(u.getLogin().equals(login) && u.getSenha().equals(senha)){
                encontrado = u;
            }
        }
        return encontrado;
    }
    public boolean remover(Usuario u)throws RUException{
        boolean resultado = false;
        if(usuarios.contains(u)){
            usuarios.remove(u);
            resultado = true;
        }else{
            RUException rue = new RUException();
            throw rue;
        }
        return resultado;
    }
}

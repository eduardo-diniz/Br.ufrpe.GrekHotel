/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio.beans;

import java.io.Serializable;

/**
 *
 * @author fight
 */
public abstract class Usuario implements Serializable{
   private String login;
   private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
   
   

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    
    public boolean equals(Object obj){
        boolean resultado = false;
        
        if(obj instanceof Usuario){
            Usuario u = (Usuario) obj;
            if (u.getLogin().equals(this.getLogin())){
                resultado = true;
            }
        }
        return resultado;
    }
    
}

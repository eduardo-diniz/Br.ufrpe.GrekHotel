/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio.beans;

/**
 *
 * @author fight
 */
public class Funcionario extends Usuario {

    private String nome;

    public Funcionario(String login, String senha, String nome) {
        super(login, senha);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}

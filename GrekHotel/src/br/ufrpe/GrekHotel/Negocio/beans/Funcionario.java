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
    private int idade;
    private long cpf;

    public Funcionario(String login, String senha, String nome, int idade, long cpf) {
        super(login, senha);
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return nome;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio.beans;

import java.util.ArrayList;

/**
 *
 * @author fight
 */
public class Cliente extends Usuario {
    private String nome;
    private int idade;
    private long cpf;
    private Conta despesa;
    private ArrayList<Reserva> historico;
    private ArrayList<Visita> historicoVisita;
    
    public Cliente(String login, String senha, String nome, int idade, long cpf){
        super(login, senha);
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        historico = new ArrayList();
        historicoVisita = new ArrayList();
    }


    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public long getCpf() {
        return cpf;
    }

    public Conta getDespesa() {
        return despesa;
    }
    
    public void setDespesa(Conta despesa) {
        this.despesa = despesa;
    }
    
    public ArrayList<Reserva> getHistorico() {
        return historico;
    }

    public ArrayList<Visita> getHistoricoVisita() {
        return historicoVisita;
    }

    @Override
    public boolean equals(Object obj) {
        boolean resultado = false;
        if(obj instanceof Cliente){
            Cliente c = (Cliente) obj;
            if(this.cpf == c.getCpf()){
                resultado = true;
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}

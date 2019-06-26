/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio.beans;

/**
 *
 * @author Gabriel
 */
public enum Situacao{
    LIVRE("Livre"), OCUPADO("Ocupado"), RESERVADO("Reservado");
    
    public String valorSituacao;
    
    Situacao(String situacao){
        valorSituacao = situacao;
    }
    
    public String getValor(){
        return this.valorSituacao;
    }
    
    public String toString(){
        return this.valorSituacao;
    }
    
    
}

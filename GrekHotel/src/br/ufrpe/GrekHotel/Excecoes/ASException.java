/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Excecoes;

/**
 *
 * @author Gabriel
 */
public class ASException extends Exception{
    
    private String motivo;
    
    public ASException(){
        super("Erro ao adicionar serviço");
    }
    
    public String getMotivo(){
        return this.motivo;
    }
    
    public void setMotivo(String motivo){
        this.motivo = motivo;
    }
}

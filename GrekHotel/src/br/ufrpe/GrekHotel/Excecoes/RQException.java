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
public class RQException extends Exception{
    
    private String motivo;
    
    public RQException(){
        super("Erro ao remover quarto");
    }
    
    public String getMotivo(){
        return this.motivo;
    }
    
    public void setMotivo(String motivo){
        this.motivo = motivo;
    }
}

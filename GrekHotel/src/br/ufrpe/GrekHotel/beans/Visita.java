/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.beans;
import java.time.LocalDateTime;


public class Visita {
	
	private Quarto quarto;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	private Conta despesa;
	
	public Visita(Quarto quarto, LocalDateTime checkIn, Conta despesa){
		this.quarto = quarto;
		this.checkIn = checkIn;
		this.despesa = despesa;
		
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;

	}


	public Quarto getQuarto() {
		return this.quarto;
	}
	
	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}
	
	public LocalDateTime getCheckIn() {
		return this.checkIn;
	}
	
	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}
	
	public LocalDateTime getCheckOut() {
		return this.checkOut;
	}
	
	public void setConta(Conta conta) {
		this.despesa = conta;
		
	}
	
	public Conta getConta() {
		return this.despesa;
	}

	public boolean equals(Object obj){
	
            boolean resultado = false;

            if(obj instanceof Visita){
                    Visita a =(Visita) obj;

                    if(this.quarto.equals(a.getQuarto()) && this.checkIn.equals(a.getCheckIn()) && this.checkOut.equals(a.getCheckOut()) && this.despesa.equals(a.getConta())){
                            resultado = true;
                    }

            }
            return resultado;
        }
    
}
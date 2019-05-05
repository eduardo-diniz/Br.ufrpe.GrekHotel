/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.beans;
import java.time.LocalDate;
public class Reserva {
	
	private Quarto quarto;
	private Cliente hospede;
	private LocalDate checkInPrevisto;
	private LocalDate checkOutPrevisto;
    	private Visita visita;
    
    public Reserva(Quarto quarto, Cliente hospede, LocalDate checkInPrevisto, LocalDate checkOutPrevisto, Visita visita) {
    	this.quarto = quarto;
    	this.hospede = hospede;
    	this.checkInPrevisto = checkInPrevisto;
    	this.checkOutPrevisto = checkOutPrevisto;
    
    	    	
    }
    
    public void setQuarto() {
    	
    }
    
    public String getQuarto() {
    	return this.quarto;
    }
    
    public void setCliente(Cliente cliente) {
    	this.cliente = cliente;
    	
    }
    
    public String getCliente() {
    	return this.hospede;
    }
    
    public void setCheckIn(LocalDate checkIn) {
    	this.checkInPrevisto = checkIn;
    }
    
    public LocalDate getCheckIn() {
    	
    	return this.checkInPrevisto;
    }
    
    public void setCheckOut(LocalDate checkOut) {
    	this.checkOutPrevisto = checkOut;
    }
    
    public LocalDate getCheckOut() {
    	return this.checkOutPrevisto;
    }
    
    public void setVisita(Visita visita) {
    	this.visita = visita;
    	
    }
    
    public String getVisita() {
    	return this.visita;
    }
    public boolean equals(Object obj){
	
	boolean resultado = false;

	if(obj instanceof Reserva){
		Reserva a = (Reserva) obj;

		if(this.quarto.equals(obj.getQuarto()) && this.hospede.equals(obj.getHospede()) &&
		 this.checkInPrevisto.equals(obj.getCheckInPrevisto()) && this.checkOutPrevisto.equals
		 (obj.checkOutPrevisto) && this.visita.equals(obj.getVisita())){
			resultado = true;
		}
		return resultado;
	}

	    
    }
    public String toString() {
    	return "Quarto reservado: " + this.getQuarto() + "\nCliente: " + this.getCliente() +"\nHora prevista: " +
    			this.getCheckIn() + " - " + this.getCheckOut() + "\n Visitante: " + this.getVisita();
    }
}

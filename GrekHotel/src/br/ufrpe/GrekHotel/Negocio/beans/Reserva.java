/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio.beans;
import java.time.LocalDate;
public class Reserva {
	
	private Quarto quarto;
	private Cliente hospede;
	private LocalDate checkInPrevisto;
	private LocalDate checkOutPrevisto;
    	private Visita visita;
    
    public Reserva(Quarto quarto, Cliente hospede, LocalDate checkInPrevisto, LocalDate checkOutPrevisto) {
    	this.quarto = quarto;
    	this.hospede = hospede;
    	this.checkInPrevisto = checkInPrevisto;
    	this.checkOutPrevisto = checkOutPrevisto;
    
    	    	
    }
    
    public void setQuarto() {
    	
    }
    
    public Quarto getQuarto() {
    	return this.quarto;
    }
    
    public void setCliente(Cliente cliente) {
    	this.hospede = cliente;
    	
    }
    
    public Cliente getCliente() {
    	return this.hospede;
    }
    
    public void setCheckInPrevisto(LocalDate checkIn) {
    	this.checkInPrevisto = checkIn;
    }
    
    public LocalDate getCheckInPrevisto() {
    	
    	return this.checkInPrevisto;
    }
    
    public void setCheckOutPrevisto(LocalDate checkOut) {
    	this.checkOutPrevisto = checkOut;
    }
    
    public LocalDate getCheckOutPrevisto() {
    	return this.checkOutPrevisto;
    }
    
    public void setVisita(Visita visita) {
    	this.visita = visita;
    	
    }
    
    public Visita getVisita() {
    	return this.visita;
    }
    public boolean equals(Object obj){
	
	boolean resultado = false;

	if(obj instanceof Reserva){
		Reserva a = (Reserva) obj;

		if(this.quarto.equals(a.getQuarto()) && this.hospede.equals(a.getCliente()) &&
		 this.checkInPrevisto.equals(a.getCheckInPrevisto()) && this.checkOutPrevisto.equals
		 (a.getCheckOutPrevisto()) && this.visita.equals(a.getVisita())){
			resultado = true;
		}
		
	}
        return resultado;
	    
    }
    public String toString() {
    	return "Quarto reservado: " + this.getQuarto() + "\nCliente: " + this.getCliente() +"\nHora prevista: " +
    			this.getCheckInPrevisto() + " - " + this.getCheckOutPrevisto() + "\n Visitante: " + this.getVisita();
    }
}

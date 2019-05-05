/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio;
import java.time.LocalDate;

public class ControladorReservas {

private RepReserva reserva;
private static ControladorReservas instance;  

private  ControladorReservas(){
	this.reserva = RepReserva.getInstance();

}
public static ControladorReservas getInstance(){
	if (instance == null){
		instance = new ControladorReservas(); 
	}
	return instance;
}
public void Reservar(Reserva reserva){ 
	
	this.RepReserva.cadastrar(reserva);
}

public Reserva procurarReserva(Quarto quarto){
	 this.RepReserva.procurar(quarto);
}


public Reserva procurarReserva(Cliente cliente){
	 this.RepReserva.procurar(cliente);
}

public void atualizarReserva(Reserva desatualizado, Reserva atualizado){
	
	
}

public boolean cancelarReserva(Reserva reserva){
this.RepReserva.remove(reserva);
	
}
public void checkIn(Reserva reserva){
     reserva.getVisita().setCheckIn(LocalDateTime.now());

}

public void checkOut(Reserva reserva){
	reserva.getVisita().setCheckOut(LocalDateTime.now());
	
}

}

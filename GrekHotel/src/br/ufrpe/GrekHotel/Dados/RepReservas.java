/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Dados;

import br.ufrpe.GrekHotel.Negocio.beans.Reserva;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import java.util.ArrayList;
;

public class RepReservas {
        private ArrayList<Reserva> reservas;
        private static RepReservas instance;

        private RepReservas() {

            reservas = new ArrayList();
        }
	public static RepReservas getInstance(){
            if (instance == null){
                    instance = new RepReservas(); 

            }
            return instance;
        }
	
	public void cadastrar(Reserva reserv){
            if(reserv.getQuarto().getSituacao() == 1) {
		if(!this.reservas.contains(reserv)){
                    reserv.getQuarto().setSituacao(2);
                    reservas.add(reserv); 
                }
            }
        }
	

	public Reserva procurar(Quarto quarto){
            Reserva encontrado = null;
            for(Reserva i : reservas) {
                if (i.getQuarto().equals(quarto)){

                        encontrado = i;
                }

            }
            return encontrado;
	}

	public Reserva procurar(Cliente hospede){
            Reserva encontrado = null;
            for(Reserva j : reservas) {
                if (j.getCliente().equals(hospede)){

                        encontrado = j;
                }

            }
            return encontrado;
	}
	public void atualizar(Reserva desatualizado, Reserva Atualizado){


	} 
	public boolean remove(Reserva reserva){
            boolean resultado = false;

            if(this.reservas.contains(reserva)){ 

                   resultado = true;
                   reservas.remove(reserva);
                   reserva.getQuarto().setSituacao(1);
            }
            return resultado;

        }
}



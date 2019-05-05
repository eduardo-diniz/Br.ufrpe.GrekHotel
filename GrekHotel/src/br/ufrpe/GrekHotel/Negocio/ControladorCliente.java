/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio;


import br.ufrpe.GrekHotel.Dados.RepServicos;
import br.ufrpe.GrekHotel.beans.Cliente;
import br.ufrpe.GrekHotel.beans.Conta;
import br.ufrpe.GrekHotel.beans.Servico;
import br.ufrpe.GrekHotel.beans.Visita;

/**
 *
 * @author fight
 */
public class ControladorCliente {

	
	private static ControladorCliente instance;

	private ControladorCliente() {

		this.servico = RepServicos.getInstance();
		
	}
	
	public static ControladorCliente getInstance() {
		
		
		if (instance == null) {
			
			ControladorCliente.instance = new ControladorCliente();
			
		}
		return instance;
		
		
	}

	public void contratarServico(Cliente cliente, Servico servico) {
				
		
		this.cliente.getDespesa();
		
	}
	
	
	public Conta consultarDespesas (Cliente cliente) {
		
		this.cliente.getDespesa();
		
		return
		
		
	}

}

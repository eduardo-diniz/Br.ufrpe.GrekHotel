/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio;

import java.util.ArrayList;

import br.ufrpe.GrekHotel.Dados.RepQuartos;
import br.ufrpe.GrekHotel.Dados.RepServicos;
import br.ufrpe.GrekHotel.beans.*;
/**
 *
 * @author fight
 */
public class ControladorAdm  {

	private RepQuartos quarto;
	private RepServicos servico;
	private static ControladorAdm instance;

	private ControladorAdm() {

		this.quarto = RepQuartos.getInstance();
		this.servico = RepServicos.getInstance();

	}

	public static ControladorAdm getInstance() {
		if (instance == null) {
			ControladorAdm.instance = new ControladorAdm();
		}

		return instance;
	}
	
	public ArrayList lista(){
        return servico.lista();
    }

	public void cadastrarQuarto(Quarto quar) {

		this.quarto.cadastrar(quar);

	}

	public void cadastrarServico(Servico serv) {

		this.servico.cadastrar(serv);

	}

	public boolean removerQuarto(Quarto quartoRem) {

		return this.quarto.remover(quartoRem);

	}

	public boolean removerServico(Servico servRem) {

		return this.servico.remove(servRem);

	}
}
	//public void atualizarQuarto(Quarto desatualizado, Quarto atualizado) {

		// incompleto
		//this.quarto.atualizar(desatualizado, atualizado);

	//}

	//public void atualizarServico(Servico desatualizado, Servico atualizado) {
		// incompleto

		//this.servico.atualizar(desatualizado, atualizado);
	//}

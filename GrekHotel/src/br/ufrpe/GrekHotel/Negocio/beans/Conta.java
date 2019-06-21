/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio.beans;

/**
 *
 * @author fight
 */

import java.util.ArrayList;

public class Conta {
	private Quarto quartoNum;
	private ArrayList<Servico> compras;
	private double valorTotal;

	public Conta(Quarto quartoNum) {

		this.quartoNum = quartoNum;
		this.compras = new ArrayList<Servico>();
		this.valorTotal = quartoNum.getDiaria();

	}

	public void novaCompra(Servico compra) {

		compras.add(compra);
		this.valorTotal += compra.getCusto();

	}

	public ArrayList<Servico> getCompras() {
		return compras;
	}

	public Quarto getQuartoNum() {
		return quartoNum;
	}

	public double getValorTotal() {
		return valorTotal;
	}

}

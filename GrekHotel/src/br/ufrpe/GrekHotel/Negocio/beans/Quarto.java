/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio.beans;

import java.io.Serializable;

/**
 *
 * @author fight
 */
public class Quarto implements Serializable {

	private String descricao;
	private double diaria;
	private int numero;
	private int situacao;

	public Quarto(String descricao, double diaria, int numero) {

		this.descricao = descricao;
		this.diaria = diaria;
		this.numero = numero;
		this.situacao = 1;
		/*
		 * 1- Livre 2-Reservado 3- ocupado
		 */
	}

	@Override
	public String toString() {
		return descricao + ", diaria=" + diaria + ", numero=" + numero + "]";
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getDiaria() {
		return diaria;
	}

	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}

	public int getNumero() {
		return numero;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public boolean equals(Object obj) {

		boolean igual = false;

		if (obj instanceof Quarto) {
			Quarto q = (Quarto) obj;
			if (this.getNumero() == q.getNumero()) {

				igual = true;
			}

		}
		return igual;

	}

}

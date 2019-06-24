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

import java.io.Serializable;
import java.util.ArrayList;

public class Conta implements Serializable {
	private Quarto quartoNum;
	private ArrayList<Servico> compras;
	private double valorTotal;

	public Conta(Quarto quartoNum) {

		this.quartoNum = quartoNum;
		this.compras = new ArrayList<Servico>();
                novaCompra(new Servico("Hospedagem", quartoNum.getDiaria()));

	}

	public void novaCompra(Servico compra) {

		compras.add(compra);
		this.valorTotal += compra.getCusto();

	}
        public void atualizarHospedagem(int dias){
            for(Servico s : compras){
                if(s.getDescricao().equals("Hospedagem")){
                    s.setCusto(quartoNum.getDiaria() * dias);
                    atualizarCusto();
                }
            }
        }
        private void atualizarCusto(){
            int custo = 0;
            for(Servico s : compras){
                custo += s.getCusto();
            }
            valorTotal = custo;
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

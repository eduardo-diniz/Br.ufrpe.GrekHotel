/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Dados;

import br.ufrpe.GrekHotel.Excecoes.*;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import java.util.ArrayList;

/**
 *
 * @author fight
 */
public class RepQuartos {

	private ArrayList<Quarto> quartos;

	private static RepQuartos instance;

	private RepQuartos() {

		this.quartos = new ArrayList<Quarto>();

	}

	public static RepQuartos getInstance() {
		if (instance == null) {
			RepQuartos.instance = new RepQuartos();
		}

		return instance;
	}

	public void cadastrar(Quarto quar) throws AQException{
		if (!this.quartos.contains(quar)) {

			quartos.add(quar);
		} else {
                    AQException aqe = new AQException();
                    throw aqe;
		}
	}

	public Quarto procurar(int numero){
            Quarto q = null;
            for (Quarto qua : quartos) {
		if (qua.getNumero() == (numero)) {

			q = qua;

                    }
                }
            return q;
	}
        
        public ArrayList lista(){
            return quartos;
        }

	public void atualizar(Quarto desatualizado, Quarto Atualizado) {

	}

	public boolean remover(Quarto quartoRem) throws RQException{

		boolean removido = false;

		if (this.quartos.contains(quartoRem)) {

			removido = true;
			quartos.remove(quartoRem);
		} else {
			RQException rqe = new RQException();
                        throw rqe;
		}

		return removido;

	}

}

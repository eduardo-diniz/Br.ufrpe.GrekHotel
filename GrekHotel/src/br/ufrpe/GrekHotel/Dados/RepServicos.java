package br.ufrpe.GrekHotel.Dados;

import java.util.ArrayList;

import br.ufrpe.GrekHotel.beans.*;

public class RepServicos {
	 private ArrayList<Servico> quartos;
	 private static RepServicos instance;
	 
	 private RepServicos() {
		 
		 quartos = new ArrayList();
	 }
	 public static RepServicos getInstance(){
			if (instance == null){
				instance = new RepServicos(); 
				
			}
			return instance;
		}
	 
	 
	 public void cadastrar(Servico servico) {
		 if(!this.quartos.contains(servico)) {
			 quartos.add(servico);
			 
		 }	 
	 }
	 public Servico procurar(String descricao) {
		Servico resultado = null;
	           	for(Servico i : quartos) {
				if (i.getDescricao().equals(descricao)){
					
					resultado = i;
				}
			
	
	     
	           	}
				return resultado;
			 }
	 
	 public boolean remove(Servico servico){
			boolean resultado = false;
				 
				 if(this.quartos.contains(servico)){ 
					
					resultado = true;
					quartos.remove(servico);
			}
			return resultado;
				
			}
	     


}

package br.ufrpe.GrekHotel.beans;


public class Servico {
	private String descricao;
	private double custo;
	
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getCusto() {
		return custo;
	}
	
	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	public boolean equals(Object obj) {
		

		boolean resultado = false;

		if(obj instanceof Servico){
			Servico b =(Servico) obj;

			if(this.descricao.equals(b.getDescricao())){
				resultado = true;
			}
			
	}
		return resultado;
	}
	

}






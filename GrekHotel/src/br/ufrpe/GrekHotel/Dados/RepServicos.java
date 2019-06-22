package br.ufrpe.GrekHotel.Dados;

import br.ufrpe.GrekHotel.Excecoes.*;
import br.ufrpe.GrekHotel.Negocio.beans.Servico;
import java.util.ArrayList;


public class RepServicos {
	private ArrayList<Servico> quartos;
	private static RepServicos instance;

	private RepServicos()  {

		quartos = new ArrayList();
	}

	public static RepServicos getInstance() {
		if (instance == null) {
			instance = new RepServicos();

		}
		return instance;
	}

	public ArrayList lista() {
		return quartos;
	}

	public void cadastrar(Servico servico) throws ASException{
		if (!this.quartos.contains(servico)) {
			quartos.add(servico);

		}else{
                    ASException ase = new ASException();
                    ase.setMotivo("serviço já existe");
                    throw ase;
                }
	}

	public Servico procurar(String descricao) {
		Servico resultado = null;
		for (Servico i : quartos) {
			if (i.getDescricao().equals(descricao)) {

				resultado = i;
			}

		}
		return resultado;
	}

	public boolean remove(Servico servico) throws RSException {
		boolean resultado = false;

		if (this.quartos.contains(servico)) {

			resultado = true;
			quartos.remove(servico);
		} else{
                    RSException rse = new RSException();
                    rse.setMotivo("serviço não existe");
                    throw rse;
                }
		return resultado;

	}

}

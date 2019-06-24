package br.ufrpe.GrekHotel.Negocio;

import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import br.ufrpe.GrekHotel.Negocio.beans.Conta;
import br.ufrpe.GrekHotel.Negocio.beans.Servico;

public class ControladorCliente {

    private static ControladorCliente instance;

    private ControladorCliente() {

    }

    public static ControladorCliente getInstance() {

        if (instance == null) {

            ControladorCliente.instance = new ControladorCliente();

        }
        return instance;

    }

    public void contratarServico(Cliente cliente, Servico servico) {

        this.consultarDespesas(cliente).novaCompra(servico);
    }

    public Conta consultarDespesas(Cliente cliente) {

        return cliente.getDespesa();
    }

}

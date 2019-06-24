/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio;

import br.ufrpe.GrekHotel.Excecoes.*;
import br.ufrpe.GrekHotel.Negocio.beans.*;
import br.ufrpe.GrekHotel.Dados.RepQuartos;
import java.time.LocalDateTime;
import br.ufrpe.GrekHotel.Dados.RepReservas;
import java.util.ArrayList;

public class ControladorReservas {

    private RepQuartos quartos;
    private RepReservas reserva;
    private static ControladorReservas instance;

    private ControladorReservas() {
        this.reserva = RepReservas.getInstance();
        this.quartos = RepQuartos.getInstance();

    }

    public static ControladorReservas getInstance() {
        if (instance == null) {
            instance = new ControladorReservas();
        }
        return instance;
    }

    public void Reservar(Reserva reserva) throws CRException {
        this.reserva.cadastrar(reserva);
    }

    public Reserva procurarReserva(Quarto quarto) {
        return this.reserva.procurar(quarto);
    }

    public Reserva procurarReserva(Cliente cliente) {
        return this.reserva.procurar(cliente);
    }

    public ArrayList listarQuartos() {
        return quartos.lista();
    }

    public Quarto procurarQuarto(int numero) {
        return quartos.procurar(numero);
    }

    public void atualizarReserva(Reserva desatualizado, Reserva atualizado) throws ARException {
        reserva.atualizar(desatualizado, atualizado);

    }

    public void cancelarReserva(Reserva reserva) throws RRException {
        this.reserva.remove(reserva);

    }

    public void checkIn(Reserva reserva) {
        Conta despesa = new Conta(reserva.getQuarto());
        reserva.getCliente().setDespesa(despesa);
        reserva.setVisita(new Visita(reserva.getQuarto(), LocalDateTime.now(), despesa));

    }

    public void checkOut(Reserva reserva) {
        reserva.getVisita().setCheckOut(LocalDateTime.now());

    }

    public void salvar() {
        reserva.salvar();
    }
}

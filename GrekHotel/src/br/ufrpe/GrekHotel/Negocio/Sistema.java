/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.Negocio;

/**
 *
 * @author fight
 */
import br.ufrpe.GrekHotel.Excecoes.*;
import br.ufrpe.GrekHotel.Negocio.beans.*;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private Usuario usuario;
    private ControladorAdm ctrlAdm;
    private ControladorCliente ctrlCliente;
    private ControladorReservas ctrlReservas;
    private ControladorUsuario ctrlUsuario;
    private static Sistema instance;

    private Sistema() {

        this.ctrlAdm = ControladorAdm.getInstance();
        this.ctrlCliente = ControladorCliente.getInstance();
        this.ctrlReservas = ControladorReservas.getInstance();
        this.ctrlUsuario = ControladorUsuario.getInstance();
    }

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList listarQuartos() {
        return ctrlReservas.listarQuartos();
    }

    public ArrayList listarServicos() {
        return ctrlAdm.lista();
    }
    
    public List listarFun(){
        return ctrlUsuario.listarFunc();
    }
    
    public List listarReservas(){
        return ctrlReservas.listarReservas();
    }

    public void cadastrarQuarto(Quarto quar) throws CQException {
        this.ctrlAdm.cadastrarQuarto(quar);
    }

    public void cadastrarServico(Servico serv) throws CSException {

        this.ctrlAdm.cadastrarServico(serv);

    }

    public void removerQuarto(Quarto quartoRem) throws RQException {

        this.ctrlAdm.removerQuarto(quartoRem);

    }

    public void removerServico(Servico servRem) throws RSException {

        this.ctrlAdm.removerServico(servRem);

    }
    public void atualizarQuarto(Quarto desatualizado, Quarto atualizado) throws AQException{
        this.ctrlAdm.atualizarQuarto(desatualizado, atualizado);
    }
    
    public void atualizarServico(Servico desatualizado, Servico atualizado) throws ASException{
        this.ctrlAdm.atualizarServico(desatualizado, atualizado);
    }

    public void Reservar(Reserva reserva) throws CRException {

        this.ctrlReservas.Reservar(reserva);

    }

    public Reserva procurarReserva(Quarto quarto) {

        return this.ctrlReservas.procurarReserva(quarto);

    }

    public Reserva procurarReserva(Cliente cliente) {

        return this.ctrlReservas.procurarReserva(cliente);

    }

    public Quarto procurarQuarto(int numero) {
        return this.ctrlReservas.procurarQuarto(numero);
    }

    public void cancelarReserva(Reserva reserva) throws RRException {

        this.ctrlReservas.cancelarReserva(reserva);

    }

    public void checkIn(Reserva reserva) {

        ctrlReservas.checkIn(reserva);

    }

    public void checkOut(Reserva reserva) {

        ctrlReservas.checkOut(reserva);

    }

    public void cadastrarUsuario(Usuario u) throws CUException {

        ctrlUsuario.cadastrarUsuario(u);

    }

    public Usuario efetuarLogin(String login, String senha) {
        usuario = ctrlUsuario.efetuarLogin(login, senha);
        return usuario;

    }

    public void removerUsuario(Usuario u) throws RUException {

        ctrlUsuario.removerUsuario(u);

    }

    public void contratarServico(Cliente cliente, Servico servico) {

        this.ctrlCliente.contratarServico(cliente, servico);

    }

    public Conta consultarDespesas(Cliente cliente) {

        return this.ctrlCliente.consultarDespesas(cliente);

    }

    public void salvar() {
        ctrlAdm.salvar();
        ctrlReservas.salvar();
        ctrlUsuario.salvar();
    }
}

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
import br.ufrpe.GrekHotel.Excecoes.CQException;
import br.ufrpe.GrekHotel.Excecoes.CRException;
import br.ufrpe.GrekHotel.Excecoes.CSException;
import br.ufrpe.GrekHotel.Excecoes.CUException;
import br.ufrpe.GrekHotel.Excecoes.RQException;
import br.ufrpe.GrekHotel.Excecoes.RRException;
import br.ufrpe.GrekHotel.Excecoes.RSException;
import br.ufrpe.GrekHotel.Excecoes.RUException;
import br.ufrpe.GrekHotel.Negocio.beans.Reserva;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import br.ufrpe.GrekHotel.Negocio.beans.Usuario;
import br.ufrpe.GrekHotel.Negocio.beans.Servico;
import br.ufrpe.GrekHotel.Negocio.beans.Conta;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import java.util.ArrayList;

public class Sistema  {

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

 public void cadastrarQuarto(Quarto quar) throws CQException {
  this.ctrlAdm.cadastrarQuarto(quar);
 }

 public void cadastrarServico(Servico serv) throws CSException {

  this.ctrlAdm.cadastrarServico(serv);

 }

 public boolean removerQuarto(Quarto quartoRem) throws RQException {

  return this.ctrlAdm.removerQuarto(quartoRem);

 }

 public boolean removerServico(Servico servRem) throws RSException {

  return this.ctrlAdm.removerServico(servRem);

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

 public Quarto procurarQuarto(int numero){
     return this.ctrlReservas.procurarQuarto(numero);
 }
 
 public boolean cancelarReserva(Reserva reserva) throws RRException {

  return this.ctrlReservas.cancelarReserva(reserva);

 }

 public void checkIn(Reserva reserva) {

  ctrlReservas.checkIn(reserva);

 }

 public void checkOut(Reserva reserva) {

  ctrlReservas.checkOut(reserva);

 }

 public boolean cadastrarUsuario(Usuario u) throws CUException {
  
  return ctrlUsuario.cadastrarUsuario(u);
  
 }

 public Usuario efetuarLogin(String login, String senha) {
        usuario = ctrlUsuario.efetuarLogin(login, senha);
         return usuario;
  
 }

 public boolean removerUsuario(Usuario u) throws RUException {
  
  return ctrlUsuario.removerUsuario(u);
  
 }

 public void contratarServico(Cliente cliente, Servico servico) {

  this.ctrlCliente.contratarServico(cliente, servico);
  
 }

 public Conta consultarDespesas(Cliente cliente) {

  return this.ctrlCliente.consultarDespesas(cliente);
  
 }
}
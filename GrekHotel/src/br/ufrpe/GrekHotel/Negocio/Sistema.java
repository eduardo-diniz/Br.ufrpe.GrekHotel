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
import br.ufrpe.GrekHotel.beans.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

 public ArrayList listarQuartos() {
  return ctrlReservas.listarQuartos();
 }

 public ArrayList listarServicos() {
  return ctrlAdm.lista();
 }

 public void cadastrarQuarto(Quarto quar) {
  this.ctrlAdm.cadastrarQuarto(quar);
 }

 public void cadastrarServico(Servico serv) {

  this.ctrlAdm.cadastrarServico(serv);

 }

 public boolean removerQuarto(Quarto quartoRem) {

  return this.ctrlAdm.removerQuarto(quartoRem);

 }

 public boolean removerServico(Servico servRem) {

  return this.ctrlAdm.removerServico(servRem);

 }

 public void Reservar(Reserva reserva) {

  this.ctrlReservas.Reservar(reserva);

 }

 public Reserva procurarReserva(Quarto quarto) {

  return this.ctrlReservas.procurarReserva(quarto);

 }

 public Reserva procurarReserva(Cliente cliente) {

  return this.ctrlReservas.procurarReserva(cliente);

 }

 public boolean cancelarReserva(Reserva reserva) {

  return this.ctrlReservas.cancelarReserva(reserva);

 }

 public void checkIn(Reserva reserva) {

  ctrlReservas.checkIn(reserva);

 }

 public void checkOut(Reserva reserva) {

  ctrlReservas.checkOut(reserva);

 }

 public boolean cadastrarUsuario(Usuario u) {
  
  return ctrlUsuario.cadastrarUsuario(u);
  
 }

 public Usuario efetuarLogin(String login, String senha) {
  
  return ctrlUsuario.efetuarLogin(login, senha);
  
 }

 public boolean removerUsuario(Usuario u) {
  
  return ctrlUsuario.removerUsuario(u);
  
 }

 public void contratarServico(Cliente cliente, Servico servico) {

  this.ctrlCliente.contratarServico(cliente, servico);
  
 }

 public Conta consultarDespesas(Cliente cliente) {

  return this.ctrlCliente.consultarDespesas(cliente);
  
 }
}
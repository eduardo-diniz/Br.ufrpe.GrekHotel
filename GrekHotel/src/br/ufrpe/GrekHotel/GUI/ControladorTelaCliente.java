/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Excecoes.RRException;
import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import br.ufrpe.GrekHotel.Negocio.beans.Conta;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import br.ufrpe.GrekHotel.Negocio.beans.Reserva;
import br.ufrpe.GrekHotel.Negocio.beans.Servico;
import br.ufrpe.GrekHotel.Negocio.beans.Visita;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Eduardo
 */
public class ControladorTelaCliente {

    @FXML
    private Button btnContratarServico;
    @FXML
    private Button btnSair;

    @FXML
    private Label txtBemVindo;

    @FXML
    private Button btnQuartos;

    @FXML
    private Button btnCancelar;

    @FXML
    private TableView<Visita> tblCliente;

    @FXML
    private TableColumn<Visita, Quarto> colQuartosCliente;

    @FXML
    private TableColumn<Visita, Conta> colValoresCliente;

    @FXML
    private TableColumn<Visita, LocalDate> colDatasClienteIn;

    @FXML
    private TableColumn<Visita, LocalDate> colDatasClienteOut;

    @FXML
    private TableView<Servico> tblServicos;

    @FXML
    private TableColumn<Servico, String> colServico;

    @FXML
    private TableColumn<Servico, Double> colValorservico;

    @FXML
    private TableView<Conta> tblDespesas;

    @FXML
    private TableColumn<Conta, ArrayList<Servico>> colDespesasServico;

    @FXML
    private TableColumn<Conta, Double> colDespesasValor;

    @FXML
    private Button btnImprimirDespesas;

    @FXML
    private Button mudarLogin;

    @FXML
    private Button mudarSenha;

    private Sistema fachada = Sistema.getInstance();

    public void initialize() {

        txtBemVindo.setText("Olá, " + fachada.getUsuario() + "bem vindxs");

        //Tabela de Serviços
        colValorservico.setCellValueFactory(new PropertyValueFactory<>("custo"));
        colServico.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tblServicos.setItems(FXCollections.observableArrayList(fachada.listarServicos()));
        tblServicos.refresh();

        //Tabela de Informações sobre a Visita
        colQuartosCliente.setCellValueFactory(new PropertyValueFactory<>("quarto"));
        colValoresCliente.setCellValueFactory(new PropertyValueFactory<>("despesa"));
        colDatasClienteIn.setCellValueFactory((new PropertyValueFactory<>("checkIn")));
        colDatasClienteOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        // tblServicos.setItems(FXCollections.observableArrayList(s.);
        tblServicos.refresh();

        //Tabela de informações sobre a despesa
        colDespesasServico.setCellValueFactory(new PropertyValueFactory<>("compras"));
        colDespesasValor.setCellValueFactory((new PropertyValueFactory<>("valorTotal")));

        tblDespesas.setItems(FXCollections.observableArrayList(fachada.listarQuartos()));
        //Ignorem por enquanto
        Cliente c = (Cliente) fachada.getUsuario();
        //para cancelar reserva fachada.procurarReserva(c) != null
        /*if (fachada.procurarReserva(c).getVisita() != null) {

            btnContratarServico.setDisable(true);
        } else {

            btnContratarServico.setDisable(false);
        }*/

//        if (fachada.checkIn()) {
//
//            btnCancelar.setDisable(true);
//        } else {
//            btnCancelar.setDisable(false);
//
//        }
//
    }

    @FXML
    public void imprimirPdf(ActionEvent event
    ) {

    }

    public void alterarLogin() {

        TextInputDialog mudancaLogin = new TextInputDialog();
        mudancaLogin.setTitle("Mudança de Login");
        mudancaLogin.setHeaderText("Alteração do login");
        mudancaLogin.setContentText("Por favor, digite seu novo login:");

        Optional<String> resultadoLogin = mudancaLogin.showAndWait();
        if (resultadoLogin.isPresent() && !resultadoLogin.get().equals("")) {
            fachada.getUsuario().setLogin(resultadoLogin.get());
        } else {

        }
    }

    public void alterarSenha() {
        TextInputDialog mudancaLogin = new TextInputDialog();
        mudancaLogin.setTitle("Mudança de Senha");
        mudancaLogin.setHeaderText("Alteração do senha");
        mudancaLogin.setContentText("Por favor, digite sua nova senha:");
        Optional<String> resultadoSenha = mudancaLogin.showAndWait();
        if (resultadoSenha.isPresent() && !resultadoSenha.get().equals("")) {
            fachada.getUsuario().setSenha(resultadoSenha.get());
        } else {

        }

    }

    public void cancelarHospedagem() {
        Reserva posCan;
        try {
            posCan = fachada.procurarReserva((Cliente) fachada.getUsuario());
            if (posCan != null) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setHeaderText("Confirmação do cancelamento.");
                alerta.setContentText("Deseja mesmo cancelar a hospedagem?");
                Optional<ButtonType> result = alerta.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Alert ok = new Alert(Alert.AlertType.INFORMATION);
                    ok.setHeaderText("Confirmação de cancelamento");
                    ok.setContentText("Hospodagem cancelada com sucesso.");
                    ok.show();
                    fachada.cancelarReserva(posCan);

                } else {
                    Alert ok = new Alert(Alert.AlertType.INFORMATION);
                    ok.setHeaderText("Confirmação de cancelamento.");
                    ok.setContentText("Hospedagem não cancelada.");
                    ok.show();

                }

            }

        } catch (RRException a) {
            //Gabriel

        }
    }

    public void telaQuartos() {
        try {
            GrekHotel.changeScreem("TelaReservas");
        } catch (IOException ex) {
            Logger.getLogger(ControladorTelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sair() {
        fachada.setUsuario(null);
        try {
            GrekHotel.changeScreem("TelaUser");
        } catch (IOException ex) {
            Logger.getLogger(ControladorTelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void contratarServico() {
        if (tblServicos.getSelectionModel().getSelectedItem() != null) {
            fachada.contratarServico((Cliente) fachada.getUsuario(), tblServicos.getSelectionModel().getSelectedItem());
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("selecione um serviço na tabela");
            alerta.setHeaderText("falha na escolha de serviço");
            alerta.show();
        }
    }

}

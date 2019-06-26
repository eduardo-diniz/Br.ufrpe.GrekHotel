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
import java.time.LocalDateTime;
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
    private TableColumn<Visita, LocalDateTime> colDatasClienteIn;

    @FXML
    private TableColumn<Visita, LocalDateTime> colDatasClienteOut;

    @FXML
    private TableView<Servico> tblServicos;

    @FXML
    private TableColumn<Servico, String> colServico;

    @FXML
    private TableColumn<Servico, Double> colValorservico;

    @FXML
    private TableView<Servico> tblDespesas;

    @FXML
    private TableColumn<Servico, String> colDespesasServico;

    @FXML
    private TableColumn<Servico, Double> colDespesasValor;

    @FXML
    private Button btnImprimirDespesas;

    @FXML
    private Button mudarLogin;

    @FXML
    private Button mudarSenha;

    @FXML
    private Label txtValorTotal;

    private Sistema fachada = Sistema.getInstance();

    public void initialize() {

        txtBemVindo.setText("Olá, " + fachada.getUsuario() + " seja bem vindx");

        //Tabela de Serviços
        colValorservico.setCellValueFactory(new PropertyValueFactory<>("custo"));
        colServico.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tblServicos.setItems(FXCollections.observableArrayList(fachada.listarServicos()));
        tblServicos.refresh();
        Cliente c = (Cliente) fachada.getUsuario();
        //Tabela de Informações sobre o historico
        colQuartosCliente.setCellValueFactory(new PropertyValueFactory<>("quarto"));
        colValoresCliente.setCellValueFactory(new PropertyValueFactory<>("despesa"));
        colDatasClienteIn.setCellValueFactory((new PropertyValueFactory<>("checkIn")));
        colDatasClienteOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        tblCliente.setItems(FXCollections.observableArrayList(c.getHistoricoVisita()));
        tblServicos.refresh();

        //Tabela de informações sobre a despesa
        colDespesasServico.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colDespesasValor.setCellValueFactory((new PropertyValueFactory<>("custo")));
        if (c.getDespesa() != null) {
            tblDespesas.setItems(FXCollections.observableArrayList(c.getDespesa().getCompras()));
        }

        if (fachada.procurarReserva(c) != null && fachada.procurarReserva(c).getVisita() != null) {

            btnContratarServico.setDisable(false);
        } else {

            btnContratarServico.setDisable(true);
        }

        if (fachada.procurarReserva(c) != null && fachada.procurarReserva(c).getVisita() == null) {

            btnCancelar.setDisable(false);
        } else {
            btnCancelar.setDisable(true);

        }

        if (fachada.procurarReserva(c) != null) {
            btnQuartos.setDisable(true);
        } else {
            btnQuartos.setDisable(false);
        }

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
                    //

                } else {
                    Alert ok = new Alert(Alert.AlertType.INFORMATION);
                    ok.setHeaderText("Confirmação de cancelamento.");
                    ok.setContentText("Hospedagem não cancelada.");
                    ok.show();

                }

            }

        } catch (RRException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(a.getMessage());
            alerta.setHeaderText("Falha ao remover reserva");
            alerta.show();

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
            txtValorTotal.setText("....");

        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Selecione um serviço na tabela");
            alerta.setHeaderText("Falha na escolha de serviço");
            alerta.show();
        }
    }

}

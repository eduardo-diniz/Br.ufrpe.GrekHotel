/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import br.ufrpe.GrekHotel.Negocio.beans.Conta;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import br.ufrpe.GrekHotel.Negocio.beans.Servico;
import br.ufrpe.GrekHotel.Negocio.beans.Visita;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Eduar
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

    private Sistema fachada;

    public void initialize() {

        fachada = Sistema.getInstance();
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

    }

    public void telaQuartos() {
        GrekHotel.changeScreem("TelaReservas");

    }

    public void sair() {
        fachada.setUsuario(null);
        GrekHotel.changeScreem("TelaUser");
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

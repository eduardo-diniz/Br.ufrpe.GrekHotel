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
import br.ufrpe.GrekHotel.Negocio.beans.Reserva;
import br.ufrpe.GrekHotel.Negocio.beans.Servico;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private Button btnSair;

    @FXML
    private Label txtBemVindo;

    @FXML
    private Button btnQuartos;

    @FXML
    private TableView<?> tblCliente;

    @FXML
    private TableColumn<Quarto, Integer> colQuartosCliente;

    @FXML
    private TableColumn<Conta, Double> colValoresCliente;

    @FXML
    private TableColumn<Reserva, LocalDate> colDatasClienteIn;

    @FXML
    private TableColumn<Reserva, LocalDate> colDatasClienteOut;

    @FXML
    private TableView<Servico> tblServicos;

    @FXML
    private TableColumn<Servico, String> colServico;

    @FXML
    private TableColumn<Servico, Double> colValorservico;

    private Sistema s;

    public void initialize() {

        s = Sistema.getInstance();
        //Tabela de Serviços
        colValorservico.setCellValueFactory(new PropertyValueFactory<>("custo"));
        colServico.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tblServicos.setItems(FXCollections.observableArrayList(s.listarServicos()));
        tblServicos.refresh();

        //Tabela de Informações sobre a hospedagem
        colQuartosCliente.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colValoresCliente.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        colDatasClienteIn.setCellValueFactory((new PropertyValueFactory<>("checkInPrevisto")));
        colDatasClienteOut.setCellValueFactory(new PropertyValueFactory<>("checkOutPrevisto"));
       // tblServicos.setItems(FXCollections.observableArrayList(s.);
        tblServicos.refresh();

    }

    @FXML
    void handle(ActionEvent event) {

    }

}

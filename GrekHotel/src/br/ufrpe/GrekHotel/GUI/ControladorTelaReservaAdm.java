/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import br.ufrpe.GrekHotel.Negocio.beans.Reserva;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Eduardo
 */
public class ControladorTelaReservaAdm {
    Sistema fachada = Sistema.getInstance();

    @FXML
    private TableView<Quarto> tblDisponibilidadeAdm;

    @FXML
    private TableColumn<Quarto, Integer> colQuartos;

    @FXML
    private TableColumn<Quarto, Integer> colSituação;

    @FXML
    private Button btnHome;

    @FXML
    private TableView<Reserva> tblReservasAdm;

    @FXML
    private TableColumn<Reserva, Quarto> colQuartosReservado;

    @FXML
    private TableColumn<Reserva, Cliente> colNomeCliente;

    @FXML
    private TableColumn<Reserva, LocalDate> colCheckIn;

    @FXML
    private TableColumn<Reserva, LocalDate> colCheckOut;

    @FXML
    private Button btnAttPg;

    public void initialize() {
        
        colQuartos.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colSituação.setCellValueFactory(new PropertyValueFactory<>("situacao"));
        tblDisponibilidadeAdm.setItems(FXCollections.observableList(fachada.listarQuartos()));
        
        colQuartosReservado.setCellValueFactory(new PropertyValueFactory<>("quarto"));
        colNomeCliente.setCellValueFactory(new PropertyValueFactory<>("hospede"));
        colCheckIn.setCellValueFactory(new PropertyValueFactory<>("checkInPrevisto"));
        colCheckOut.setCellValueFactory(new PropertyValueFactory<>("checkOutPrevisto"));
        tblReservasAdm.setItems(FXCollections.observableList(fachada.listarReservas()));
        //colQuartos
        //colSituação
        
        

    }
    public void atualizarPagina(){
        
    }

    
    public void home(){
        GrekHotel.changeScreem("TelaAdmInicial");
    }
        
}

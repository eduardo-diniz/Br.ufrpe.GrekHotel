/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Excecoes.RRException;
import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import br.ufrpe.GrekHotel.Negocio.beans.Reserva;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private Button btnCheckin;

    @FXML
    private Button btnCheckOut;

    public void initialize() {

        colQuartos.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colSituação.setCellValueFactory(new PropertyValueFactory<>("situacao"));
        tblDisponibilidadeAdm.setItems(FXCollections.observableList(fachada.listarQuartos()));

        colQuartosReservado.setCellValueFactory(new PropertyValueFactory<>("quarto"));
        colNomeCliente.setCellValueFactory(new PropertyValueFactory<>("hospede"));
        colCheckIn.setCellValueFactory(new PropertyValueFactory<>("checkInPrevisto"));
        colCheckOut.setCellValueFactory(new PropertyValueFactory<>("checkOutPrevisto"));
        tblReservasAdm.setItems(FXCollections.observableList(fachada.listarReservas()));

    }

    public void atualizarPagina() {

    }

    public void checkin() {
        Reserva atualIn;
        if (tblReservasAdm.getSelectionModel().getSelectedItem() != null) {
            atualIn = tblReservasAdm.getSelectionModel().getSelectedItem();
            fachada.checkIn(atualIn);
<<<<<<< HEAD
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setContentText("Informação sobre o Check-In");
            alerta.setHeaderText("Check-In realizado com sucesso");
            alerta.show();
=======
>>>>>>> parent of 5977673... Correção de Erros 9.2(Alerts)
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Selecione uma reserva na tabela");
            alerta.setHeaderText("Falha na escolha da reserva");
            alerta.show();

        }

    }

    public void checkout() {
        Reserva atualOut;
        if (tblReservasAdm.getSelectionModel().getSelectedItem() != null) {
            try {
                atualOut = tblReservasAdm.getSelectionModel().getSelectedItem();
                fachada.checkOut(atualOut);
<<<<<<< HEAD
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setContentText("Informação sobre o Check-Out");
                alerta.setHeaderText("Check-Out realizado com sucesso");
                alerta.show();
            } catch (RRException e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText(e.getMessage());
                alerta.setHeaderText("Falha ao fazer chechout");
                alerta.show();
=======
            }catch(RRException e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(e.getMessage());
            alerta.setHeaderText("falha ao fazer chechout");
            alerta.show();
>>>>>>> parent of 5977673... Correção de Erros 9.2(Alerts)
            }

        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Selecione uma reserva na tabela");
            alerta.setHeaderText("Falha na escolha da reserva");
            alerta.show();
        }

    }

    public void homeAdm() {
        try {
            GrekHotel.changeScreem("TelaAdmInicial");
        } catch (IOException ex) {
            Logger.getLogger(ControladorTelaReservaAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
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
    private Button btnAttPg;

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
        //colQuartos
        //colSituação

    }

    public void atualizarPagina() {

    }

    public void checkin() {
        Reserva atualIn;
        if (tblReservasAdm.getSelectionModel().getSelectedItem() != null) {
            atualIn = tblReservasAdm.getSelectionModel().getSelectedItem();
            fachada.checkIn(atualIn);
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("selecione uma reserva na tabela");
            alerta.setHeaderText("falha na escolha da reserva");
            alerta.show();

        }

    }

    public void checkout() {
        Reserva atualOut;
        if (tblReservasAdm.getSelectionModel().getSelectedItem() != null) {
            atualOut = tblReservasAdm.getSelectionModel().getSelectedItem();
            fachada.checkOut(atualOut);

        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("selecione uma reserva na tabela");
            alerta.setHeaderText("falha na escolha da reserva");
            alerta.show();
        }

    }

    public void homeAdm() {
        GrekHotel.changeScreem("TelaAdmInicial");
    }

}

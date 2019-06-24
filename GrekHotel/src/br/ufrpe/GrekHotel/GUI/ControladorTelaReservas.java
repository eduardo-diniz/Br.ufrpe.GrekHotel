/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Excecoes.CRException;
import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import br.ufrpe.GrekHotel.Negocio.beans.Reserva;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Eduardo
 */
public class ControladorTelaReservas {

    @FXML
    private Button btnHome;

    @FXML
    private ImageView imgQrto;

    @FXML
    private Label lblNomeQrto;

    @FXML
    private DatePicker dataCheckIn;

    @FXML
    private DatePicker dataCheckOut;

    @FXML
    private Button btnReservar;

    @FXML
    private Label lblDescrQrto;
    //não vai usar
    /* @FXML
    private ComboBox<?> boxQuartosUser;*/

    @FXML
    private TableView<Quarto> tblQuartos;

    @FXML
    private TableColumn<Quarto, Integer> colQuarto;

    @FXML
    private TableColumn<Quarto, Double> colValor;

    @FXML
    private Button btnVerQrt;

    Sistema fachada = Sistema.getInstance();

    public void initialize() {

        fachada = Sistema.getInstance();

        colValor.setCellValueFactory((new PropertyValueFactory<>("diaria")));
        colQuarto.setCellValueFactory(new PropertyValueFactory<>("numero"));
        tblQuartos.setItems(FXCollections.observableArrayList(fachada.listarQuartos()));
        tblQuartos.refresh();

    }

    public void verQuarto() {
        //imgQrto.setImage( new Image(getClass().getResourceAsStream("endereço da imagem")));
        if (tblQuartos.getSelectionModel().getSelectedItem() != null) {
            lblDescrQrto.setText(tblQuartos.getSelectionModel().getSelectedItem().getDescricao());
            lblNomeQrto.setText("Quarto nº" + tblQuartos.getSelectionModel().getSelectedItem().getNumero());
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Selecione um quarto");
            alerta.show();
        }

    }

    public void reservar() {
        if (tblQuartos.getSelectionModel().getSelectedItem() != null && dataCheckIn.getValue() != null && dataCheckOut.getValue() != null) {
            try {
                fachada.Reservar(new Reserva(tblQuartos.getSelectionModel().getSelectedItem(), (Cliente) fachada.getUsuario(), dataCheckIn.getValue(), dataCheckOut.getValue()));
            } catch (CRException a) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("erro ao reservar quarto");
                alerta.setContentText(a.getMessage());
                alerta.show();
            }

        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Campos não preenchidos");
            alerta.setContentText("preencha todos os campos");
            alerta.show();
        }

    }

    public void telaHome() {
        GrekHotel.changeScreem("TelaHome");

    }

    @FXML
    void handle(ActionEvent event) {

        /*  if (event.getSource().equals(boxQuartosUser)) {

            lblValorDiaria.setText("R$: " + boxQuartosUser.getValue().getDiaria());
        }
        
        
         if (event.getSource().equals(btnReservar)){
             
             
             
         }*/
    }

}

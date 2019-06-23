/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    Sistema s = Sistema.getInstance();

    public void initialize() {

        s = Sistema.getInstance();

        colValor.setCellValueFactory((new PropertyValueFactory<>("diaria")));
        colQuarto.setCellValueFactory(new PropertyValueFactory<>("numero"));
        tblQuartos.setItems(FXCollections.observableArrayList(s.listarQuartos()));
        tblQuartos.refresh();

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

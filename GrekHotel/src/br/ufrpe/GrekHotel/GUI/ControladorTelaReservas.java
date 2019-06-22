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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import sun.security.jca.GetInstance;

/**
 *
 * @author Eduardo
 */
public class ControladorTelaReservas {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnReservar;

    @FXML
    private Label lblValorDiaria;
    @FXML
    private ComboBox<Quarto> boxQuartosUser;

    private Sistema s;

    @FXML
    private DatePicker dataCheckIn;

    @FXML
    private DatePicker dataCheckOut;

    public void initialize() {

        s = Sistema.getInstance();

        boxQuartosUser.setItems(FXCollections.observableArrayList(s.listarQuartos()));

    }

    @FXML
    void handle(ActionEvent event) {

        if (event.getSource().equals(boxQuartosUser)) {

            lblValorDiaria.setText("R$: " + boxQuartosUser.getValue().getDiaria());
        }
        
        
         if (event.getSource().equals(btnReservar)){
             
             
             
         }

    }

}

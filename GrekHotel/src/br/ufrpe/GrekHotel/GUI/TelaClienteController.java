/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Eduar
 */
public class TelaClienteController implements Initializable {

    @FXML
    private Button btnSair;
    @FXML
    private Label txtBemVindo;
    @FXML
    private Button btnQuartos;
    @FXML
    private Button btnServicos;
    @FXML
    private TableView<?> tblCliente;
    @FXML
    private TableColumn<?, ?> tblQuartosCliente;
    @FXML
    private TableColumn<?, ?> tblDatasCliente;
    @FXML
    private TableColumn<?, ?> tblValoresCliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle(ActionEvent event) {
    }
    
}

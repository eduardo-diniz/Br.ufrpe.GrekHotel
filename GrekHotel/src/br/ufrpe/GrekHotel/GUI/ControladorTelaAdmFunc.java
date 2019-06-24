/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Negocio.beans.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Eduardo
 */
public class ControladorTelaAdmFunc {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnCadastroFeito;

    @FXML
    private TextField inputNome;

    @FXML
    private TextField inputLoginCadastro;

    @FXML
    private TextField inputCPF;

    @FXML
    private TextField inputSenhaCadastro;

    @FXML
    private TextField inputIdade;

    @FXML
    private ComboBox<Funcionario> boxSetorServCadastro;

    @FXML
    private TableView<Funcionario> tblFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colFuncion;

    @FXML
    private TableColumn<Funcionario, String> colServFuncio;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnAtualizar;

    @FXML
    private Button btnSair;

    @FXML
    void cadastar(ActionEvent event) {

    }

    @FXML
    void telaHome(ActionEvent event) {

    }
}

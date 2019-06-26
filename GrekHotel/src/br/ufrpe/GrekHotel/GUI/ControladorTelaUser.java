/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

/**
 *
 * @author Eduar
 */
import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.*;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class ControladorTelaUser {

    Sistema fachada = Sistema.getInstance();

    @FXML
    private PasswordField inputSenha;

    @FXML
    private TextField inputLogin;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnLogin;

    @FXML

    public void initialize() {

        //o botao que direciona para a tela cadastrar deve chamar o seguinte metodo
        //GrekHotel.changeScreem("TelaCadastro");
       // btnCadastrar.setDisable(false);
    }

    @FXML
    public void login() {
        if (!inputLogin.getText().equals("") && !inputSenha.getText().equals("")) {
            Usuario local = fachada.efetuarLogin(inputLogin.getText(), inputSenha.getText());
            if (local != null) {
                inputLogin.clear();
                inputSenha.clear();
                if (local instanceof Cliente) {
                    try {
                        GrekHotel.changeScreem("TelaCliente");

                    } catch (IOException ex) {

                        Logger.getLogger(ControladorTelaUser.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (local instanceof Funcionario) {
                    try {
                        GrekHotel.changeScreem("TelaAdmInicial");
                    } catch (IOException ex) {
                        Logger.getLogger(ControladorTelaUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("login ou senha inválidos");
                alerta.setHeaderText("falha no login");
                alerta.show();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("campos vazios");
            alerta.setHeaderText("falha no login");
            alerta.show();
        }
    }

    @FXML
    public void telaCadastro() {

        try {
            GrekHotel.changeScreem("TelaCadastro");
        } catch (IOException ex) {
            Logger.getLogger(ControladorTelaUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

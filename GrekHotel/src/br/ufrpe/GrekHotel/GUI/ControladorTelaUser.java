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
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    
    }
    @FXML
    public void handle(){
        
         if(!inputLogin.getText().equals("") && !inputSenha.getText().equals("")){          
             Usuario local = fachada.efetuarLogin(inputLogin.getText(), inputSenha.getText());  
                    if(local != null){
                        if(local instanceof Cliente){   
                          GrekHotel.changeScreem("TelaCliente");
                           
                        }else if(local instanceof Funcionario){
                             GrekHotel.changeScreem("TelaAdm");
                             System.out.println("entrou");
                        }
                        
                }else{
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setContentText("login ou senha inválidos");
                    alerta.setHeaderText("falha no login");
                    alerta.show();
                }
         }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("campos vazios");
                alerta.setHeaderText("falha no login");
                alerta.show();
         }
    }

    @FXML
    public void telaCadastro(){
        
        GrekHotel.changeScreem("TelaCadastro");
        
    }
   
    
       
    
        
    
}

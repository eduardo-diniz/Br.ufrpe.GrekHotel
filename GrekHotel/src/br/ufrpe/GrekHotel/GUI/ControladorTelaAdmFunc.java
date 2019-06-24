/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Excecoes.AUException;
import br.ufrpe.GrekHotel.Excecoes.CUException;
import br.ufrpe.GrekHotel.Excecoes.RUException;
import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import br.ufrpe.GrekHotel.Negocio.beans.Funcionario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Eduardo
 */
public class ControladorTelaAdmFunc {
    Sistema fachada = Sistema.getInstance();

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
    private TableView<Funcionario> tblFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colFuncion;

    @FXML
    private TableColumn<Funcionario, Long> colServCpf;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnAtualizar;

     
     public void initialize(){
         colFuncion.setCellValueFactory((new PropertyValueFactory<>("nome")));
         colServCpf.setCellValueFactory((new PropertyValueFactory<>("cpf")));
         tblFuncionarios.setItems(FXCollections.observableArrayList(fachada.listarFun()));
         
     }
     
     public void cadastrarFuncionario(){
          try {
            if (!inputLoginCadastro.getText().equals("") && !inputSenhaCadastro.getText().equals("") && !inputNome.getText().equals("") && !inputIdade.getText().equals("") && !inputCPF.getText().equals("")) {
                Funcionario atual;
                atual = new Funcionario(inputLoginCadastro.getText(), inputSenhaCadastro.getText(), inputNome.getText(), Integer.parseInt(inputIdade.getText()), Long.parseLong(inputCPF.getText()));
                fachada.cadastrarUsuario(atual);
                inputCPF.clear();
                inputIdade.clear();
                inputLoginCadastro.clear();
                inputNome.clear();
                inputSenhaCadastro.clear();
                tblFuncionarios.setItems(FXCollections.observableArrayList(fachada.listarFun()));
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setContentText("Funcionario cadastrado com sucesso!");
                alerta.show();

            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("preencha todos os campos");
                alerta.setHeaderText("Erro ao cadastrar funcionario");
                alerta.show();
            }

        } catch (CUException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(a.getMessage());
            alerta.setHeaderText("Erro ao cadastrar funcionario");
            alerta.show();

        } catch (NumberFormatException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("digite numeros em idade e CPF");
            alerta.setHeaderText("Erro ao cadastrar funcionario");
            alerta.show();
        }
         
     }
     public void removerFuncionario(){
         Funcionario atualrmv;
         try{
             if(tblFuncionarios.getSelectionModel().getSelectedItem() != null){
                 atualrmv = tblFuncionarios.getSelectionModel().getSelectedItem();
                 fachada.removerUsuario(atualrmv);
                 tblFuncionarios.setItems(FXCollections.observableArrayList(fachada.listarFun()));
                 Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                 alerta.setContentText("Funcionario removido com sucesso!");
                 alerta.show();
             }else{
                 Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Item nao selecionado");
                alerta.setHeaderText("Erro ao remover funcionario");
                alerta.show();
                 
             }
             
         }catch(RUException a){
             // Gabriel
             
         }
         
         
     }
     public void atualizarFuncionario(){
         Funcionario antigo;
         Funcionario novo;
         try{
             if(tblFuncionarios.getSelectionModel().getSelectedItem() != null){
                 antigo = tblFuncionarios.getSelectionModel().getSelectedItem();
                  if (!inputLoginCadastro.getText().equals("") && !inputSenhaCadastro.getText().equals("") && !inputNome.getText().equals("") && !inputIdade.getText().equals("") && !inputCPF.getText().equals("")) {
                      novo = new Funcionario(inputLoginCadastro.getText(), inputSenhaCadastro.getText(), inputNome.getText(), Integer.parseInt(inputIdade.getText()), Long.parseLong(inputCPF.getText()));
                      fachada.atualizarUsuario(antigo, novo);
                      inputCPF.clear();
                      inputIdade.clear();
                      inputLoginCadastro.clear();
                      inputNome.clear();
                      inputSenhaCadastro.clear();
                      tblFuncionarios.setItems(FXCollections.observableArrayList(fachada.listarFun()));
                      Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                      alerta.setContentText("Funcionario atualizado com sucesso!");
                      alerta.show();
                 
             }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Preencha todos os campos");
                alerta.setHeaderText("Erro ao atualizar o funcionario");
                alerta.show();
                  }
         }else{
                 Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Item nao selecionado");
                alerta.setHeaderText("Erro ao atualizar o funcionario");
                alerta.show();
             }
         
         
     }catch(AUException a){
         //Gabriel
     }catch(NumberFormatException a){
         
     }
             
     }
    
}

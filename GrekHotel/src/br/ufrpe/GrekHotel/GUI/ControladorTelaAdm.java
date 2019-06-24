/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Excecoes.AQException;
import br.ufrpe.GrekHotel.Excecoes.ASException;
import br.ufrpe.GrekHotel.Excecoes.CQException;
import br.ufrpe.GrekHotel.Excecoes.CSException;
import br.ufrpe.GrekHotel.Excecoes.RQException;
import br.ufrpe.GrekHotel.Excecoes.RSException;
import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import br.ufrpe.GrekHotel.Negocio.beans.Servico;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Eduardo
 */
public class ControladorTelaAdm {

    @FXML
    private TextField fieldNumQuarto;

    @FXML
    private TextField fieldDiaria;

    @FXML
    private TextArea areaDescrQuarto;

    @FXML
    private TableView<Quarto> tblCadQuarto;

    @FXML
    private TableColumn<Quarto, Integer> colNumeroCadQuarto;

    @FXML
    private TableColumn<Quarto, Double> colDiariaCadQuarto;

    @FXML
    private TableColumn<Quarto, String> colDescricaoCadQuarto;

    @FXML
    private Button btnRemoverQuarto;

    @FXML
    private Button btnAtualizarQuarto;

    @FXML
    private Button btnAtualizarServico;

    @FXML
    private Button btnRemoverServico;

    @FXML
    private TableView<Servico> tblCadServico;

    @FXML
    private TableColumn<Servico, String> colCadServico;

    @FXML
    private TableColumn<Servico, Double> colCadValor;

    @FXML
    private TextField fieldServico;

    @FXML
    private TextField fieldValorServico;

    @FXML
    private Button btnCadQuarto;

    @FXML
    private Button btnCadServico;

    private Sistema fachada = fachada = Sistema.getInstance();

    public void initialize() {
        colDiariaCadQuarto.setCellValueFactory((new PropertyValueFactory<>("diaria")));
        colNumeroCadQuarto.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colDescricaoCadQuarto.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tblCadQuarto.setItems(FXCollections.observableArrayList(fachada.listarQuartos()));
        tblCadQuarto.refresh();

        colCadServico.setCellValueFactory((new PropertyValueFactory<>("descricao")));
        colCadValor.setCellValueFactory((new PropertyValueFactory<>("custo")));
        tblCadQuarto.setItems(FXCollections.observableArrayList(fachada.listarServicos()));
        tblCadServico.refresh();
    }
    public void cadastrarQuarto() throws CQException{
        Quarto atual;
        System.out.println("ok1");
        try{
             System.out.println("ok2");
            if(!areaDescrQuarto.getText().equals("") && !fieldDiaria.getText().equals("") && !fieldNumQuarto.getText().equals("")){
              System.out.println("ok3");
                atual = new Quarto(areaDescrQuarto.getText(), Double.parseDouble(fieldDiaria.getText()), Integer.parseInt(fieldNumQuarto.getText()));
             fachada.cadastrarQuarto(atual);
                System.out.println(atual);
             areaDescrQuarto.clear();
             fieldDiaria.clear();
             fieldNumQuarto.clear();
             Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
             alerta.setContentText("Quarto cadastrado com sucesso!");
             alerta.show();
           
            
        }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Preencha todos os campos");
                alerta.setHeaderText("Erro ao cadastrar quarto");
                alerta.show();
                
            }
            
        }catch(CQException a){
            //Gabriel
            
        }catch(NumberFormatException a){
            //Gabriel
        }
         
    }
    public void removerQuarto() throws RQException{
        Quarto atualrmv;
       try{
           if(tblCadQuarto.getSelectionModel().getSelectedItem() != null){
            atualrmv = tblCadQuarto.getSelectionModel().getSelectedItem();
            fachada.removerQuarto(atualrmv);
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
             alerta.setContentText("Quarto removido com sucesso!");
             alerta.show();
        }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Item nao selecionado");
                alerta.setHeaderText("Erro ao remover quarto");
                alerta.show();
               
           }
        
           
       }catch(RQException a){
       //Gabriel
       }
    }
    public void atualizarQuarto() throws AQException{
       Quarto antigo;
       Quarto novo;
       try{
           if(tblCadQuarto.getSelectionModel().getSelectedItem() != null){
            antigo = tblCadQuarto.getSelectionModel().getSelectedItem();
            if(!areaDescrQuarto.getText().equals("") && !fieldDiaria.getText().equals("") && !fieldNumQuarto.getText().equals("")){
                novo = new Quarto(areaDescrQuarto.getText(), Double.parseDouble(fieldDiaria.getText()), Integer.parseInt(fieldNumQuarto.getText()));
                     fachada.atualizarQuarto(antigo, novo);
                     Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                     alerta.setContentText("Quarto atualizado com sucesso!");
                     alerta.show();
            }else{
                  Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Preencha todos os campos");
                alerta.setHeaderText("Erro ao cadastrar quarto");
                alerta.show();
                
            }
           }else{
               Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Item nao selecionado");
                alerta.setHeaderText("Erro ao remover quarto");
                alerta.show();
               
           }
        
        }catch(AQException a){
        //Gabriel
        }catch(NumberFormatException a){
            //Gabriel
        }  
    }
    public void cadastrarServico() throws CSException{
        Servico atualSer;
        try{
            if(!fieldServico.getText().equals("") && !fieldValorServico.getText().equals("")){
            atualSer = new Servico(fieldServico.getText() , Double.parseDouble(fieldValorServico.getText()));
            fachada.cadastrarServico(atualSer);
             Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
             alerta.setContentText("Serviço cadastrado com sucesso!");
             alerta.show();
             
            
        }else{
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Preencha todos os campos");
                alerta.setHeaderText("Erro ao cadastrar serviço");
                alerta.show();
                
            }
            
        }catch(CSException a){
            //Gabriel
            
        }catch(NumberFormatException a){
            //Gabriel
            
        }
        
        
    }
    public void removerServico() throws RSException{
        Servico atualSerrmv;
        try{
            if(tblCadServico.getSelectionModel().getSelectedItem() != null){
            atualSerrmv = tblCadServico.getSelectionModel().getSelectedItem();
            fachada.removerServico(atualSerrmv);
        }else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Item nao selecionado");
                alerta.setHeaderText("Erro ao remover quarto");
                alerta.show();
                
            }
            
        }catch(RSException a){
            //Gabriel
        }
        
        
    }
    public void atualizarServico() throws ASException{
        Servico antigo;
        Servico novo;
        try{
            if(tblCadServico.getSelectionModel().getSelectedItem() != null){
             antigo = tblCadServico.getSelectionModel().getSelectedItem();
                if(!fieldServico.getText().equals("") && !fieldValorServico.getText().equals("")){
                     novo = new Servico(fieldServico.getText() , Double.parseDouble(fieldValorServico.getText()));
                     fachada.atualizarServico(antigo, novo);
                     Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                      alerta.setContentText("Serviço atualizado com sucesso!");
                      alerta.show();
                }else{
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Preencha todos os campos");
                alerta.setHeaderText("Erro ao cadastrar serviço");
                alerta.show();
                      
                    }
                }else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Item nao selecionado");
                alerta.setHeaderText("Erro ao remover quarto");
                alerta.show();
                
                    }
            
        }catch(ASException a){
            //Gabriel
            
        }catch(NumberFormatException a){
            //Gabriel
            
        }
        
        
    }

}

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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Button btnHomeAdm;

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
        tblCadServico.setItems(FXCollections.observableArrayList(fachada.listarServicos()));
        tblCadServico.refresh();
    }

    public void home() {
        try {
            GrekHotel.changeScreem("TelaAdmInicial");
        } catch (IOException ex) {
            Logger.getLogger(ControladorTelaAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastrarQuarto() {
        Quarto atual;
        try {
            if (!areaDescrQuarto.getText().equals("") && !fieldDiaria.getText().equals("") && !fieldNumQuarto.getText().equals("")) {
                atual = new Quarto(areaDescrQuarto.getText(), Double.parseDouble(fieldDiaria.getText()), Integer.parseInt(fieldNumQuarto.getText()));
                fachada.cadastrarQuarto(atual);
                areaDescrQuarto.clear();
                fieldDiaria.clear();
                fieldNumQuarto.clear();
                tblCadQuarto.setItems(FXCollections.observableList(fachada.listarQuartos()));
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setContentText("Quarto cadastrado com sucesso!");
                alerta.show();

            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Preencha todos os campos");
                alerta.setHeaderText("Erro ao cadastrar quarto");
                alerta.show();

            }

        } catch (CQException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(a.getMessage());
            alerta.setHeaderText("Erro ao cadastrar quarto");
            alerta.show();
        } catch (NumberFormatException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Digite números válidos em diária e número");
            alerta.setHeaderText("Erro ao cadastrar quarto");
            alerta.show();
        }

    }

    public void removerQuarto() {
        Quarto atualrmv;
        try {
            if (tblCadQuarto.getSelectionModel().getSelectedItem() != null) {
                atualrmv = tblCadQuarto.getSelectionModel().getSelectedItem();
                fachada.removerQuarto(atualrmv);
                tblCadQuarto.setItems(FXCollections.observableList(fachada.listarQuartos()));
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setContentText("Quarto removido com sucesso!");
                alerta.show();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Item nao selecionado");
                alerta.setHeaderText("Erro ao remover quarto");
                alerta.show();

            }

        } catch (RQException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(a.getMessage());
            alerta.setHeaderText("Erro ao remover quarto");
            alerta.show();
        }
    }

    public void atualizarQuarto() {
        Quarto antigo;
        Quarto novo;
        try {
            if (tblCadQuarto.getSelectionModel().getSelectedItem() != null) {
                antigo = tblCadQuarto.getSelectionModel().getSelectedItem();
                if (!areaDescrQuarto.getText().equals("") && !fieldDiaria.getText().equals("") && !fieldNumQuarto.getText().equals("")) {
                    novo = new Quarto(areaDescrQuarto.getText(), Double.parseDouble(fieldDiaria.getText()), Integer.parseInt(fieldNumQuarto.getText()));
                    fachada.atualizarQuarto(antigo, novo);
                    tblCadQuarto.setItems(FXCollections.observableList(fachada.listarQuartos()));
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setContentText("Quarto atualizado com sucesso!");
                    alerta.show();
                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setContentText("Preencha todos os campos");
                    alerta.setHeaderText("Erro ao cadastrar quarto");
                    alerta.show();

                }
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Item nao selecionado");
                alerta.setHeaderText("Erro ao remover quarto");
                alerta.show();

            }

        } catch (AQException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(a.getMessage());
            alerta.setHeaderText("Erro ao atualizar quarto");
            alerta.show();

        } catch (NumberFormatException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("digite números válidos em diária e número");
            alerta.setHeaderText("Erro ao atualizar quarto");
            alerta.show();
        }
    }

    public void cadastrarServico() {
        Servico atualSer;
        try {
            if (!fieldServico.getText().equals("") && !fieldValorServico.getText().equals("")) {
                atualSer = new Servico(fieldServico.getText(), Double.parseDouble(fieldValorServico.getText()));
                fachada.cadastrarServico(atualSer);
                tblCadServico.setItems(FXCollections.observableArrayList(fachada.listarServicos()));
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setContentText("Serviço cadastrado com sucesso!");
                alerta.show();

            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Preencha todos os campos");
                alerta.setHeaderText("Erro ao cadastrar serviço");
                alerta.show();

            }

        } catch (CSException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(a.getMessage());
            alerta.setHeaderText("Erro ao cadastrar serviço");
            alerta.show();

        } catch (NumberFormatException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("digite números válidos em diária e númer");
            alerta.setHeaderText("Erro ao cadastrar serviço");
            alerta.show();

        }

    }

    public void removerServico() {
        Servico atualSerrmv;
        try {
            if (tblCadServico.getSelectionModel().getSelectedItem() != null) {
                atualSerrmv = tblCadServico.getSelectionModel().getSelectedItem();
                fachada.removerServico(atualSerrmv);
                tblCadServico.setItems(FXCollections.observableArrayList(fachada.listarServicos()));
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Item nao selecionado");
                alerta.setHeaderText("Erro ao remover quarto");
                alerta.show();

            }

        } catch (RSException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(a.getMessage());
            alerta.setHeaderText("Erro ao remover quarto");
            alerta.show();
        }

    }

    public void atualizarServico() {
        Servico antigo;
        Servico novo;
        try {
            if (tblCadServico.getSelectionModel().getSelectedItem() != null) {
                antigo = tblCadServico.getSelectionModel().getSelectedItem();
                if (!fieldServico.getText().equals("") && !fieldValorServico.getText().equals("")) {
                    novo = new Servico(fieldServico.getText(), Double.parseDouble(fieldValorServico.getText()));
                    fachada.atualizarServico(antigo, novo);
                    tblCadServico.setItems(FXCollections.observableArrayList(fachada.listarServicos()));
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setContentText("Serviço atualizado com sucesso!");
                    alerta.show();
                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setContentText("Preencha todos os campos");
                    alerta.setHeaderText("Erro ao atualizar serviço");
                    alerta.show();

                }
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Item nao selecionado");
                alerta.setHeaderText("Erro ao atualizar serviço");
                alerta.show();

            }

        } catch (ASException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(a.getMessage());
            alerta.setHeaderText("Erro ao atualizar serviço");
            alerta.show();

        } catch (NumberFormatException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("digite um número válido em valor");
            alerta.setHeaderText("Erro ao cadastrar serviço");
            alerta.show();

        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Quarto;
import br.ufrpe.GrekHotel.Negocio.beans.Servico;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
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

    private Sistema s;

    public void initialize() {

        s = Sistema.getInstance();

        colDiariaCadQuarto.setCellValueFactory((new PropertyValueFactory<>("diaria")));
        colNumeroCadQuarto.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colDescricaoCadQuarto.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tblCadQuarto.setItems(FXCollections.observableArrayList(s.listarQuartos()));
        tblCadQuarto.refresh();

        colCadServico.setCellValueFactory((new PropertyValueFactory<>("descricao")));
        colCadValor.setCellValueFactory((new PropertyValueFactory<>("custo")));
        tblCadQuarto.setItems(FXCollections.observableArrayList(s.listarServicos()));
        tblCadServico.refresh();

    }

}

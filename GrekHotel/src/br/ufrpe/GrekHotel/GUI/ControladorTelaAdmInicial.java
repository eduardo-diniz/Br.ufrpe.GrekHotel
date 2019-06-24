package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Negocio.Sistema;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorTelaAdmInicial {
    Sistema fachada = Sistema.getInstance();

    @FXML
    private Button btnSair;

    @FXML
    private Button btnTelaReserva;

    @FXML
    private Button btnTelaQrtServ;

    @FXML
    private Button btnTelaFuncionario;

    @FXML
    private Label lblNomeAdm;
    
    
    public void initialize() {
         lblNomeAdm.setText(("Olá, " + fachada.getUsuario()+ "bem vindxs"));

    }
    
        
    public void telaFuncionario(){
             GrekHotel.changeScreem("TelaFuncionarios");
    }

    public void telaquartoservico(){
        
             GrekHotel.changeScreem("TelaQuartoServicos");
 
    }
    public void telaVerificarReservas(){
        
             GrekHotel.changeScreem("TelaVerificarReservas");

    }
     public void sair(){
           fachada.setUsuario(null);
           GrekHotel.changeScreem("TelaUser");
    }
}


package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Negocio.Sistema;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
        lblNomeAdm.setText(("Olá, " + fachada.getUsuario() + "bem vindxs"));

    }

    public void telaFuncionario() {
        try {
            GrekHotel.changeScreem("TelaFuncAdm");
        } catch (IOException ex) {
            Logger.getLogger(ControladorTelaAdmInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void telaquartoservico() {

        try {
            GrekHotel.changeScreem("TelaAdm");
        } catch (IOException ex) {
            Logger.getLogger(ControladorTelaAdmInicial.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void telaVerificarReservas() {

        try {
            GrekHotel.changeScreem("TelaReservaAdm");
        } catch (IOException ex) {
            Logger.getLogger(ControladorTelaAdmInicial.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sair() {
        fachada.setUsuario(null);
        try {
            GrekHotel.changeScreem("TelaUser");
        } catch (IOException ex) {
            Logger.getLogger(ControladorTelaAdmInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

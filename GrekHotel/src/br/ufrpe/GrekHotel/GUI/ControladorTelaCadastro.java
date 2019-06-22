package br.ufrpe.GrekHotel.GUI;

/**
 *
 * @author Eduardo
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorTelaCadastro {

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
    void handle(ActionEvent event) {

        if (event.getSource().equals(btnCadastroFeito)) {
            //Quando o cadastro estiver feito e for voltar para a tela principal
            //GrekHotel.changeScreem("TelaUser");

        }

        if (event.getSource().equals(btnHome)) {

        }

    }

}


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
    void handle(ActionEvent event) {

        if (event.getSource().equals(btnCadastroFeito)) {

            /*try {
            
            if(inputNome.equals("")){
                
            }

            } catch () {

            }*/
        }

        if (event.getSource().equals(btnHome)) {

        }

    }

}

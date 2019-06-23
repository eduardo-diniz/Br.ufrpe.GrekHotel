package br.ufrpe.GrekHotel.GUI;

/**
 *
 * @author Eduardo
 */
import br.ufrpe.GrekHotel.Excecoes.CUException;
import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorTelaCadastro {

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
    private Button btnCadastrar;

    @FXML
    private Button btnLogin;
    
    
    @FXML
    public void cadastar() throws CUException {
        try {
            if (!inputLoginCadastro.getText().equals("") && inputSenhaCadastro.getText().equals("") && inputNome.getText().equals("") && inputIdade.getText().equals("") && inputCPF.getText().equals("")) {
                Cliente atual;
                atual = new Cliente(inputLoginCadastro.getText(), inputSenhaCadastro.getText(), inputNome.getText(), Integer.parseInt(inputIdade.getText()), Long.parseLong(inputCPF.getText()));

                fachada.cadastrarUsuario(atual);
            }

        } catch (CUException a) {
            //exception

        } catch (NumberFormatException a) {
            //exception number

        }

    }

    public void telaHome() {
        GrekHotel.changeScreem("TelaHome");

    }

}

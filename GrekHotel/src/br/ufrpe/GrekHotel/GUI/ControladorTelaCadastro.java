package br.ufrpe.GrekHotel.GUI;

/**
 *
 * @author Eduardo
 */
import br.ufrpe.GrekHotel.Excecoes.CUException;
import br.ufrpe.GrekHotel.Negocio.Sistema;
import br.ufrpe.GrekHotel.Negocio.beans.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    public void cadastar() {
        try {
            if (!inputLoginCadastro.getText().equals("") && !inputSenhaCadastro.getText().equals("") && !inputNome.getText().equals("") && !inputIdade.getText().equals("") && !inputCPF.getText().equals("")) {
                Cliente atual;
                atual = new Cliente(inputLoginCadastro.getText(), inputSenhaCadastro.getText(), inputNome.getText(), Integer.parseInt(inputIdade.getText()), Long.parseLong(inputCPF.getText()));
                fachada.cadastrarUsuario(atual);
                inputCPF.clear();
                inputIdade.clear();
                inputLoginCadastro.clear();
                inputNome.clear();
                inputSenhaCadastro.clear();
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Usuario cadastrado com sucesso!");
                alerta.show();

            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("preencha todos os campos");
                alerta.setHeaderText("Erro ao cadastrar usuario");
                alerta.show();
            }

        } catch (CUException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(a.getMessage());
            alerta.setHeaderText("Erro ao cadastrar usuario");
            alerta.show();

        } catch (NumberFormatException a) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("digite numeros em idade e CPF");
            alerta.setHeaderText("Erro ao cadastrar usuario");
            alerta.show();

        }

    }

    public void telaHome() {
        GrekHotel.changeScreem("TelaUser");

    }

}

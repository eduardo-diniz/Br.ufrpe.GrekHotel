/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import br.ufrpe.GrekHotel.Negocio.Sistema;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.imageio.IIOException;

/**
 *
 * @author fight
 */
public class GrekHotel extends Application {

    private static Stage stage;
    private static Scene userScene;
    private static Scene cadastroScene;
    private static Scene reservaScene;
    private static Scene admScene;
    private static Scene clienteScene;
    private static Scene admReservaScene;
    private static Scene admInicialScene;
    private static Scene admFuncScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("GREK HOTEL");

        Parent fxmlUser = FXMLLoader.load(getClass().getResource("TelaUser.fxml"));
        userScene = new Scene(fxmlUser, 1080, 610);

        /*Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
        cadastroScene = new Scene(fxmlCadastro, 1080, 610);*/
//        Parent fxmlReservas = FXMLLoader.load(getClass().getResource("TelaReservas.fxml"));
//        reservaScene = new Scene(fxmlReservas, 1080, 610);
//        Parent fxmlAdm = FXMLLoader.load(getClass().getResource("TelaAdm.fxml"));
//        admScene = new Scene(fxmlAdm, 1080, 610);
//        Parent fxmlCliente = FXMLLoader.load(getClass().getResource("TelaCliente.fxml"));
        //       clienteScene = new Scene(fxmlCliente, 1080, 610);
//        Parent fxmladmReservaScene = FXMLLoader.load(getClass().getResource("TelaReservaAdm.fxml"));
////        admReservaScene = new Scene(fxmladmReservaScene, 1080, 610);
//        Parent fxmltelaAdmInicial = FXMLLoader.load(getClass().getResource("TelaAdmInicial.fxml"));
//        admInicialScene = new Scene(fxmltelaAdmInicial, 1080, 610);
//
//        Parent fxmltelaAdmFunc = FXMLLoader.load(getClass().getResource("TelaAdmFunc.fxml"));
//        admFuncScene = new Scene(fxmltelaAdmFunc, 1080, 610);
        Sistema fachada = Sistema.getInstance();
        primaryStage.setScene(userScene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(((event) -> {
            event.consume();
            fachada.salvar();
            fachada.salvar();
            primaryStage.close();
            Platform.exit();
            System.exit(0);
        }));

    }

    public static void changeScreem(String scr) throws IOException {
        switch (scr) {
            case "TelaUser":
                stage.setScene(userScene);
                break;
            case "TelaCadastro":
                try {
                    Parent fxmlCadastro = FXMLLoader.load(GrekHotel.class.getResource("TelaCadastro.fxml"));
                    cadastroScene = new Scene(fxmlCadastro, 1080, 610);

                } catch (IOException katarina) {

                }

                stage.setScene(cadastroScene);
                break;
            case "TelaReservas":
                try {
                    Parent fxmlReservas = FXMLLoader.load(GrekHotel.class.getResource("TelaReservas.fxml"));
                    reservaScene = new Scene(fxmlReservas, 1080, 610);
                } catch (IOException caitlyn) {
                }
                stage.setScene(reservaScene);
                break;

            case "TelaAdm":
                try {
                    Parent fxmlAdm = FXMLLoader.load(GrekHotel.class.getResource("TelaAdm.fxml"));
                    admScene = new Scene(fxmlAdm, 1080, 610);
                } catch (IOException sivir) {

                }
                stage.setScene(admScene);
                break;
            case "TelaCliente":

                try {

                    Parent fxmlCliente = FXMLLoader.load(GrekHotel.class.getResource("TelaCliente.fxml"));
                    clienteScene = new Scene(fxmlCliente, 1080, 610);
                } catch (IOException pyke) {

                }
                stage.setScene(clienteScene);
                break;
            case "TelaReservaAdm":

                try {

                    Parent fxmladmReservaScene = FXMLLoader.load(GrekHotel.class.getResource("TelaReservaAdm.fxml"));
                    admReservaScene = new Scene(fxmladmReservaScene, 1080, 610);
                } catch (IOException morgana) {
                }

                stage.setScene(admReservaScene);
                break;
            case "TelaAdmInicial":
                try {
                    Parent fxmltelaAdmInicial = FXMLLoader.load(GrekHotel.class.getResource("TelaAdmInicial.fxml"));
                    admInicialScene = new Scene(fxmltelaAdmInicial, 1080, 610);

                } catch (IOException jax) {

                }
                stage.setScene(admInicialScene);
                break;
            case "TelaFuncAdm":
                try {

                    Parent fxmltelaAdmFunc = FXMLLoader.load(GrekHotel.class.getResource("TelaAdmFunc.fxml"));
                    admFuncScene = new Scene(fxmltelaAdmFunc, 1080, 610);
                } catch (IOException janna) {
                }

                stage.setScene(admFuncScene);

        }
    }

    public static void main(String[] args) {

        launch();
    }

}

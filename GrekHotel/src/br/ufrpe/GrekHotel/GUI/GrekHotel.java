/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrpe.GrekHotel.GUI;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent fxmlUser = FXMLLoader.load(getClass().getResource("TelaUser.fxml"));
        userScene = new Scene(fxmlUser, 840, 640);

        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
        cadastroScene = new Scene(fxmlCadastro, 840, 640);

        Parent fxmlReservas = FXMLLoader.load(getClass().getResource("TelaReservas.fxml"));
        reservaScene = new Scene(fxmlReservas, 840, 640);

        Parent fxmlAdm = FXMLLoader.load(getClass().getResource("TelaAdm.fxml"));
        admScene = new Scene(fxmlAdm, 840, 640);

        /*Parent fxmlCliente = FXMLLoader.load(getClass().getResource(".fxml"));
        clienteScene = new Scene(fxmlUser, 840, 640);*/
        primaryStage.setScene(userScene);
        primaryStage.show();

    }

    public static void changeScreem(String scr) {
        switch (scr) {
            case "TelaUser":
                stage.setScene(userScene);
                break;
            case "TelaCadastro":
                stage.setScene(cadastroScene);
                break;
            case "TelaReservas":
                stage.setScene(reservaScene);
                break;
            case "TelaAdm":
                stage.setScene(admScene);
                break;
            case "TelaCliente":
                stage.setScene(clienteScene);

        }
    }

    public static void main(String[] args) {

        launch();
    }

}

package com.conversor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class resultadoTemperaturaController {

    @FXML
    private Label txtDato;
    private Stage stage;


    public void init(String texto, Stage stage) {
        this.txtDato.setText(texto);
        this.stage = stage;
    }

    public void irMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu-final-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(scene);
            menuFinalController controller = loader.getController();
            controller.init(stage);
            stage.show();
            this.stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


package com.conversor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class menuFinalController {
    private Stage stage;

    public void cerrar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("terminar-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Convertidor");
            stage.setResizable(false);
            stage.setScene(scene);
            terminarController terminarController = loader.getController();
            terminarController.setStage(stage);
            stage.show();
            this.stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void regresarInicio() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("inicio-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Convertidor");
            stage.setResizable(false);
            stage.setScene(scene);
            inicioController inicioController = fxmlLoader.getController();
            inicioController.setStage(stage);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(Stage stage) {
        this.stage = stage;
    }
}
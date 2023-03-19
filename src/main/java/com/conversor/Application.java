package com.conversor;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("inicio-view.fxml"));
            //Scene scene = new Scene(fxmlLoader.load(), 300, 150);
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
    public static void LlenarComboBox(ComboBox<String> llenarcomobobox, ObservableList<String> infocombo){
        llenarcomobobox.setItems(infocombo);
    }

    public static void main(String[] args) {
        launch();
    }
}
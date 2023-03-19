package com.conversor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static com.conversor.Application.LlenarComboBox;


public class temperaturaController {
    @FXML
    public ComboBox cbTemperaturas;
    @FXML
    private inicioController inicioController;

    ObservableList<String> temperaturasList = FXCollections.observableArrayList("Celsius a Fahrenheit", "Celsius a Kelvin", "Fahrenheit a Celsius",
            "Fahrenheit a Kelvin", "Kelvin a Celsius", "Kelvin a Fahrenheit");
    @FXML
    private Button btnAceptar;

    private Stage stage;

    public void listarTemperaturas() {
        LlenarComboBox(cbTemperaturas , temperaturasList);

    }

    public void retroceder() {
        inicioController.show();
        stage.close();
    }


    private void convertir(String indicador) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("temperatura-ingresar-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Convertidor");
            stage.setResizable(false);
            stage.setScene(scene);
            convertidorTemperaturaController controller = loader.getController();
            controller.setStage(stage);
            controller.init(stage, this, indicador);
            stage.show();
            this.stage.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void escogerConvertidor() {
        try {
            String convertidor = (String) cbTemperaturas.getValue();
            System.out.println(convertidor);
            switch (convertidor) {
                case "Celsius a Fahrenheit":
                    convertir("CF");
                    break;

                case "Celsius a Kelvin":
                    convertir("CK");
                    break;

                case "Fahrenheit a Celsius":
                    convertir("FC");
                    break;

                case "Fahrenheit a Kelvin":
                    convertir("FK");
                    break;

                case "Kelvin a Celsius":
                    convertir("KC");
                    break;

                case "Kelvin a Fahrenheit":
                    convertir("KF");
                    break;

                default:
                    System.out.println();
                    throw new Exception("Seleccione una opción");
            }

        }catch (Exception e) {

           generarAlerta("Debe seleccionar una opción");

        }



    }

    public void generarAlerta(String mensaje) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("alerta.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setResizable(false);
            stage.setScene(scene);
            errorController controller = loader.getController();
            controller.init2(stage, this, 2, mensaje);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void init(Stage stage, inicioController inicioController) {
        this.inicioController = inicioController;
        this.stage = stage;
    }

    public void show() {
        stage.show();
    }
}
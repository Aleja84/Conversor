package com.conversor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class convertidorTemperaturaController {
    private Stage stage;
    private temperaturaController temperaturaController;

    private String indicador;

    @FXML
    private TextField txtDato;
    private String textoFinal;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void init(Stage stage, temperaturaController temperaturaController, String indicador) {
        this.temperaturaController = temperaturaController;
        this.stage = stage;
        this.indicador = indicador;
    }

    public void realizarConversion() {
        try{
        double cantidad = 0;
        String texto = txtDato.getText();
        System.out.println(texto);
        double numero = Double.parseDouble(texto);
        System.out.println(numero);
        switch (indicador) {
            case "CF":
                cantidad = (numero * 9/5) + 32;
                this.textoFinal = "La temperatura es " + cantidad + " °F";
                break;

            case "CK":
                cantidad = numero + 273.15;
                this.textoFinal = "La temperatura es " + cantidad + " °K";
                break;

            case "FC":
                cantidad = (numero - 32) * 5/9;
                this.textoFinal = "La temperatura es " + cantidad + " °C";
                break;

            case "FK":
                cantidad = (numero - 32) * 5/9 + 273.15;
                this.textoFinal = "La temperatura es " + cantidad + " °K";
                break;

            case "KC":
                cantidad = numero - 273.15;
                this.textoFinal = "La temperatura es " + cantidad + " °C";
                break;

            case "KF":
                cantidad = (numero - 273.15) * 9/5 + 32;
                this.textoFinal = "La temperatura es " + cantidad + " °F";
                break;

            default:
                break;
        }
        System.out.println(cantidad);
        enviarTemperatura();

        }catch (NumberFormatException e){
            generarAlerta("Debe ingresar un número");
        }
    }

    private void enviarTemperatura() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("temperatura-resultado-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Convertidor");
            stage.setResizable(false);
            stage.setScene(scene);
            resultadoTemperaturaController controller = loader.getController();
            controller.init(this.textoFinal, stage);
            stage.show();
            this.stage.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void retroceder() {
        temperaturaController.show();
        stage.close();
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
            controller.init3(stage, this, 3, mensaje);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void show() {
        stage.show();
    }
}



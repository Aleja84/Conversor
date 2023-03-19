package com.conversor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class errorController {

    private Stage stage;
    @FXML
    private inicioController inicioController;
    private temperaturaController temperaturaController;

    private int indicador;
    @FXML
    private Label lblMensaje;
    private convertidorTemperaturaController convertidorTemperaturaController;
    private monedasController monedasController;
    private convertidorMonedasController convertidorMonedasController;

    public void retroceder() {
        switch (indicador){
            case 1:
                inicioController.show();
                stage.close();
                break;
            case 2:
                temperaturaController.show();
                stage.close();
                break;
            case 3:
                convertidorTemperaturaController.show();
                stage.close();
                break;
            case 4:
                monedasController.show();
                stage.close();
                break;
            case 5:
                convertidorMonedasController.show();
                stage.close();
                break;
            default:
                break;
        }
    }
    public void init(Stage stage, inicioController inicioController, int indicador, String mensaje) {
        this.inicioController = inicioController;
        this.stage = stage;
        this.indicador = indicador;
        this.lblMensaje.setText(mensaje);
    }

    public void init2(Stage stage, temperaturaController temperaturaController, int indicador, String mensaje) {
        this.temperaturaController = temperaturaController;
        this.stage = stage;
        this.indicador = indicador;
        this.lblMensaje.setText(mensaje);
    }

    public void init3(Stage stage, convertidorTemperaturaController convertidorTemperaturaController, int indicador, String mensaje) {
        this.convertidorTemperaturaController = convertidorTemperaturaController;
        this.stage = stage;
        this.indicador = indicador;
        this.lblMensaje.setText(mensaje);

    }



    public void init4(Stage stage, monedasController monedasController, int indicador, String mensaje) {
        this.monedasController = monedasController;
        this.stage = stage;
        this.indicador = indicador;
        this.lblMensaje.setText(mensaje);
    }

    public void init5(Stage stage, convertidorMonedasController convertidorMonedasController, int indicador, String mensaje) {
        this.convertidorMonedasController = convertidorMonedasController;
        this.stage = stage;
        this.indicador = indicador;
        this.lblMensaje.setText(mensaje);
    }
}

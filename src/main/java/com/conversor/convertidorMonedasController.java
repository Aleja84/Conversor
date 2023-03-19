package com.conversor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class convertidorMonedasController {
    private Stage stage;
    private monedasController monedasController;

    private String indicador;

    @FXML
    private TextField txtDato;
    private String textoFinal;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void init(Stage stage, monedasController monedasController, String indicador) {
        this.monedasController = monedasController;
        this.stage = stage;
        this.indicador = indicador;
    }

    public void realizarConversion() {
        try{
        double cantidad = 0;
        String texto = txtDato.getText();
        System.out.println(texto);
        double numero = Double.parseDouble(texto);
        if(numero < 0){
            throw new Exception("Número negativo");
        }
        System.out.println(numero);
        switch (indicador) {
            case "SD":
                cantidad = (numero * 0.27);
                this.textoFinal = "Tienes " + cantidad + " dolares";
                break;

            case "SE":
                cantidad = (numero * 0.25);
                this.textoFinal = "Tienes " + cantidad + " euros";
                break;

            case "SL":
                cantidad = (numero * 0.22);
                this.textoFinal = "Tienes " + cantidad + " libras esterlinas";
                break;

            case "SY":
                cantidad = (numero * 35.30);
                this.textoFinal = "Tienes " + cantidad + " yenes";
                break;

            case "SW":
                cantidad = (numero * 350.39);
                this.textoFinal = "Tienes " + cantidad + " wones coreanos";
                break;

            case "DS":
                cantidad = (numero * 3.74);
                this.textoFinal = "Tienes " + cantidad + " soles";
                break;

            case "ES":
                cantidad = (numero * 4.03);
                this.textoFinal = "Tienes " + cantidad + " soles";
                break;

            case "LS":
                cantidad = (numero * 4.55);
                this.textoFinal = "Tienes " + cantidad + " soles";
                break;

            case "YS":
                cantidad = (numero * 0.028);
                this.textoFinal = "Tienes " + cantidad + " soles";
                break;

            case "WS":
                cantidad = (numero * 0.0029);
                this.textoFinal = "Tienes " + cantidad + " soles";
                break;

            default:
                break;
        }
        System.out.println(cantidad);
        enviarCantidad();

        }catch (NumberFormatException e){
            generarAlerta("Debe ingresar un número");
        }catch (Exception e){
            generarAlerta("Ingrese un número positivo");
        }
    }

    private void enviarCantidad() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("monedas-resultado-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Convertidor");
            stage.setResizable(false);
            stage.setScene(scene);
            resultadoMonedasController controller = loader.getController();
            controller.init(this.textoFinal, stage);
            stage.show();
            this.stage.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void retroceder() {
        monedasController.show();
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
            controller.init5(stage, this, 5, mensaje);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void show() {
        stage.show();
    }
}



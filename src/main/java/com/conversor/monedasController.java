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


public class monedasController  {
    @FXML
    public ComboBox cbTipoCambio;

    ObservableList<String> opcionesList = FXCollections.observableArrayList("Soles a Dólares" , "Soles a Euros", "Soles a Libras Esterlinas", "Soles a Yen Japonés",
                                                                                 "Soles a Won sul-coreano", "Dólares a Soles", "Euros a Soles", "Libras Esterlinas a Soles",
                                                                                 "Yen Japonés a Soles", "Won sul-coreano a Soles");
    @FXML
    private Stage stage;
    @FXML
     private inicioController inicioController;

    public void listarTipoCambio() {
        LlenarComboBox(cbTipoCambio , opcionesList);

    }

   /* public void retroceder(ActionEvent actionEvent) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("inicio-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Convertidor");
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnCancelar.getScene().getWindow();
            myStage.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }*/

    private void convertir(String indicador) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("monedas-ingresar-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Convertidor");
            stage.setResizable(false);
            stage.setScene(scene);
            convertidorMonedasController controller = loader.getController();
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
            String convertidor = (String) cbTipoCambio.getValue();
            System.out.println(convertidor);
            switch (convertidor) {

                case "Soles a Dólares":
                    convertir("SD");
                    break;

                case "Soles a Euros":
                    convertir("SE");
                    break;

                case "Soles a Libras Esterlinas":
                    convertir("SL");
                    break;

                case "Soles a Yen Japonés":
                    convertir("SY");
                    break;

                case "Soles a Won sul-coreano":
                    convertir("SW");
                    break;

                case "Dólares a Soles":
                    convertir("DS");
                    break;

                case "Euros a Soles":
                    convertir("ES");
                    break;

                case "Libras Esterlinas a Soles":
                    convertir("LS");
                    break;

                case "Yen Japonés a Soles":
                    convertir("YS");
                    break;

                case "Won sul-coreano a Soles":
                    convertir("WS");
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
            controller.init4(stage, this, 4, mensaje);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void retroceder() {
         inicioController.show();
         stage.close();
    }

    public void init(Stage stage, inicioController inicioController) {
        this.inicioController = inicioController;
        this.stage = stage;
    }

    public void show() {
        stage.show();
    }
}
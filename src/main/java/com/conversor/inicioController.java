package com.conversor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.conversor.Application.LlenarComboBox;

public class inicioController  {
    @FXML
    private ComboBox cbOpciones;
    @FXML
    private Button btnAceptar;
    ObservableList<String> opcionesList = FXCollections.observableArrayList("Conversor de Monedas" , "Conversor de Temperatura");
    private Stage stage;

    public void listarOpciones(Event event) {
       LlenarComboBox(cbOpciones , opcionesList);

    }

    public void escogerConvertidor(ActionEvent actionEvent) {
        try {
            String convertidor = (String) cbOpciones.getValue();
            System.out.println(convertidor);
            if(convertidor == "Conversor de Monedas"){
                mostrarMenu(actionEvent, "monedas-view.fxml");

            }else {
                if(convertidor == "Conversor de Temperatura"){
                    mostrarMenu(actionEvent, "temperatura-view.fxml");
                }else{
                    throw new Exception("Seleccione una opción");
                }
            }

        }catch (Exception e) {
            generarAlerta("Debe seleccionar una opción");
            //Alert mensaje = new Alert(Alert.AlertType.WARNING);
            //mensaje.setTitle("Alerta");
            //mensaje.setContentText("Seleccione una opción");
            //mensaje.showAndWait();

            //e.printStackTrace();
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
            controller.init(stage, this,1, mensaje);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void mostrarMenu(ActionEvent actionEvent , String menu) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(menu));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Convertidor");
            stage.setResizable(false);
            stage.setScene(scene);
            if(menu == "monedas-view.fxml"){
                monedasController controller = loader.getController();
                controller.init(stage, this);
            }else {
               temperaturaController controller = loader.getController();
               controller.init(stage, this);
            }
            stage.show();
            this.stage.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        stage.show();
    }
}
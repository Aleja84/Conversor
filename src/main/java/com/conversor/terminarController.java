package com.conversor;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class terminarController {
    private Stage stage;

    public void cerrar() {
        this.stage.close();
    }

    public void setStage(Stage stage) {
        this.stage=stage;
    }
}

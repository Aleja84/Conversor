module com.conversor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.conversor to javafx.fxml;
    exports com.conversor;
}
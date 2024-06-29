module com.example.sistemaclinico {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.sistemaClinico to javafx.fxml;
    exports com.example.sistemaClinico;
    exports com.example.sistemaClinico.controlador;
    opens com.example.sistemaClinico.controlador to javafx.fxml;

}
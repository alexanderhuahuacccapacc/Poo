package com.example.sistemaClinico.controlador;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuController implements Initializable {
    public BorderPane bp;
    public AnchorPane ap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void home(MouseEvent mouseEvent) {
        bp.setCenter(ap);
    }

    public void clinica(MouseEvent mouseEvent) {
        loadPage("/com/example/sistemaClinico/Clinica-view");
    }


    private void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        } catch (IOException e) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, e);
        }
        bp.setCenter(root);
    }

    public void cita(MouseEvent mouseEvent) {
        loadPage("/com/example/sistemaClinico/Cita-view");
    }
}

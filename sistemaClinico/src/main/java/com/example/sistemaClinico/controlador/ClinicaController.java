package com.example.sistemaClinico.controlador;

import com.example.sistemaClinico.modelo.dominio.Clinica;
import com.example.sistemaClinico.modelo.dao.ClinicaDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClinicaController implements Initializable {


    @FXML
    private TableView<Clinica> tablaClinicas;
    @FXML
    private TableColumn<Clinica, String> colnombClinica;
    @FXML
    public TableColumn<Clinica, String> colempleados;
    @FXML
    public TableColumn<Clinica, String> colencargado;
    @FXML
    private TextField nombClinicaText;
    @FXML
    private TextField empleadosText;
    @FXML
    private TextField encargadoText;
    @FXML
    public Button guardarBtn;
    Integer idClinica = 0;

    private ObservableList<Clinica> clinicasObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listarClinicas();
    }



    public void listarClinicas() {
        tablaClinicas.getItems().clear();
        ClinicaDAO clinicaDAO =new ClinicaDAO();
        List<Clinica> clinicas = clinicaDAO.listarClinicas();
        clinicasObservableList.addAll(clinicas);
        colnombClinica.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombClinica()));
        colempleados.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleados()));
        colencargado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEncargado()));
        tablaClinicas.setItems(clinicasObservableList);


        tablaClinicas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        seleccionarClinica(newValue);
                    }
                }
        );


    }


    public void onInsertarButtonClick(ActionEvent actionEvent) {
        ClinicaDAO clinicaDao = new ClinicaDAO();
        Clinica clinica = new Clinica();
        if (idClinica == 0) {
            clinica.setNombClinica(nombClinicaText.getText());
            clinica.setEmpleados(empleadosText.getText());
            clinica.setEncargado(encargadoText.getText());
            clinicaDao.insertarClinica(clinica);
        } else {
            clinica.setIdClinica(idClinica);
            clinica.setNombClinica(nombClinicaText.getText());
            clinica.setEmpleados(empleadosText.getText());
            clinica.setEncargado(encargadoText.getText());
            clinicaDao.actulizarClinica(clinica);
        }
        idClinica = 0;
        onLimpiarButtonClick(null);
        listarClinicas();
        guardarBtn.setText("Guardar");
    }


    public void onLimpiarButtonClick(ActionEvent actionEvent) {
        nombClinicaText.clear();
        empleadosText.clear();
        encargadoText.clear();
        //guardarBtn.setText("Guardar");
        //idClinica = 0;
    }

    public void onSeleccionarButtonClick(ActionEvent actionEvent) {
        ClinicaDAO clinicaDAO = new ClinicaDAO();
        Clinica clinica = clinicaDAO.clinicaPorId(idClinica);
        nombClinicaText.setText(clinica.getNombClinica());
        empleadosText.setText(clinica.getEmpleados());
        encargadoText.setText(clinica.getEncargado());
        guardarBtn.setText("Guardar Editar");
    }

    private void seleccionarClinica(Clinica clinica) {
        idClinica = clinica.getIdClinica();
    }

    public void eliminarButtonClick(ActionEvent actionEvent) {
        ClinicaDAO clinicaDAO = new ClinicaDAO();
        clinicaDAO.eliminarClinicaPorId(idClinica);
        listarClinicas();
    }
}

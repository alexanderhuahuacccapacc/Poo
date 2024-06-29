package com.example.sistemaClinico.controlador;

import com.example.sistemaClinico.modelo.dominio.Cita;
import com.example.sistemaClinico.modelo.dao.CitaDAO;
import com.example.sistemaClinico.modelo.dao.ClinicaDAO;
import com.example.sistemaClinico.modelo.dominio.Clinica;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CitaController implements Initializable {



    @FXML
    private TableView<Cita> tablaCitas;
    @FXML
    private TableColumn<Cita, String> colnombresPaciente;
    @FXML
    public TableColumn<Cita, String> colapellidosPaciente;
    @FXML
    public TableColumn<Cita, String> colGenero;
    @FXML
    public TableColumn<Cita, String> coledad;

    @FXML
    private TextField nombresPacienteText;
    @FXML
    private TextField apellidosPacienteText;
    @FXML
    private TextField GeneroText;
    @FXML
    private TextField edadText;
    @FXML
    private ComboBox categoriaBox;


    @FXML
    private TableColumn<Cita, Clinica> colClinica;

    @FXML
    private ComboBox<String> clinicaBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        llenarComboBoxClinicas();
        listarCitas();


        // Asignar el valor de la clínica seleccionada a la tabla
        colClinica.setCellValueFactory(new PropertyValueFactory<>("clinica"));

        // Personalizar la visualización de la información de la clínica
        colClinica.setCellFactory(column -> {
            return new TableCell<Cita, Clinica>() {
                @Override
                protected void updateItem(Clinica clinica, boolean empty) {
                    super.updateItem(clinica, empty);
                    if (empty || clinica == null) {
                        setText(null);
                    } else {
                        setText(clinica.getNombClinica()); // Ajusta según la propiedad que quieras mostrar
                    }
                }
            };
        });

        // Otro código de inicialización...
    }



    public Button guardarBtn;
    Integer idCita = 0;
    private ObservableList<Cita> citasObservableList = FXCollections.observableArrayList();
    @FXML




    private void llenarComboBoxClinicas() {
        ClinicaDAO clinicaDAO = new ClinicaDAO();
        List<Clinica> clinicas = clinicaDAO.listarClinicas();

        List<String> nombresClinicas = clinicas.stream().map(Clinica::getNombClinica).collect(Collectors.toList());

        clinicaBox.setItems(FXCollections.observableArrayList(nombresClinicas));
    }
    public void listarCitas() {
        tablaCitas.getItems().clear();
        CitaDAO citaDAO = new CitaDAO();
        List<Cita> citas = citaDAO.listarCitas();
        citasObservableList.addAll(citas);

        colnombresPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombresPaciente()));
        colapellidosPaciente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidosPaciente()));
        colGenero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
        coledad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEdad()));
        tablaCitas.setItems(citasObservableList);

        tablaCitas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        seleccionarCita(newValue);
                    }
                }
        );

    }

    private void seleccionarCita(Cita cita) {
        idCita = cita.getCodigo();
    }

    public void onInsertarButtonClick(ActionEvent actionEvent) {
        CitaDAO citaDAO = new CitaDAO();
        Cita cita = new Cita();
        Clinica clinicaSeleccionada = obtenerClinicaSeleccionada();
        if (idCita == 0) {
            cita.setNombresPaciente(nombresPacienteText.getText());
            cita.setApellidosPaciente(apellidosPacienteText.getText());
            cita.setGenero(GeneroText.getText());
            cita.setEdad(edadText.getText());
            citaDAO.insertarCita(cita);
        } else {
            cita.setCodigo(idCita);
            cita.setNombresPaciente(nombresPacienteText.getText());
            cita.setApellidosPaciente(apellidosPacienteText.getText());
            cita.setGenero(GeneroText.getText());
            cita.setEdad(edadText.getText());
            citaDAO.actualizarCita(cita);  // Cambia a llamar al método actualizarCita
        }
        idCita = 0;
        onLimpiarButtonClick(null);
        listarCitas();
        guardarBtn.setText("Guardar");
    }
    private Clinica obtenerClinicaSeleccionada() {
        String nombreClinica = clinicaBox.getValue();
        ClinicaDAO clinicaDAO = new ClinicaDAO();
        return clinicaDAO.obtenerClinicaPorNombre(nombreClinica);
    }

    public void onLimpiarButtonClick(ActionEvent actionEvent) {
        nombresPacienteText.clear();
        apellidosPacienteText.clear();
        GeneroText.clear();
        edadText.clear();
    }

    public void onSeleccionarButtonClick(ActionEvent actionEvent) {
        CitaDAO citaDAO = new CitaDAO();
        Cita cita = citaDAO.citaPorCodigo(idCita);
        nombresPacienteText.setText(cita.getNombresPaciente());
        apellidosPacienteText.setText(cita.getApellidosPaciente());
        GeneroText.setText(cita.getGenero());
        edadText.setText(cita.getEdad());
        guardarBtn.setText("Guardar Editar");
    }

    public void eliminarButtonClick(ActionEvent actionEvent) {
        CitaDAO citaDAO = new CitaDAO();
        citaDAO.eliminarCitaPorCodigo(idCita);
        listarCitas();
    }
}

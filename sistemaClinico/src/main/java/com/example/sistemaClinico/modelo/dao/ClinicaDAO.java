package com.example.sistemaClinico.modelo.dao;
import com.example.sistemaClinico.modelo.dominio.Clinica;
import com.example.sistemaClinico.util.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClinicaDAO {
    private final ConexionDB conexionDB;
    private PreparedStatement preparedStatement;
    public ClinicaDAO() {
        this.conexionDB = new ConexionDB();
    }

    public void creaTablaClinica() {
        String sqlTablaClinica = "CREATE TABLE IF NOT EXISTS clinica (idClinica integer primary key,nombClinica text,empleados text, encargado text);";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(sqlTablaClinica);
            preparedStatement.execute();
            System.out.println("Tabla de Clinica creada o Actualizada correctamente");
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }


    public List<Clinica> listarClinicas() {
        this.creaTablaClinica();
        List<Clinica> clinicas = new ArrayList<>();
        String consultaListarClinicas = "select idClinica, nombClinica, empleados, encargado from clinica";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaListarClinicas);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Clinica clinica = new Clinica();
                clinica.setIdClinica(resultSet.getInt(1));
                clinica.setNombClinica(resultSet.getString(2));
                clinica.setEmpleados(resultSet.getString(3));
                clinica.setEncargado(resultSet.getString(4));
                clinicas.add(clinica);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("Clinica listada correctamente");
        return clinicas;
    }


    public boolean insertarClinica(Clinica clinica) {
        creaTablaClinica();
        String consultaInsertarClinica = "INSERT INTO clinica(nombClinica,empleados,encargado) VALUES(?,?,?)";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarClinica);
            preparedStatement.setString(1, clinica.getNombClinica());
            preparedStatement.setString(2, clinica.getEmpleados());
            preparedStatement.setString(3, clinica.getEncargado());
            preparedStatement.execute();
            System.out.println("Clinica Insertada correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Clinica clinicaPorId(Integer idClinica) {
        creaTablaClinica();
        String consultaClinicaPorIdClinica = "select idClinica, nombClinica, empleados, encargado from clinica where idClinica =?";
        Clinica clinica = new Clinica();
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaClinicaPorIdClinica);
            preparedStatement.setInt(1, idClinica);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                clinica.setIdClinica(resultSet.getInt(1));
                clinica.setNombClinica(resultSet.getString(2));
                clinica.setEmpleados(resultSet.getString(3));
                clinica.setEncargado(resultSet.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("cliente Por Id de id = " + idClinica + " devuelto correctamente");
        return clinica;
    }


    public boolean actulizarClinica(Clinica clinica) {
        creaTablaClinica();
        String consultaInsertarClinica = "UPDATE clinica SET nombClinica =?,empleados=?,encargado=? WHERE idClinica=?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarClinica);
            preparedStatement.setString(1, clinica.getNombClinica());
            preparedStatement.setString(2, clinica.getEmpleados());
            preparedStatement.setString(3, clinica.getEncargado());
            preparedStatement.setInt(4, clinica.getIdClinica());
            preparedStatement.execute();
            System.out.println("Clinica actualisada correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void eliminarClinicaPorId(int idClinica) {
        creaTablaClinica();
        String consultaClinicaPorId = "delete  from clinica where idClinica =?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaClinicaPorId);
            preparedStatement.setInt(1, idClinica);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("Eliminacion de Clinica correcta");
    }
    public Clinica obtenerClinicaPorNombre(String nombreClinica) {
        creaTablaClinica(); // Asegúrate de tener este método para crear la tabla si no existe
        String consultaClinicaPorNombre = "SELECT idClinica, nombClinica, empleados, encargado FROM clinica WHERE nombClinica = ?";

        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaClinicaPorNombre);
            preparedStatement.setString(1, nombreClinica);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Clinica clinica = new Clinica();
                clinica.setIdClinica(resultSet.getInt("idClinica"));
                clinica.setNombClinica(resultSet.getString("nombClinica"));
                clinica.setEmpleados(resultSet.getString("empleados"));
                clinica.setEncargado(resultSet.getString("encargado"));
                return clinica;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Si no se encuentra ninguna clínica con ese nombre, puedes devolver null o lanzar una excepción, dependiendo de tus necesidades.
        return null;
    }

}

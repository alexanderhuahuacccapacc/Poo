package com.example.sistemaClinico.modelo.dao;
import com.example.sistemaClinico.modelo.dominio.Cita;
import com.example.sistemaClinico.util.ConexionDB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO
{
    private final ConexionDB conexionDB;
    private PreparedStatement preparedStatement;

    public CitaDAO() {
        this.conexionDB = new ConexionDB();
    }

    public void creaTablaCita() {
        String sqlTablaCita = "create table if not exists cita( codigo int primary key, nombresPaciente text ,apellidosPaciente text ,Genero text ,edad text);";

        try {
            preparedStatement = conexionDB.connection.prepareStatement(sqlTablaCita);
            preparedStatement.execute();
            System.out.println("Tabla Cita creada o actualizada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cita> listarCitas() {
        creaTablaCita();
        List<Cita> citas = new ArrayList<>();
        String consultaListarcitas = "select codigo, nombresPaciente,apellidosPaciente,Genero,edad from cita";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaListarcitas);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cita cita = new Cita();
                cita.setCodigo(resultSet.getInt(1));
                cita.setNombresPaciente(resultSet.getString(2));
                cita.setApellidosPaciente(resultSet.getString(3));
                cita.setGenero(resultSet.getString(4));
                cita.setEdad(resultSet.getString(5));

                citas.add(cita);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("Listar citas correctamente");
        return citas;
    }

    public boolean insertarCita(Cita cita) {
        System.out.println(cita.toString());
        creaTablaCita();
        String consultaInsertarCita = "INSERT INTO cita(nombresPaciente, apellidosPaciente, Genero, edad, idClinica) VALUES(?,?,?,?,?)";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarCita);
            preparedStatement.setString(1, cita.getNombresPaciente());
            preparedStatement.setString(2, cita.getApellidosPaciente());
            preparedStatement.setString(3, cita.getGenero());
            preparedStatement.setString(4, cita.getEdad());
            preparedStatement.setInt(5, cita.getIdClinica());

            preparedStatement.execute();
            System.out.println("Insertar cita correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cita citaPorCodigo(Integer codigo) {
        creaTablaCita();
        String consultarCitaPorId = "select codigo, nombresPaciente, apellidosPaciente, Genero, edad from cita where codigo =?";
        Cita cita = new Cita();
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultarCitaPorId);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                cita.setCodigo(resultSet.getInt(1));
                cita.setNombresPaciente(resultSet.getString(2));
                cita.setApellidosPaciente(resultSet.getString(3));
                cita.setGenero(resultSet.getString(4));
                cita.setEdad(resultSet.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("clinicaPorId de id = " + codigo + " devuelto correctamente");
        return cita;
    }

    public boolean actualizarCita(Cita cita) {
        creaTablaCita();
        String consultaInsertarClinica = "UPDATE cita SET nombresPaciente=?, apellidosPaciente=?, Genero=?, edad=? WHERE codigo=?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaInsertarClinica);
            preparedStatement.setString(1, cita.getNombresPaciente());
            preparedStatement.setString(2, cita.getApellidosPaciente());
            preparedStatement.setString(3, cita.getGenero());
            preparedStatement.setString(4, cita.getEdad());
            preparedStatement.execute();
            System.out.println("Actualizar producto correctamente");
            this.conexionDB.cerrarConexionDB();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarCitaPorCodigo(Integer codigo) {
        creaTablaCita();
        String consultaCitaPorCodigo = "delete  from cita where codigo=?";
        try {
            preparedStatement = conexionDB.connection.prepareStatement(consultaCitaPorCodigo);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conexionDB.cerrarConexionDB();
        System.out.println("eliminacion correcta");
    }

}

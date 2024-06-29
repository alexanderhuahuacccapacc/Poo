package com.example.sistemaClinico.modelo.dominio;

import java.util.Date;

public class Cita extends Clinica{
    private int codigo;
    private String nombresPaciente;
    private String apellidosPaciente;
    private String Genero;
    private String edad;
    private Clinica clinica;

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }





    public Cita() {
    }


    public Cita(int codigo, String nombresPaciente, String apellidosPaciente, String Genero, String edad) {
        this.codigo = codigo;
        this.nombresPaciente = nombresPaciente;
        this.apellidosPaciente = apellidosPaciente;
        this.Genero = Genero;
        this.edad = edad;

    }

   // public Cita(String string) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    //public Clinica getIdClinica() {
     //   return idClinica;
    //}



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombresPaciente() {
        return nombresPaciente;
    }

    public void setNombresPaciente(String nombresPaciente) {
        this.nombresPaciente = nombresPaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

}

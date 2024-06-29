package com.example.sistemaClinico.modelo.dominio;

public class Clinica {
    private int idClinica;
    private String nombClinica;
    private String empleados;
    private String encargado;

    public Clinica() {
    }


    //sobrecarga de metodos
    private Clinica(int idClin) {
        this.idClinica=idClin;
    }

    public Clinica(int idClinica, String nombClinica, String empleados, String encargado) {
        this.idClinica = idClinica;
        this.nombClinica = nombClinica;
        this.empleados = empleados;
        this.encargado = encargado;
    }

    public int getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
    }

    public String getNombClinica() {
        return nombClinica;
    }

    public void setNombClinica(String nombClinica) {
        this.nombClinica = nombClinica;
    }

    public String getEmpleados() {
        return empleados;
    }

    public void setEmpleados(String empleados) {
        this.empleados = empleados;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
}

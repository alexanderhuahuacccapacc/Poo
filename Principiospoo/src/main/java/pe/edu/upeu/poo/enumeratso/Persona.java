/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.poo.enumeratso;

/**
 *
 * @author 51960
 */
//nombre de los enum deben estar en mayusculas
enum GENERO{Masculino, Femenino}
enum ESTAD_CIVIL{Casado, Divorciado, Soltero}
public class Persona {
    GENERO g=GENERO.Femenino;
    public static void main (String[] args){
        System.err.println("GENERO: "+GENERO.Masculino);
       for(ESTAD_CIVIL g:ESTAD_CIVIL.values()){
           System.err.println(g);
       } 
    }
}

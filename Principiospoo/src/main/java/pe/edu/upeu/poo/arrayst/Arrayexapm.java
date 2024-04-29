/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.poo.arrayst;

/**
 *
 * @author 51960
 */
import java.util.ArrayList;
import java.util.List;
public class Arrayexapm {
    static List <Persona>  personas=new ArrayList<>();
    
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setdni ("414651451");
        p.setNombre("Alexander");
        p.setEdad(23);
        personas.add(p);
        p=new Persona ();
        p.setdni("1256558");
        p.setEdad(25);
        p.setNombre("Alexander");
        personas.add(p);
        
        System.out.println("DNI\t\tNombre\t\tEdad");
        for (Persona px : personas) {
            System.err.println(px.getDni()+"\t"+px.getNombre()+"\t\t"+px.getEdad());
           // System.out.println(px.getDni()+"\t"+px.getNombre()"\t\t"+px.getEdad());
        }
        //Eliminar
        personas.remove(1);
        System.out.println("DNI\t\tNombres\t\tEdad");
        for (Persona px: personas) {
            System.out.println(px.getDni()+"\t"+px.getNombre()+"\t\t"+px.getEdad());
            
            
        }
    }
}

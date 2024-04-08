/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.poo.claseinterna;

/**
 *
 * @author 51960
 */
public class Principal {
    public static void main (String[] args){
        Mama ma=new Mama();
        System.err.println("La mama provee "+ma.alimento);
        Mama.bebe bb=ma.new bebe();
        System.err.println("Su bebe tiene un peso "+bb.Peso+"Kg");
    }
}

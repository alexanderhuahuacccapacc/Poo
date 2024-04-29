/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.poo.herencia;

import javax.print.DocFlavor;

/**
 *
 * @author 51960
 */
public class Car extends Vehicle {
    private String modelo = "Mustang";
    
    public static void main(String[] args){
        Car myCar = new Car();
        myCar.sonido();
        System.out.println(myCar.marca+""+myCar.modelo);
    }
}

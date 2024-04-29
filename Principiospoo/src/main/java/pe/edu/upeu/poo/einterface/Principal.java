/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.poo.einterface;

/**
 *
 * @author 51960
 */
public class Principal {
    public static void main(String[] args) {
        Animal dd=new Loro();
        dd.emitirSonido();
        dd.dormir();
        System.out.println(dd.cantar("Alex"));
    }
}

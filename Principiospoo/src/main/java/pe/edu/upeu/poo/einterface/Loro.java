/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.poo.einterface;

/**
 *
 * @author 51960
 */
public class Loro implements Animal{
    @Override
    public void emitirSonido(){
        System.out.println("Hoa manito....aprende pues");
    }
    @Override
    public void dormir(){
        System.out.println("zzzz...zz.z.z.z.z.z.zz..z.z.z.");
    }
    @Override
    public String cantar(String nombre){
        System.out.println("Alexander..............");
        return "El loroto "+nombre+" canta: lalalalalalllaalalla";
    }
    
}

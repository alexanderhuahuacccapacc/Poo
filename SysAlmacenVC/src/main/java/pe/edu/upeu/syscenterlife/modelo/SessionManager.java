/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.syscenterlife.modelo;

import lombok.Data;

/**
 *
 * @author Datos
 */
@Data
//Siempre que este @data siempre es en modelo 
public class SessionManager {

    static SessionManager instance;
    Long userId;
    String userName;

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
}

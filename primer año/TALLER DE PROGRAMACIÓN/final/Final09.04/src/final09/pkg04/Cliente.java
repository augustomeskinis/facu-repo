/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final09.pkg04;

/**
 *
 * @author Augusto
 */
public class Cliente {
    private int DNI;
    private String nombre;
    private String apellido;
    
    public Cliente (int unDNI, String unNombre, String unApellido){
        this.DNI=unDNI;
        this.nombre=unNombre;
        this.apellido=unApellido;
    }

    public int getDNI() {
        return DNI;
    }
    
    
    
    
}

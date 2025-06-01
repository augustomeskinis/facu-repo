/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasando;

/**
 *
 * @author Augusto
 */
public class Proyecto {
    private String nombre;
    private int codigo;
    private String nombreDirector;
    private int df=50;
    private int dl=0;
    private Investigador vector []; // java inicializa en null
    
    public Proyecto (String unNombre, int unCodigo, String unDirector){
        nombre=unNombre;
        codigo=unCodigo;
        nombreDirector=unDirector;
        vector = new Investigador[df];
    }
    
    public void agregarInvestigador (Investigador unInvestigador){
        if (this.dl<this.df){
            vector[dl]=unInvestigador;
            dl++;
        }
    }
    
    private double dineroTotalOtorgado(){
        double aux=0;
        for(int i=0; i<dl; i++){
            aux+= this.vector[i].getDineroOtorgado();
        }
        return aux;
    }
    
     public void otorgarTodos(String unNombre) {
        int contador = 0;
        while ((contador < dl) && (!vector[contador].getNombreCompleto().equals(unNombre))) {
            contador++;
        }
        
        if (contador < dl) {
            vector[contador].otorgarSubsidios();
        } else {
            System.out.println("No se encontró ningún investigador con el nombre: " + unNombre);
        }
    }

    
    
    public String toString(){
        String aux = "Nombre del proyecto: " + this.nombre + ", código del proyecto: " + this.codigo + "\n" + 
                "Dinero total otorgado del proyecto " + this.dineroTotalOtorgado()  + "\n";
        for (int i=0; i<dl; i++) {
            aux += "Nombre del investigador: " + this.vector[i].getNombreCompleto() +
                    ", categoria" + this.vector[i].getCategoria() + ", especialidad: " +
                    this.vector[i].getEspecialidad() + ", dinero total otorgado: " + this.vector[i].getDineroOtorgado()
                    + "\n";
        } 
        return aux;
    }
    

}

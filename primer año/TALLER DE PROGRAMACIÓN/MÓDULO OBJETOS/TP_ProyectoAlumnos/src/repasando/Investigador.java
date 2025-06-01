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
public class Investigador {
    private String nombreCompleto;
    private int categoria;
    private String especialidad;
    private int df = 5;
    private int dl=0;
    private Subsidio vector [];
    
    
    public Investigador (String unNombre, int unaCategoria, String unaEspecialidad){
        nombreCompleto=unNombre;
        categoria=unaCategoria;
        especialidad=unaEspecialidad;
        vector = new Subsidio[df];
    }
    
    public void agregarSubsidio(Subsidio unSubsidio){
        if (this.dl<this.df){
            vector[dl]=unSubsidio;
            dl++;
        }
    }
    
    public void otorgarSubsidios(){
        for (int i=0; i<dl; i++){
            if(this.vector[i].isOtorgado()==false){
                this.vector[i].setOtorgado(true);
            }
        }
    }
    
    public double getDineroOtorgado(){
        double aux=0;
        for(int i=0; i<dl;i++){
            if(this.vector[i].isOtorgado()==true){
                aux += this.vector[i].getMontoPedido();
            }
        }
        return aux;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    
    
    
}

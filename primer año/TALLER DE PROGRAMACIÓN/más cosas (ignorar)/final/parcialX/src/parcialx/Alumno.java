/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialx;

/**
 *
 * @author Augusto
 */
public abstract class Alumno {
    private int dni;
    private String nombre;
    private Materia [] vector; // java inicializa un null
    private int df;
    private int dl=0;
    
    public Alumno (int unDni, String unNombre, int N){
        this.dni= unDni;
        this.nombre= unNombre;
        this.df=N;
        vector = new Materia [df];
    }
    
    public void agregarMateria (Materia M){
        vector[dl]=M;
        dl++;
    }
    
    public String estaGraduado(int N){
        boolean aux=false; int i=0;
        while ((i<dl)&&(aux==false)){
            if(vector[i].getNombre().equals("Tesis")) {
                aux=true;
            }
            else {
             i++; }
         }
        String aux2 = "No graduado";
        if((dl>=N)&&(aux)){
            aux2="Graduado";
        }
        return aux2;
    }
    
    public String toString (){
        String aux = "Nombre del alumno: " + this.nombre + "DNI del alumno: " + this.dni + "\n";
        aux += "MATERIAS APROBADAS DEL ALUMNO: ";
        for (int i=0; i<dl;i++) {
            aux+= vector[i].toString() + "\n";
        }
        aux += this.estaGraduado(2) + "\n";
        
        return aux;
        
    }

}

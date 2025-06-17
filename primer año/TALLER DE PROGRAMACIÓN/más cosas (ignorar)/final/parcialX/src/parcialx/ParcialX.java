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
public class ParcialX {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Materia M1 = new Materia ("cadp",5,"febrero");
        Materia M2 = new Materia ("taller",9,"febrero");
        Materia M3 = new Materia ("Tesis",7,"febrero");
        
        AlumnoDeGrado Alumno1 = new AlumnoDeGrado(5553,"Juan",5,"Lic en Informatica");
        Alumno1.agregarMateria(M1);
        Alumno1.agregarMateria(M2);
        Alumno1.agregarMateria(M3);
        
        AlumnoDeDoctorado Alumno2 = new AlumnoDeDoctorado(3234,"augusto",5,"Lic en Sistemas","unlp");
        Alumno2.agregarMateria(M1);
        Alumno2.agregarMateria(M2);
        
        System.out.println(Alumno1.toString());
        System.out.println(Alumno2.toString());
        
        
    }
    
}

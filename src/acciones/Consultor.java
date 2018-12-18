/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import objetosUtileria.Estudiante;

/**
 *
 * @author rafaelm
 */
public class Consultor {
    
    List<Estudiante> estudiantes;
    onConsultorInterface laSecre;
    
    public Consultor(onConsultorInterface secre){
        this.laSecre=secre;
        estudiantes=new ArrayList<Estudiante>();
    }
    
    
    public void agregarEstudianteALista(Estudiante estudiante){
        estudiantes.add(estudiante);
        laSecre.onCreateEstudiante(); 
    }
     public void agregarEstudianteAListaActualizado(Estudiante estudiante,int i){
        estudiantes.set(i, estudiante);
        laSecre.onCreateEstudiante(); 
     }
    
    public void buscar(String nombre){
        boolean bandera=true;
        for(Estudiante estudianteARevisar:estudiantes){
           
            if(nombre.equals(estudianteARevisar.getNombre())){
                laSecre.onEstudianteEncontrado(estudianteARevisar);
                bandera=false;
                break; 
              
            }
           
         
        }
         if (bandera){
            laSecre.onError();
            }
            
        
    }
    
     public void buscarActualizar(String nombre){
         int i=0;
         boolean bandera =true;
        for(Estudiante estudianteaRevisar:estudiantes){
         
            if(nombre.equals(estudianteaRevisar.getNombre())){
                laSecre.onEstudianteEncontradoActualiza(estudianteaRevisar,i);
                bandera=false;
                break;
              
            }
            
            i+=1;
        }
         if (bandera){
            laSecre.onError();
            }
    }
    
     public void buscarParaBorrar(String nombre){
         boolean bandera=true;
        for(int i = 0;i<estudiantes.size();i++){
            
            if(nombre.equals(estudiantes.get(i).getNombre())){
                String Nombre =estudiantes.get(i).getNombre();
                estudiantes.remove(i);
                laSecre.onEstudianteBorrado(Nombre);
                bandera=false;
                break;
            }
             if (bandera){
            laSecre.onError();
            }
        }
    }
    
    
    
  
    public void muestra(){
        for(Estudiante estudianteARevisar:estudiantes){
            System.out.println("Lista de estudiantes  "+estudianteARevisar.getNombre()+" "+estudianteARevisar.getPaterno()+" "+estudianteARevisar.getMaterno());
            
        }
    }
    
    
    
    
    public interface onConsultorInterface{
        public void onConsulta();
        public void onError();
        public void onCreateEstudiante();
        public void onEstudianteEncontrado(Estudiante estudiante);
        public void onEstudianteEncontradoActualiza(Estudiante estudiante,int posicion);
        public void onEstudianteBorrado(String data);
        public void onIngresadoParaBorrar(String Ingresado);
    }
    
}

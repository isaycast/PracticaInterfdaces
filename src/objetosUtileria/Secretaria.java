/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosUtileria;

import acciones.Capturista;
import acciones.Capturista.onCapturistaAction;
import acciones.Consultor;
import acciones.Consultor.onConsultorInterface;
import java.util.Scanner;

public class Secretaria implements onConsultorInterface,onCapturistaAction {

    Consultor consultor;
    Capturista capturista;
    
    public Secretaria(){
        consultor=new Consultor(this);
        capturista=new Capturista(this);
        boolean cond=true;
        while(cond){
            System.out.println("1) Crear estudiante \n"
                    + "2) Buscar estudiante \n"
                    + "3) Modificar estudiante \n"
                    + "4) Eliminar estudiante \n"
                    + "5) Lista de estudiantes \n"
                    + "6) Salir \n");
            Scanner scanner=new Scanner(System.in);
            int entrada=scanner.nextInt();
            switch(entrada){
                case 1:
                    capturista.capturar();
                    break;
                case 2:
                    capturista.ingresoDeNombre();
                    break;
                case 3:
                    capturista.ingresoDeNombreActualizar();
                    break;
                case 4:
                    capturista.ingresoParaBorrar();
                    break;
                case 5:
                    consultor.muestra();
                    break;
                case 6:
                    cond=false;
                    break;
            }
        }
    }

    @Override
    public void onConsulta() {
        
    }

    @Override
    public void onError() {
        System.out.println("El estudiante no ha sido encontrado, intentalo de nuevo");
        
    }

    @Override
    public void onCreateEstudiante() {
        System.out.println("---->Tu estudiante ya fue ingresado en la lista");
    }
   
    

    @Override
    public void onCaptura() {
        System.out.println("---->Inicia procedimiento de creacion de estudiante o actualizacion");
    }

    @Override
    public void onErrorOnCaptura() {
        
    }

    @Override
    public void onCapturaTerminada(Estudiante estudiante) {
        consultor.agregarEstudianteALista(estudiante);
    }
        @Override
    public void onCapturaTerminadaActualiza(Estudiante estudiante,int i) {
        consultor.agregarEstudianteAListaActualizado(estudiante,i);
    }

    @Override
    public void onNombreABuscarIngresado(String ingresado) {
        System.out.println("----->Nombre ingresado");
        consultor.buscar(ingresado);
    }
    @Override
    public void onNombreABuscarIngresadoActualizar(String ingresado) {
        System.out.println("----->Nombre ingresado");
        consultor.buscarActualizar(ingresado);
    }

    @Override
    public void onEstudianteEncontrado(Estudiante estudiante) {
        System.out.println("Nombre encontrado: "+estudiante.getNombre()+" "+estudiante.getPaterno()+" "+estudiante.getMaterno());
    }
    
     @Override
    public void onEstudianteEncontradoActualiza(Estudiante estudiante,int posicion) {
     System.out.println("Nombre encontrado: "+estudiante.getNombre()+" "+estudiante.getPaterno()+" "+estudiante.getMaterno());
     capturista.Actualizar(estudiante,posicion);
    }

    @Override
    public void onIngresadoParaBorrar(String ingresado) {
        System.out.println("Estudiante " + ingresado + " ingresado para borrar");
        consultor.buscarParaBorrar(ingresado);
    }

    @Override
    public void onEstudianteBorrado(String data) {
        System.out.println("Estudiante borrado -> "+data);
        consultor.muestra();
    }
    
    
}

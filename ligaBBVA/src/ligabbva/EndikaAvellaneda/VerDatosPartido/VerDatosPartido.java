/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ligabbva.EndikaAvellaneda.VerDatosPartido;

import java.util.ArrayList;

/**
 *
 * @author Aaron
 */
public class VerDatosPartido {
    
   public ArrayList CogerDatosPartido(String unPartido){
        ArrayList<String[]> datosPartido = new ArrayList(3);
        
        String[] nombresTitularesLocal = null;
        String[] nombresTitularesVisitante = null;
        
        String unaTarjeta;
        String[] todasLasTarjetas = null;
        
        /*Aquí se coge la información de la BD*/
        
        datosPartido.add(0, nombresTitularesLocal);
        datosPartido.add(1, nombresTitularesVisitante);
        datosPartido.add(2, todasLasTarjetas);
        
        return datosPartido;
    }
   
   public ArrayList CogerPartidos(){
       
       ArrayList<String[]> lPartidos = new ArrayList<>();
       
       String dato = null;
       String[] datosPartido = null;
       
       /*Bucle que coge los datos de cada partido (local, golesLocal, visitante, golesVisitante)
        y los mete en el ArrayList de Arrays de Strings. Cada Array de Strings es una linea del
        textArea*/
       
       return lPartidos;
       
   }
    
}

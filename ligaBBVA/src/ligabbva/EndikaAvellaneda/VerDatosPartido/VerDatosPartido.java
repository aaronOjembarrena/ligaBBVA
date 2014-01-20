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
        ArrayList datosPartido = new ArrayList(3);
        
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
    
}

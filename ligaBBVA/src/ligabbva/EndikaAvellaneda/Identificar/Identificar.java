/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ligabbva.EndikaAvellaneda.Identificar;

import ligabbva.GUISdeTodos.GUIinicioSesion;

/**
 *
 * @author Aaron
 */
public class Identificar {
    
    GUIinicioSesion identificacionInicial = new GUIinicioSesion();

    public Identificar() {
        identificacionInicial.setVisible(true);
    }
    
    public int IdentificacionUsuario(String nombreUsuario, String claveUsuario){
        
        int tipoUsuario = 3;
        
        /*Aquí se comprueba si el usuario corresponde a alguien de la base de datos,
         en el caso de que esté se devuelve el tipo de usuario*/
        
        
        
        return tipoUsuario;
    }
}

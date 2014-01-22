/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ligabbva.AaronOjembarrena.CambiarContrasena;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/** @Author Aaron Contraseña */
public class CambiarContrasena {
    
    
    public boolean ComprobacionCambioContrasena(String claveOriginal){
      
        boolean esCorrecta = false;

        try {
/**Abrimos la conexión a la base de datos*/
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conexion = DriverManager.getConnection("jdbc:odbc:ADSI");
            Statement sentencia=conexion.createStatement();
            conexion.setAutoCommit(false);

/**Realizamos la consulta a la base de datos*/         
            String consul="Select email, contrasena from Usuario "
                    + "where contrasena = '"+claveOriginal+"'";
           
            ResultSet rs = sentencia.executeQuery(consul);
/**Mientras haya elementos en la base de datos, cogemos y hacemos la comprobación oportuna
 de qué tipo es el usuario para luego devolverlo*/
            while (rs.next()) {
                String contra = rs.getString("contrasena");
                
                if (claveOriginal.equals(contra)){
                    esCorrecta = true;
                }
                else {
                    esCorrecta = false;
                }
         }
/**Cerramos la sentencia*/            
            sentencia.close();
/**Cerramos la conexión a la base de datos*/
            conexion.close();
         }catch (Exception err) {
                System.out.println("Error " + err.getMessage());
         }
        return esCorrecta;
    }  
}

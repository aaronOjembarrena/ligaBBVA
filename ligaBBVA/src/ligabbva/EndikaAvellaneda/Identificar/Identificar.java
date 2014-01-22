/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ligabbva.EndikaAvellaneda.Identificar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import ligabbva.GUISdeTodos.GUIinicioSesion;
import ligabbva.GestorBD;

/**
 *
 * @author Aaron
 */
public class Identificar {
    

    public Identificar() {
    
    }
    
    public int IdentificacionUsuario(String nombreUsuario, char[] password) throws SQLException{
        
        int tipoUsuario = 4;
        
        /*Aquí se comprueba si el usuario corresponde a alguien de la base de datos,
         en el caso de que esté se devuelve el tipo de usuario*/
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conexion=DriverManager.getConnection("jdbc:odbc:PracticaADSI");
            Statement sentencia=conexion.createStatement();
            conexion.setAutoCommit(false);
            
            ResultSet rs = sentencia.executeQuery("Select email, Contraseña, Tipo from Usuario");
            Statement sentencia2=conexion.createStatement();

            while (rs.next()) {
                String email = rs.getString("email");
                String con= rs.getString("Contraseña");
                
                StringTokenizer st = new StringTokenizer(con," ");
                String[] tabStr = new String[st.countTokens()];
                
                int i=0;
                while (st.hasMoreTokens())
                    tabStr[i++]= st.nextToken();

          int SalidaEsper = rs.getInt("Tipo");
          String resReal;
          String prueba;
         }
         }catch (Exception err) {
                System.out.println("Error " + err.getMessage());
         }
        return 0;
         }

}

package ligabbva.EndikaAvellaneda.Identificar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @Author Endika Avellaneda
 * 
 * El caso de identificar funciona correctamente, con los datos de la base de datos.
 * 
 * Persona 1 (identificada como árbitro) --> Usuario: pepito@pepito.es
 *                                           Contraseña: 1234
 * 
 * Persona 2 (identificada como presidente) --> Usuario: pipon@pipon.es
 *                                           Contraseña: 1234
 * 
 * Persona 3 (identificada como administrador) --> Usuario: popon@popon.es
 *                                           Contraseña: 1234
 * 
 * (Ya sabemos que las contraseñas no son nada seguras, XD)
 * 
 */
public class Identificar {
    
    public Identificar() {
    
    }
    
    public int IdentificacionUsuario(String nombreUsuario, String password) throws SQLException{ 
        int resultado = 4;
        
        try {
/**Abrimos la conexión a la base de datos*/
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conexion = DriverManager.getConnection("jdbc:odbc:ADSI");
            Statement sentencia=conexion.createStatement();
            conexion.setAutoCommit(false);

/**Realizamos la consulta a la base de datos*/         
            String consul="Select email, contrasena, Tipo from Usuario "
                    + "where email = '"+nombreUsuario+"' and contrasena = '"+password+"'";
           
            ResultSet rs = sentencia.executeQuery(consul);
/**Mientras haya elementos en la base de datos, cogemos y hacemos la comprobación oportuna
 de qué tipo es el usuario para luego devolverlo*/
            while (rs.next()) {
                String email = rs.getString("email");
                int tipo = rs.getInt("Tipo");
                
                if (tipo == 0){
                    resultado = 0;
                }
                else if (tipo == 1){
                    resultado = 1;
                }
                else{
                    resultado = 2;
                }
         }
/**Cerramos la sentencia*/            
            sentencia.close();
/**Cerramos la conexión a la base de datos*/
            conexion.close();
         }catch (Exception err) {
                System.out.println("Error " + err.getMessage());
         }
    return resultado;
    }
}
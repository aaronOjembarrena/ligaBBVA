package ligabbva;
import java.sql.*;

    
public class GestorBD {

    //CONSTRUCTORES
        //Constructor que crea la conexion sin parametros con unos definidos en la clase
        //(meter los datos correspondientes)
        private GestorBD(){
            try {
                AbrirConexion();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //El método que nos permite abrir la conexión
     
        private void AbrirConexion() throws SQLException {
            try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection conexion = DriverManager.getConnection("jdbc:odbc:LigaBBVA");
                    Statement st = conexion.createStatement();
                                
     
            } catch (Exception err) {
                System.out.println("Error " + err.getMessage());
            }
        }
}
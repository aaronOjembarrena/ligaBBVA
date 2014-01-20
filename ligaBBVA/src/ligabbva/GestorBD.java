package ligabbva;

import java.sql.*;

	
public class GestorBD {
		 
	 
	//variables
	 
	    private String usuario;
	    private String clave;
	    private String url;
	    private String driverClassName;
	    private Connection conn = null;
	    private Statement sentencia;
	    public static GestorBD conex;
	  
	 
	//CONSTRUCTORES
	 
	   
	 
	    //Constructor que crea la conexion sin parametros con unos definidos en la clase
	    //(meter los datos correspondientes)
	    private GestorBD() {
	    	
	    
	    		//conexion MySQL
	    		//poner los datos apropiados
	  	      	this.usuario = "UsuarioMySQL"; //usuario creado en MySQL y con permiso en la Base de
	  	        //datos con la que quiero trabajar. Hay que evitar usar el root
	  	      	this.clave = "37ca23."; //Password de mysql del usuario
	  	        this.url = "jdbc:mysql://localhost:3306/BDPruebas"; //Forma de "encontrar" la Base de Datos en
	  	        //MySQL, si queremos usar otro SGBD, es distinto
	  	        this.driverClassName = "com.mysql.jdbc.Driver"; //driver para trabajar con MySQL
	  	        //si queremos usar otro SGBD, el driver es distinto
	    	
	    	
	        try {
				AbrirConexion();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    public static GestorBD getInstance() {
	        if(conex == null) {
	          
	              conex = new GestorBD();
	           }
	        return conex;
	     }
	
	    //El m�todo que nos permite abrir la conexi�n
	 
	    private void AbrirConexion() throws SQLException {
	    	
	        try {
	        	
	        		        		//en MySQL con usuario y clave
	        		Class.forName(this.driverClassName).newInstance();
	            this.conn = DriverManager.getConnection(this.url, this.usuario, this.clave);
	        		        	
	 
	        } catch (Exception err) {
	            System.out.println("Error " + err.getMessage());
	        }
	    }
	    
	    
	        
	 	   	 
	    //Cerrar la conexion
	 
	    public void CerrarConexion() throws SQLException {
	        this.conn.close();
	    }
	 
	/**M�todos para trabajar con la Base de Datos. En este caso he puesto cuatro m�todos
	  y los cuatro trabajan con el objeto ResulSet. Hay m�s opciones, las pod�is consultar
	  en la documentaci�n de java.sql y usarlas en funci�n de vuestras necesidades
	 **/
	    public ResultSet consulta(String consulta) throws SQLException {
	        this.sentencia = (Statement) conn.createStatement();
	        return this.sentencia.executeQuery(consulta);
	    }
	    
	    public void cerrarConsulta (ResultSet resul)throws SQLException {
	    	resul.close();
	    }
	 
	    public void actualizar(String actualiza) throws SQLException {
	        this.sentencia = (Statement) conn.createStatement();
	        sentencia.executeUpdate(actualiza);
	    }
	 
	    public ResultSet borrar(String borra) throws SQLException {
	        Statement st = (Statement) this.conn.createStatement();
	        return (ResultSet) st.executeQuery(borra);
	    }
	 
	    public int insertar(String inserta) throws SQLException {
	        Statement st = (Statement) this.conn.createStatement();
	        return st.executeUpdate(inserta);
	    }
		

}

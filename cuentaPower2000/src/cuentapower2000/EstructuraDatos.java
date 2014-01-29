/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentapower2000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class EstructuraDatos extends HashMap<String, Pieza>{

    private EstructuraDatos datosPiezas = null;
    
    public EstructuraDatos() {
    }

    public EstructuraDatos getDatosPiezas() {
        if(datosPiezas==null){
            datosPiezas = new EstructuraDatos();
	}
			
	return datosPiezas;
    }
    
    public void recogerDatosPiezas() throws IOException{
        BufferedReader datosEntrada;
        String infoPieza;
        
		/*Se almacenan los datos obtenidos desde el fichero de IMBD o el de prueba (Nota* El 
		  fichero de IMBD con las primeras líneas y las últimas borradas como se comento en clase)*/
		
        datosEntrada = new BufferedReader(new FileReader("datosPiezas.txt"));
        Pieza laPiezaActual = null;
        
        //Mientras que existan líneas en el fichero
        while ((infoPieza = datosEntrada.readLine()) != null){
        	//Si en la linea no está vacía se trocea la línea mediante split() usando como referencia las tabulaciones
        	if(infoPieza.trim().length()==0) continue;
                
                
        		
        	String[] referenciaLineaPieza = infoPieza.split("\\t+");
        		System.out.println(referenciaLineaPieza[0]);
        		anadirPieza(referenciaLineaPieza[0]);
                        
        	}
        	
        if (datosEntrada != null) {
            datosEntrada.close();
        } 
    }
    
    public void anadirPieza(String referencia){
        put(referencia, new Pieza(referencia));
    }
    
}

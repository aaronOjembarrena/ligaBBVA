/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentapower2000;

/**
 *
 * @author Aaron
 */
public class Pieza {
    
    private String referencia;
    private int numPiezas;

    public Pieza(String referencia) {
        this.referencia = referencia;
        this.numPiezas = 0;
    }

    public void setNumPiezas(int numPiezas) {
        this.numPiezas = numPiezas;
    }
    
    
    
}

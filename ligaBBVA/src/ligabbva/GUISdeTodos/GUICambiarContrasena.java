/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ligabbva.GUISdeTodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import ligabbva.AaronOjembarrena.CambiarContrasena.CambiarContrasena;

/**
 *
 * @Author Aaron Ojembarrena
 * 
 * Comentarios: Hemos estado viendo que la consulta es correcta; ya que hemos mirado en Internet y la estrcutura indica que
 * la estructura es esa. Si esta mal agradeceríamos que nos comunicaras en donde hemos fallado.
 * 
 * Pero a la hora de ejercutar el cambio, no cambia el valor en la base de datos.
 * 
 * No sabemos, si realmente la hemos fastidiado en la consulta (que este mal realizada y que hayamos mirado mal)
 * o que haya algún problema con el odbc y no podamos realizar ni inserts, ni updates sobre la base de datos.
 * 
 */

public class GUICambiarContrasena extends javax.swing.JFrame {

    /**
     * Creates new form GUICambiarContrasena
     */
    
    int copiaTipoUsuario;
    String nombreUsuario;
    
    public GUICambiarContrasena(int tipoUsuario, String nombre) {
        initComponents();
        copiaTipoUsuario = tipoUsuario;
        nombreUsuario = nombre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Contraseña actual: ");

        jLabel2.setText("Nueva contraseña: ");

        jLabel3.setText("Repetir contraseña: ");

        jButton1.setText("Cambiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jButton1)
                .addGap(52, 52, 52)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        CambiarContrasena cambioContr = new CambiarContrasena();
        
        String claveOriginal = jTextField1.getText();
        
        System.out.println (jTextField2.getText());
        System.out.println (jTextField3.getText());
        
        if(!cambioContr.ComprobacionCambioContrasena(claveOriginal)) JOptionPane.showMessageDialog(null, "La contraseña no"
                + " es correcta.");
        else{
            String contra1 = jTextField2.getText();
            String contra2 = jTextField3.getText();
            
            String usuario = this.nombreUsuario;
            
            System.out.println(nombreUsuario);
           
            if(cambioContr.ComprobacionCambioContrasena(claveOriginal) == true && contra1.equals(contra2)){
                try{
/**Abrimos la conexión a la base de datos*/
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conexion = DriverManager.getConnection("jdbc:odbc:ADSI");
            Statement sentencia=conexion.createStatement();
            conexion.setAutoCommit(false);

/**Realizamos la consulta a la base de datos*/         
            String consul="Update Usuario set contrasena= '"+contra1+"' where email = '"+usuario+"'";
            
            System.out.println(consul);
     
/**Cerramos la sentencia*/            
            sentencia.close();
/**Cerramos la conexión a la base de datos*/
            conexion.close();
                       
            JOptionPane.showMessageDialog(null, "La contraseña se ha cambiado correctamente.");
        
            if(copiaTipoUsuario == 0){
                GUIinterfazMenuAdministrador menuAdmin = new GUIinterfazMenuAdministrador(nombreUsuario);
                menuAdmin.setVisible(true);
            }
            else if(copiaTipoUsuario == 1){
                GUIinterfazMenuArbitro menuArbi = new GUIinterfazMenuArbitro(nombreUsuario);
                menuArbi.setVisible(true);
            }
            else if(copiaTipoUsuario == 2){
                GUIinterfazMenuPresidente menuPresid = new GUIinterfazMenuPresidente(nombreUsuario);
                menuPresid.setVisible(true);
            }
            } catch (Exception err) {
                System.out.println("Error " + err.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Las claves no coinciden. Compruebelo de nuevo");
            }
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
            if(copiaTipoUsuario == 0){
                GUIinterfazMenuAdministrador menuAdmin = new GUIinterfazMenuAdministrador(nombreUsuario);
                menuAdmin.setVisible(true);
            }
            else if(copiaTipoUsuario == 1){
                GUIinterfazMenuArbitro menuArbi = new GUIinterfazMenuArbitro(nombreUsuario);
                menuArbi.setVisible(true);
            }
            else if(copiaTipoUsuario == 2){
                GUIinterfazMenuPresidente menuPresid = new GUIinterfazMenuPresidente(nombreUsuario);
                menuPresid.setVisible(true);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUICambiarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUICambiarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUICambiarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUICambiarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUICambiarContrasena().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

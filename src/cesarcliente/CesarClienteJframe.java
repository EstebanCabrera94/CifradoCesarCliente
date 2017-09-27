/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cesarcliente;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteban
 */
public class CesarClienteJframe extends javax.swing.JFrame {

    /**
     * Creates new form CesarClienteJframe
     */
    public CesarClienteJframe() {
        
        initComponents();
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCifrar = new javax.swing.JTextArea();
        jTextFieldCifrar = new javax.swing.JTextField();
        jLabelCesar = new javax.swing.JLabel();
        jButtonCifrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextAreaCifrar.setColumns(20);
        jTextAreaCifrar.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCifrar);

        jLabelCesar.setText("Escribe el texto a cifrar");

        jButtonCifrar.setText("Cifrar");
        jButtonCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCifrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCesar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButtonCifrar)))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCesar)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCifrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCifrarActionPerformed
        // TODO add your handling code here:
       
       enviarYrecibir(socketA);
        
    }//GEN-LAST:event_jButtonCifrarActionPerformed
    
    
    void enviarYrecibir(Socket socket){
        try {
            boolean mal = true;
            
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            String mensaje;
            
                  
                  boolean confirm = true;
                  String abc = "abcdefghijklmnñopqrstuvwxyzabc";
                  String letra;
                  int posicion;
                  
                  // coger el texto que hemos escribido
                  mensaje = jTextFieldCifrar.getText();
                  
                 
        
                 
                //Enviar mensaje al servidor
                  bw.write(mensaje);
                  bw.newLine();
                  bw.flush();
                
                 
                 
                 //Recibir mensaje del servidor   
                  mensaje = br.readLine();
                  
                  if(numero==0){
                      jTextAreaCifrar.append("Texto 1 Cifrado: "+mensaje);
                      numero++;
                  }else{
                      numero++;
                      jTextAreaCifrar.append("\n\nTexto "+Integer.toString(numero)+" Cifrado: "+mensaje);
                  
                  }
                  
        
            
        } catch (IOException ex) {
            Logger.getLogger(CesarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CesarClienteJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CesarClienteJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CesarClienteJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CesarClienteJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        // conectarse
        final int PUERTO = 40080;
        final String HOST = "localhost"; //192.168.202.82
        try {
            Socket socket = new Socket(HOST,PUERTO);
            socketA = socket;
            System.out.println("El cliente se acaba de conectar");
            
            //enviarYrecibir(socket);
            
        } catch (IOException ex) {
            Logger.getLogger(CesarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CesarClienteJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCifrar;
    private javax.swing.JLabel jLabelCesar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCifrar;
    private javax.swing.JTextField jTextFieldCifrar;
    // End of variables declaration//GEN-END:variables

    static Socket socketA;
    static String texto;
    static int numero = 0;
}

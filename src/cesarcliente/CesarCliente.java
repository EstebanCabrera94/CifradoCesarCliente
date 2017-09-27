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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteban
 */
public class CesarCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int PUERTO = 40080;
        final String HOST = "localhost"; //192.168.202.82
        try {
            Socket socket = new Socket(HOST,PUERTO);
            System.out.println("El cliente se acaba de conectar");
            
            enviarYrecibir(socket);
            
        } catch (IOException ex) {
            Logger.getLogger(CesarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void enviarYrecibir(Socket socket){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            Scanner scanner = new Scanner(System.in);
            String mensaje;
            
            while (true) {
                
                
                //Leer del teclado el mensaje del cliente para el servidor
                  System.out.print("Cliente: ");
                  mensaje = scanner.nextLine();
                //Enviar mensaje al servidor
                  
                  bw.write(mensaje);
                  bw.newLine();
                  bw.flush();
                
                 //Recibir mensaje del servidor
                  //System.out.println("Esperando mensaje del Servidor");
                  mensaje = br.readLine();
                  System.out.println("Cifrado: " +  mensaje);
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(CesarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

package Exercice1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
import java.net.*;

public class SecondServeur extends Thread {
	
	static final int port = 5372;
	 
    public static void main(String[] args) throws Exception {

         ServerSocket s = new ServerSocket(port);
         Socket soc = s.accept();
 
         // Un BufferedReader permet de lire par ligne.
         BufferedReader plec = new BufferedReader(new InputStreamReader(soc.getInputStream()));
 
         // Un PrintWriter possède toutes les opérations print classiques.
         // En mode auto-flush, le tampon est vidé (flush) à l'appel de println.
         PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
 
         while (true){  

            String str = plec.readLine();
            // lecture du message pong du ptemier serveur
            if (!str.equals("pong")) break;

            else{
               System.out.println("ECHO = " + str);
               
               try { 
   	            FirstServeur.sleep(500);
   	           }
   	           catch (Exception e){
   	        	 e.printStackTrace();     	
   	           }
            }
            
            // écrit et renvoi un ping au premier serveur
            String other_str = "ping";      
            pred.println(other_str); // renvoi d'un écho

         }

         plec.close();
         pred.close();
         soc.close();
    }
	
	
	
	
	

}

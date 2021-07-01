package Exercice1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
import java.net.*;

public class FirstServeur extends Thread {
	
	static final int port = 4567;

	   public static void main(String[] args) throws Exception {

	        ServerSocket s = new ServerSocket(port);
	        Socket soc = s.accept();

	        BufferedReader plec = new BufferedReader(new InputStreamReader(soc.getInputStream()));

	        PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())),true);

	        while(true){

	        String str = "pong";
	        
	        try { 
	            FirstServeur.sleep(500);
	        }
	        catch (Exception e){
	        	e.printStackTrace();     	
	        }
	        // envoi d'un message
	        pred.println(str);
	             
	        // 
	        str = plec.readLine();      
	        
	        }
	        
	        plec.close();
	        pred.close();
	        soc.close();
	   }

}

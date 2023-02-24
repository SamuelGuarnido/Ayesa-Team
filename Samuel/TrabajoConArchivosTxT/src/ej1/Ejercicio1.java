package ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		System.out.println("Nombre del fichero: ");
		@SuppressWarnings("resource")
		String fichOriginal = new Scanner(System.in).nextLine();
		fichOriginal = "C:\\Users\\Samuel\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\"+ fichOriginal + ".txt";
		 
		String txt = "";
		try(BufferedReader in = new BufferedReader(new FileReader(fichOriginal))){
			String linea = in.readLine();
			while(linea != null) {
				txt = txt + linea +"\n";
				linea = in.readLine();
			}
			
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.println("Texto: \n"+txt);
	
	}
}

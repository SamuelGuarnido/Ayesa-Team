package ej3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Samuel
 *
 */
public class Ejercicio3 {

	//NO FUNCIONA BIEN
	public static void main(String[] args) {
		 
		int contC = 0;
		int contL = 0;
		String linea = "", txt = "";
		String[] palabras = null;
		
		try(BufferedReader in = new BufferedReader(new FileReader(
				"C:\\Users\\Samuel\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\carta.txt"))){
			
			linea = in.readLine();
			while(linea != null) {
				txt = txt + linea + " ";
				contL++;
				contC += linea.trim().length();
				linea = in.readLine();
				
			}
			palabras = txt.split(" ");
			
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.println("Numero de chars: "+contC);
		System.out.println("Numero de palabras: "+palabras.length);
		System.out.println("Numero de lineas: "+contL);
	}
	
}

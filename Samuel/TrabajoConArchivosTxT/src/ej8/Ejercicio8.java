package ej8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Samuel
 *
 */
public class Ejercicio8 {

	static String cifrar(String aCifrar, String alfabeto, String cifrado) {
		String cif = "";
		int c = 0;
		for(int i = 0; i < aCifrar.length(); i++) {
			c = alfabeto.indexOf(aCifrar.charAt(i));
			cif = cif + cifrado.charAt(c);
		}
		return cif;
	}
	
	public static void main(String[] args) {
		
		try(BufferedReader in1 = new BufferedReader(
				new FileReader("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\codec.txt"))){
			
			String alfabeto = in1.readLine();
			String cifrado = in1.readLine();
			
			
			
			String line = "", txt = "";
			try(BufferedReader in = new BufferedReader(
					new FileReader("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\textoacifrar.txt"))){
				
				line = in.readLine();
				while(line != null) {
					txt = txt + cifrar(line, alfabeto, cifrado) + "\n";
					line = in.readLine();
				}
				
				try(BufferedWriter out = new BufferedWriter(
						new FileWriter("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\textocifrado.txt"))){
					out.write(txt);
				}
				catch(IOException ioe) {
					System.out.println(ioe.getMessage());
				}
			
			}
			catch(IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
	}
	
}

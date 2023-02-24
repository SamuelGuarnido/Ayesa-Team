package ej6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		
		String line = "";
		int contL = 0;
		try(BufferedReader in = new BufferedReader(
				new FileReader("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\more.txt"))){
			line = in.readLine();
			while(line != null) {
				for(int i = 0; i < 24; i++) {
					System.out.println(line);
					contL++;
					line = in.readLine();
				}
				if(contL == 24)
					System.out.println("\n\n   ^ AQUÍ SE HACEN LAS 24 ^\n\n");
			}
			
			
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
	}
	
}

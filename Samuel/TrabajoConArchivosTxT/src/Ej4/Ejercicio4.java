package Ej4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Samuel
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		
		double max = 0;
		String linea = "";
		
		try(BufferedReader in = new BufferedReader(new FileReader(
				"C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\Numeros.txt"))){
			
			linea = in.readLine();
			while(linea != null) {
				max = Math.max(max, Double.valueOf(linea));
				linea = in.readLine();
			}
			
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.println("El maximo del fichero es: "+max);
		
	}
}

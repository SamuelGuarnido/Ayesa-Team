package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {

		Scanner archivo = new Scanner(System.in);
		System.out.print("Introduce el nombre del archivo: ");
		String nombreArchivo = archivo.nextLine();

		if (nombreArchivo.equals("")) {
			nombreArchivo = "prueba.txt";
		}
		try (BufferedReader br = new BufferedReader(new FileReader("ficheros\\"+nombreArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			System.out.println("No se ha podido leer el archivo " + nombreArchivo);
		}
		archivo.close();
	}
}

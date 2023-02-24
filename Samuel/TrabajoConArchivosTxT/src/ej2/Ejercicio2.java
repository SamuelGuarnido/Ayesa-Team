package ej2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Samuel\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\datos.txt",true))){
			System.out.println("Nombre: ");
			out.write("Nombre: "+sc.nextLine()+"\n");
			System.out.println("Edad: ");
			out.write("Edad: "+sc.nextInt()+"\n");
			
		}
		
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		catch(InputMismatchException ime) {
			System.out.println(ime);
		}
	sc.close();
	}
	
}

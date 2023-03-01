package ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		String nombre = null;
		Integer edad = null;
		String  fichero = "";

		while(nombre == null || edad == null) {
			try(BufferedWriter out = new BufferedWriter(new FileWriter("ficheros\\datos.txt"))){

				System.out.println("Dime el nombre: ");
				nombre = new Scanner(System.in).nextLine();			

				System.out.println("Dime la edad: ");
				edad = new Scanner(System.in).nextInt();

				fichero= "Nombre: "+nombre+"\nEdad: "+edad+"\n";
				out.write(fichero);

			}
			catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
			catch(InputMismatchException ex) {
				System.out.println(ex.getMessage());
			}
			catch(NoSuchElementException ex) {
				System.out.println(ex.getMessage());
			}
		}


	}



}

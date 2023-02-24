package ej12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio12 {
	
	static String txt = "";
	static Scanner sc = new Scanner(System.in);
	
	static void texto() {

		String line = "";
		try (BufferedReader in = new BufferedReader(
				new FileReader("C:\\Users\\Samuel\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\agenda.txt"))) {

			line = in.readLine();
			while (line != null) {
				txt = txt + line + "\n";
				line = in.readLine();
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	static boolean insertaContacto(String nombre, String numero) {
		boolean done = false;
		if (!txt.contains(nombre)) {
			try (FileWriter out = new FileWriter(
					"C:\\Users\\Samuel\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\agenda.txt", true)) {
				out.write(nombre+"\n -"+numero);
				txt = txt + (nombre+"\n -"+numero);
				done = true;
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}

		} else
			System.out.println("Ese nombre ya existe");
		return done;
	}
	
	
	
	
	private static void menu() {
		texto();
		byte num = 0;
		while (num != 4) {
			System.out.println("Opciones...");
			System.out.println("1. Nuevo contacto");
			System.out.println("2. Buscar por nombre");
			System.out.println("3. Mostrar todos");
			System.out.println("4. Salir");
			num = new Scanner(System.in).nextByte();

			switch (num) {

			case 1:
				System.out.println("Nombre: ");
				String name = sc.next();
				System.out.println("Numero: ");
				String number = sc.next();
				System.out.println(insertaContacto(name, number));
				break;
			case 2:
				
			case 3:
				System.out.println("**Lista de contactos**");
				System.out.println(txt);
				break;
			case 4:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}

		}
	}
	
	
	public static void main(String[] args) {
		
		menu();
		
		
	}
	
}

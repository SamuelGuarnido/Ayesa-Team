package ej5_V2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5_V2 {

	static String txt = "";

	static void texto() {

		String line = "";
		try (BufferedReader in = new BufferedReader(
				new FileReader("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\firmas.txt"))) {

			line = in.readLine();
			while (line != null) {
				txt = txt + line + "\n";
				line = in.readLine();
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	static boolean insertaFirma(String firma) {
		boolean done = false;
		if (!txt.toLowerCase().contains(firma.toLowerCase())) {
			try (FileWriter out = new FileWriter(
					"C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\firmas.txt", true)) {
				out.write("\n"+firma);
				done = true;
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}

		} else
			System.out.println("Esa firma ya existe");
		return done;
	}

	private static void menu() {
		texto();
		byte num = 0;
		while (num != 3) {
			System.out.println("Opciones...");
			System.out.println("1. Mostrar libro de firmas");
			System.out.println("2. Firmar en el libro de firmas");
			System.out.println("3. Huir del libro de firmas");
			num = new Scanner(System.in).nextByte();

			switch (num) {

			case 1:
				System.out.println("**Libro**");
				System.out.println(txt);
				break;
			case 2:
				System.out.println("Firma: ");
				insertaFirma(new Scanner(System.in).next());
				break;
			case 3:
				System.out.println("Ha huido con éxito");
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

package ej5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {

	private static String muestraTxt() {

		String linea = "", txt = "";
		try (BufferedReader in = new BufferedReader(
				new FileReader("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\firmas.txt"))) {

			linea = in.readLine();
			while (linea != null) {
				txt = txt + linea + "\n";
				linea = in.readLine();
			}

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return txt;
	}

	private static void insertaFirma(String txt, String sign) {
		try (BufferedWriter out = new BufferedWriter(
				new FileWriter("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\firmas.txt"))) {
			if (txt.contains(sign))
				throw new YaExisteException();
			else {
				sign = txt + sign;
				out.write(sign);
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} catch (YaExisteException yee) {
			System.out.println(yee+"\n");
		}
		
	}

	private static void menu() {
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
				System.out.println(muestraTxt());
				break;
			case 2:
				System.out.println("Firma: ");
				insertaFirma(muestraTxt(), new Scanner(System.in).next());
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

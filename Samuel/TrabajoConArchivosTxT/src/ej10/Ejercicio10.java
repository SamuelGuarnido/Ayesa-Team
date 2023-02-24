package ej10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio10 {

	public static void main(String[] args) {

		String line = "";
		try (BufferedReader in = new BufferedReader(
				new FileReader("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\matriz.txt"))) {

			line = in.readLine();
			char[][] txt = new char[line.length()][line.length()];
			int j = 0;
			while (line != null) {
				for (int i = 0; i < 2; i++) {
					txt[i][j] = line.charAt(i);
				}
				line = in.readLine();
				j++;
			}
			try (BufferedWriter out = new BufferedWriter(new FileWriter(
					"C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\matrizTraspuesta.txt"))) {
				String texto = Arrays.deepToString(txt);
				out.write(texto);
			} 
			catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

}

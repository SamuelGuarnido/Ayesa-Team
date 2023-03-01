package ejercicio9;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio9 {

	static String decodificador(String aDescifrar, String alfabeto, String cifrado) {
		String descif = "";
		int c = 0;
		for (int i = 0; i < aDescifrar.length(); i++) {
			c = cifrado.indexOf(aDescifrar.charAt(i));
			descif = descif + alfabeto.charAt(c);
		}
		return descif;

	}

	public static void main(String[] args) {

		String line = "", txt = "";
		try (BufferedReader in = new BufferedReader(
				new FileReader("ficheros\\codec.txt"))) {

			String alfabeto = in.readLine();
			String cifrado = in.readLine();

			try (BufferedReader in2 = new BufferedReader(new FileReader(
					"ficheros\\textocifrado.txt"))) {

				line = in2.readLine();
				while (line != null) {
					txt = txt + decodificador(line, alfabeto, cifrado) + "\n";
					line = in2.readLine();
				}

				try (BufferedWriter out = new BufferedWriter(new FileWriter(
						"ficheros\\textoDescifrado.txt"))) {
					out.write(txt);
				} catch (IOException ioe) {
					System.out.println(ioe.getMessage());
				}

			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

}

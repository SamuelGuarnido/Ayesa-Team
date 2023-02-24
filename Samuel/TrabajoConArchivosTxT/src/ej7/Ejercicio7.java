package ej7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Arrays;

public class Ejercicio7 {
	
	public static void main(String[] args) {
		
		String line = "";
		String line2 = "";
		try(BufferedReader in = new BufferedReader(
				new FileReader("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\perso1.txt"));
				BufferedReader in2 = new BufferedReader(
						new FileReader("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\perso2.txt"))){
			
			line = in.readLine();
			line2 = in2.readLine();
			
			String txt = "";
			while(line != null) {
				txt = txt + line + " ";
				line = in.readLine();
			}
			while(line2 != null) {
				txt = txt + line2 + " ";
				line2 = in2.readLine();
			}
			
			txt = Normalizer.normalize(txt, Normalizer.Form.NFD);
	        txt = txt.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
			
			String[] nombres = txt.split(" ");
			Arrays.sort(nombres);
			
			String todos = "";
			for(String a : nombres) {
				todos = todos + a +"\n";
			}
			
			
			try(BufferedWriter out = new BufferedWriter(
					new FileWriter("C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\todos.txt"))){
				out.write(todos);
			}
			catch(IOException ioe) {
				System.out.println(ioe.getMessage());
			}
			
			
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
}

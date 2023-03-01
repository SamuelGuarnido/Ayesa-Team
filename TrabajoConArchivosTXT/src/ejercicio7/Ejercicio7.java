package ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio7 {

	public static List<String> introducir(String fichero) {
		
		List<String> array = new ArrayList<>();
		try(BufferedReader in = new BufferedReader(new FileReader(fichero))){	
			String linea = in.readLine();
			while(linea != null) {
				array.add(linea);
				linea = in.readLine();
			}	
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		return array;
	}
	
	public static void main(String[] args) {

		List<String> array = new ArrayList<>();
		array = Ejercicio7.introducir("ficheros\\perso1.txt");
		array.addAll(Ejercicio7.introducir("ficheros\\perso2.txt"));
		Collections.sort(array);
		
		
		System.out.println(array);
		
		
		try(BufferedWriter out = new BufferedWriter(new FileWriter("ficheros\\todos.txt"))){
			out.write(array.get(0));
			for(int i=1; i<array.size();i++) {
				out.append(array.get(i));
				out.newLine();
			}
			
		}catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

}

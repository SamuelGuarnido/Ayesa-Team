package ejercicio2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import outBinario.MyObjectOutputStream;


public class Ejercicio2 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
	String line = "";
	
	try (MyObjectOutputStream out = new MyObjectOutputStream("C:\\Users\\samue\\eclipse-workspace\\Unidad5\\ficheros\\binarios\\varios\\textoALinea.dat")) {
		System.out.println("Pulse intro al finalizar la línea");
		do {
			System.out.print(">");
			line = sc.nextLine() + "\n";
			if(line.length() > 0)
				out.writeObject(line);
			
		}while(line.length() > 0);
		
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
		
	}
	
}

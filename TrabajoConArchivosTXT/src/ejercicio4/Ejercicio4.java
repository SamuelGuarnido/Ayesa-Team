package ejercicio4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		double num, max= -2147483648;
		double min = 2147483647;
		try (BufferedReader in = new BufferedReader(new FileReader("ficheros\\Numeros.txt"))){
			Scanner s;
			String linea = in.readLine();
			
			while(linea != null) {
				s= new Scanner(linea);
				if(s.hasNextDouble()) {
					num = s.nextDouble();
					if(num > max) {
						max = num;
					}
					if(num < min) min = num;
				linea = in.readLine();
				}
			}
			
			
			
		}catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Número mayor: "+max);
		System.out.println("Número menor: "+min);
	}
}

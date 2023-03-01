package ejercicio6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio6 {

	public static void more() {

		System.out.println("El fichero debe estar dentro de la carpeta ficheros");
		System.out.println("Dime el nombre del fichero: ");
		String fichero = new Scanner(System.in).nextLine();

		String texto = "";

		try(BufferedReader in = new BufferedReader(new FileReader("ficheros\\"+fichero))){
			String linea = in.readLine();
			String more ="";

			System.out.println("Pulsa la x para salir");
			System.out.println("Presiona cualquier tecla para continuar leyendo: ");
			more= new Scanner(System.in).nextLine();
			while(linea != null) {


				if(!more.equals("x")) {
					for(int i=0; i<15 ;i++) {
						linea = in.readLine();
						if(linea != null) {
							texto = texto+ linea+"\n";
						}
					}
					System.out.println(texto);

					if(linea != null) {
						System.out.println("Presiona cualquier tecla para continuar leyendo: ");
						more= new Scanner(System.in).nextLine();
					}else System.out.println("***** Fin del archivo *****");
					
				}else linea = null;
				
			}

			System.out.println("Gracias por utilizar el programa ;)");

		}catch(IOException ex) {
			System.err.println(ex.getMessage());
		}



	}

	public static void main(String[] args) {

		Ejercicio6.more();

	}

}

package ejercicio11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Ejercicio11 {

	public static boolean comparaLineas(String linea, String linea2) {
		boolean b = false;

		int posicion = -1;
		char caracter = 'z';
		char caracter2 = 'z';

		if(linea.length() == linea2.length()) {
			for(int i=0;i<linea.length();i++) {
				if(linea.charAt(i) != (linea2.charAt(i))) {
					posicion = i;

				}
			}
		}else {
			if(linea.length() < linea2.length()) {
				for(int i=0;i<linea.length();i++) {
					if(linea.charAt(i) != (linea2.charAt(i) ) && posicion == -1) {
						posicion = i;
						caracter = linea.charAt(i);
						caracter2 = linea2.charAt(i);
						System.out.println("El texto 1 tiene menos carácteres en la linea");
						System.out.println("Son diferentes los carácteres: "+caracter+" del texto 1 y "+caracter2+" del texto 2 que están el la posición "+posicion);
					}else if(posicion == -1) {
						posicion = linea2.length()-1;
						System.out.println("Son diferentes en la posicion de linea "+posicion+", teniendo el texto 1 el carácter "+linea2.charAt(linea.length()));
					}
				}


			}else {
				for(int i=0;i<linea2.length();i++) {
					if(linea2.charAt(i) != (linea.charAt(i)) && posicion == -1) {
						posicion = i;
						caracter = linea.charAt(i);
						caracter2 = linea2.charAt(i);
						System.out.println("El texto 2 tiene menos carácteres en la linea");
						System.out.println("Son diferentes los carácteres: "+caracter+" del texto 1  y "+caracter2+" del texto 2 que están el la posición "+posicion);
					}else if(posicion == -1) {
						posicion = linea.length()-1;
						System.out.println("Son diferentes en la posicion de linea "+posicion+", teniendo el texto 1 el carácter "+linea.charAt(linea2.length()));
					}
				}

			}
		}

		if (posicion == -1) {
			b=true;
		}
		return b;
	}

	public static void archivosiguales() {

		boolean b = true;
		int cont=1;
		
		try(BufferedReader in = new BufferedReader(new FileReader("ficheros\\texto1.txt"));
				BufferedReader in2 = new BufferedReader(new FileReader("ficheros\\texto2.txt"))){

			String linea= in.readLine();
			String linea2 = in2.readLine();
			while(linea != null || linea2 != null) {
				if(Ejercicio11.comparaLineas(linea, linea2)) {
					linea = in.readLine();
					linea2 = in2.readLine();
					cont += 1;
				}else {
					b = false;
					linea = null;
					linea2 = null;
				}
			}

			if(b) System.out.println("Los archivos son exactamente iguales");
			else System.out.println("La primera diferencia se encuentra en la linea "+cont);

		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {

		Ejercicio11.archivosiguales();

	}

}

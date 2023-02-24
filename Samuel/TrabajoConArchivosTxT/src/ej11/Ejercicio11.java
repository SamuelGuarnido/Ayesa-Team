package ej11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio11 {

	static boolean dif = false, hayNull = false;
	
	static int counter(String a, String b) {
		
		int contChars = 1;
		for (int i = 0; i < a.length() && !dif; i++) {
			if (a.charAt(i) == b.charAt(i))
				contChars++;
			else
				dif = true;
		}
		return contChars;
	}
	
	
	static void comp(String a1, String a2) {

		String line1 = "", line2 = "";
		int contL = 0;
		try (BufferedReader in = new BufferedReader(new FileReader(
				"C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\" + a1 + ".txt"))) {
			try (BufferedReader in2 = new BufferedReader(new FileReader(
					"C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosTxT\\ficheros\\" + a2 + ".txt"))) {

				line1 = in.readLine();
				line2 = in2.readLine();
				
				
				int contChars = 0;
				while (line1 != null && line2 != null && !dif) {

					if(line1.length() == line2.length()) {//Comprueba que son de la misma longitud
						if (line1.equals(line2))//Comprueba si son iguales entre ellos
							contChars += line1.length(); //Si son iguales se suma la longitud de la linea al contador de caracteres
						else {
							contChars += counter(line1, line2);//En el caso de que las lineas no sean iguales, se llama al metodo counter, este busca el error contando los caracteres
						}
						
					}
					else {
						if(line1.length() > line2.length()) { //Si las lineas difieren en tamano, se comprueba cual es la mayor
							contChars += counter(line2, line1);
							dif = true; //Se pone en true para salir del while porque ya se ha encontrado el error
						}
						else {
							contChars += counter(line1, line2);
							dif = true;
						}
					}
					line1 = in.readLine(); //Se avanza en las lineas
					line2 = in2.readLine();
					
					if(line1 == null || line2 == null) { //Se comprueba las siguientes lineas para saber si un texto tiene mas que otras
						contChars++; //Se suma +1 al contador para indicar la primera diferencia
						contL++;//Se suma uno al contador de las lineas porque el while no va a continuar
						hayNull = true; //Boolean que sirve para indicar la aparicion de un null.
					}
					
					contL++;
					
				}
				
				if(dif || hayNull) {
					System.out.println("Linea: "+contL);
					System.out.println("Char: "+contChars);
				}
				else
					System.out.println("NO DIFFERS");

			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

	public static void main(String[] args){
		comp("texto1", "texto2");
		
	}

}

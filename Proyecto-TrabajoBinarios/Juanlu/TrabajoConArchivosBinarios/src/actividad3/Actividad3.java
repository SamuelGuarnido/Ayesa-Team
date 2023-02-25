package actividad3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Instant;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class Actividad3 {

	private static TreeMap<Instant, Integer> mapa = new TreeMap<>();
	
	
	private static int readInteger() {
		int num=0;
		boolean b = true;
		do {
			try {
				num = new Scanner(System.in).nextInt();
				b = false;
			}catch(InputMismatchException ex) {
				System.err.println("Debes escribir un número entero");
			}
			
		}while(b);
		return num;
	}
	
	private static void insertar(int num) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ficheros\\Actividad3.dat"))){
			
			
				mapa.put(Instant.now(), num);
				out.writeObject(mapa);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void check() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("ficheros\\Actividad3.dat"))){
			
			mapa = (TreeMap<Instant, Integer>) in.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		check();
		int num=0;
		do {
			try {
				System.out.println("1. Insertar número de llamadas");
				System.out.println("2. Ver listado completo");
				System.out.println("3. Salir");
				num = readInteger();
				
				switch(num) {
				case 1: 
					System.out.println("Escribe el número de llamadas:");
					int n = readInteger();
					insertar(n);
					break;
				case 2: System.out.println(mapa);
					break;
				case 3: System.out.println("Gracias por utilizar el programa ;)");
					break;
				default: System.out.println("Opción incorrecta, seleccione una opción correcta");
					break;
				}
				
			}catch (InputMismatchException ex) {
				ex.printStackTrace();
			}	
		}while(num != 3);
		
		
	}

}

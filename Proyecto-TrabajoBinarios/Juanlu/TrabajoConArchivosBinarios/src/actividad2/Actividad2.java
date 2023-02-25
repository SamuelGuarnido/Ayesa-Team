package actividad2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Actividad2 implements Serializable{
	
	private static void write() {
		String cadena="";
		String texto="";
		//List<String> texto = new ArrayList<>();
		System.out.println("El programa termina cuando presiones intro sin escribit nada\n"
				+ "Escribe lo que quieras: ");
		do {
			
			texto = new Scanner(System.in).nextLine();
			cadena += texto +" ";
			//texto.add(cadena);	
		}while ( texto != "");
		System.out.println("terminado");

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ficheros\\actividad2.dat"))){
			out.writeObject(cadena);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void read() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("ficheros\\actividad2.dat"))){

			System.out.println((String) in.readObject());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		write();
		read();

		
	}

}

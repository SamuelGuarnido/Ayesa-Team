package ejercicio2;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Ejercicio2 implements Serializable {


	
	
	
	
	
	public static void main(String[] args) {
	
		boolean switc= true;
		
		System.out.println("introduzca las lineas que desee");
		
		try (ObjectOutputStream flujoCarga = new ObjectOutputStream(new FileOutputStream("clientes.dat"));
				ObjectInputStream flujoDescarga = new ObjectInputStream(new FileInputStream("clientes.dat"));
						Scanner teclado=new Scanner(System.in)) {
			
		
			
			String linea = teclado.nextLine();
			String texto=linea + "\n" ;
			while(linea!=("")){
		
				linea = teclado.nextLine();
				 texto+=linea + "\n" ;
				
			}//while
			
			flujoCarga.writeObject(texto);
			System.out.println( (String) flujoDescarga.readObject());
			
		}//try
		catch (IOException ex) {System.out.println(ex.getMessage());} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

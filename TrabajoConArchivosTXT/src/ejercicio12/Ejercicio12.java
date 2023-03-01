package ejercicio12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Ejercicio12 {

	public static ArrayList<Persona> listaAgenda= new ArrayList<Persona>();
	
	public static void agregar(String nom, String tlf) {
		
		boolean agregado=false; 
		
	
		if(Ejercicio12.listaAgenda.size()>0) {	//este condicional mira si hay objetos en la array list
			
			for(int i=0; i<=Ejercicio12.listaAgenda.size()-1 && i>=0; i++){//con este for recorremos la array list en busca de nombres que coincidan 
			
				if(Ejercicio12.listaAgenda.get(i).getNom().equals(nom)) {
					
					agregado=true;
					
					i=-10;//forzamos la dentención del bucle 
				}
			}
		}
		
		if(agregado==true) {
			System.out.println("Error: El nombre "+nom+" ya ha sido agregado con anterioridad.");}
		else {
			Ejercicio12.listaAgenda.add(new Persona(nom, tlf));//este constructor añade un objeto de tipo persona a la lista con los datos que introduzca el usuario
		System.out.println(nom+" ha sido agregado a la agenda.");
		}
	}
	

	public static void busqueda(String tresLetras) {//con este metodo buscaremos el nombre en base a la cadena que envie el usuario
		
		System.out.println("Busqueda relaccionada con las letras ("+tresLetras+")");
		
		boolean alguno=false;
		
		if(Ejercicio12.listaAgenda.size()>0) {//este condicional mira si hay objetos en la array list
			
			for(int i=0; i<=Ejercicio12.listaAgenda.size()-1 && i>=0; i++){//con este for recorremos la array list en busca de los nombres cuyas tres primeras letras coincidan con las dadas
			
				
				if(tresLetras.length()<=Ejercicio12.listaAgenda.get(i).getNom().length()) {//este condicional comprueba si la cadena  que se han introducido no es  más grande que el nombre para evitar errores de indices
					
					String nom = Ejercicio12.listaAgenda.get(i).getNom().substring(0, tresLetras.length());
			
					if(nom.equals(tresLetras)) {
						System.out.println(Ejercicio12.listaAgenda.get(i));
						alguno = true;
					}
				}
				
			}
		}else System.out.println("Todavia no hay contactos en la agenda");
		
		
		if(alguno==false) {System.out.println("Ninguno nombre coincide con las letras introducidas "+tresLetras);}
	}
		
	
	
	
	public static void main(String[] args) {
		
		
		
		
		/*
		 * declaramos 3 flujos dos referentes al documento agenda.txt (entrada y salida)
		 * y uno dedicado a recoger información del teclado.
		 */
		try(BufferedWriter out = new BufferedWriter(new FileWriter("ficheros\\agenda.txt", true));
			BufferedReader in = new BufferedReader(new FileReader("ficheros\\agenda.txt"));
			Scanner teclado = new Scanner(System.in))
			{
			
			String linea = in.readLine();
			
			
			while (linea != null) {
				
				//System.out.println(linea);
				
				String[] separado = linea.split(" ");
				
				
				Ejercicio12.listaAgenda.add(new Persona(separado[1], separado[4]));
				
				//System.out.println(separado[1]);
				//System.out.println(separado[4]);
				
				linea = in.readLine();
				
			} 
			
			
			
			
	
			int salir=0;
			
			
			while(salir==0) {//este bucle hace que el programa se mantenga activo hasta que se use la opción 4
				
				System.out.println("**********************************************************************");
				System.out.println("1-Nuevo contacto");
				System.out.println("2-Buscar por nombre");
				System.out.println("3-Mostrar todos");
				System.out.println("4-Salir");
				System.out.println("**********************************************************************");
				
				int caso = teclado.nextInt();
				
				switch (caso) {
				
				case 1: {
				
					
					System.out.println("Introduzca el nombre de la persona que desea guardar");
					String nom = teclado.next();
					
					System.out.println("Introduzca el numero de "+ nom);
					String tlf = teclado.next();
					
					agregar(nom, tlf);
					
					
					break;
				}
				case 2:{
					
					System.out.println("Introduzca los 3 primeros caracteres del contacto que deseas buscar");
					
					String bus=teclado.next();
					
					busqueda(bus);
					
					break;
				}
				case 3:
					
					System.out.println("***********************LISTA DE CONTACTOS*****************************");
					
					if(Ejercicio12.listaAgenda.size()>0) {	//este condicional mira si hay objetos en la array list
						
						for(int i=0; i<=Ejercicio12.listaAgenda.size()-1 && i>=0; i++){//con este for recorremos la array list
						System.out.println(Ejercicio12.listaAgenda.get(i));
						}
					}else System.out.println("No hay contactos registrados");
					break;
				
				case 4: 	
					
					
					if(Ejercicio12.listaAgenda.size()>0) {	//este condicional mira si hay objetos en la array list
						
						for(int i=0; i<=Ejercicio12.listaAgenda.size()-1 && i>=0; i++){//con este for recorremos la array list
							out.write(Ejercicio12.listaAgenda.get(i).toString());//escribimos en el documeto de texto una la cadena que contiene el nombre y el numero utilizando el toString de Personas_Varios_12
							out.newLine();//pasamos a la siguente linea
						}
					}
					
					System.out.println("Contactos nuevos guardados en memoria");
					
					salir=1;
					break;
				
				
				}
				
				
				
			}
			System.out.println("programa terminado");
			
		}
		
		catch (IOException ex) {
			System.out.println(ex.getMessage());
			
		}
		catch (InputMismatchException ex) {
			System.out.println("Error: debes de introducir un entero");
		}
	}
	
}

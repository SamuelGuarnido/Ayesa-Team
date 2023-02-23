package ejercicio3;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
import outBinario.MyObjectOutputStream;

@SuppressWarnings("serial")
public class Ejercicio3 implements Serializable{

	private static File archivo = new File("C:\\Users\\samue\\eclipse-workspace\\Unidad5\\ficheros\\binarios\\varios\\listaLlamadas.dat");
	
	private int numLla;
	private LocalDate fecha;
	private static String agenda = "";

	@Override
	public String toString() {
		return "\n--Datos\n Número de llamadas: " + numLla + "\n Fecha: " + fecha + "\n";
	}

	private Ejercicio3(int tef) {
		this.numLla = tef;
		this.fecha = LocalDate.now();
	}

	private static void leer() {

		Ejercicio3 obj;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"C:\\Users\\samue\\eclipse-workspace\\Unidad5\\ficheros\\binarios\\varios\\listaLlamadas.dat"))) {

			while (true) {
				obj = (Ejercicio3) in.readObject();
				agenda = agenda + obj;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException eofe) {
			System.out.println("Carga de datos completa");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	private static void numLlam(int a) {

		Ejercicio3 ll = new Ejercicio3(a);
		agenda = agenda + ll;

		try (MyObjectOutputStream out = new MyObjectOutputStream(
				"C:\\Users\\samue\\eclipse-workspace\\Unidad5\\ficheros\\binarios\\varios\\listaLlamadas.dat")) {
			out.writeObject(ll);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void menu() {
		
		if(archivo.exists())
			leer();
		
		byte num = 0;
		do {

			System.out.println("**Menú**");
			System.out.println("1. Agregar datos del día");
			System.out.println("2. Ver datos generales");
			System.out.println("3. Salir");
			num = new Scanner(System.in).nextByte();

			switch (num) {

			case 1:
				System.out.println("Número de llamadas: ");
				numLlam(new Scanner(System.in).nextInt());
				break;
			case 2:
				if(archivo.exists())
					System.out.println(agenda);
				else
					System.out.println("No hay ningún registro");
				break;
			case 3:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida");
				break;

			}

		} while (num != 3);

	}

	public static void main(String[] args) {
		menu();
	}

}

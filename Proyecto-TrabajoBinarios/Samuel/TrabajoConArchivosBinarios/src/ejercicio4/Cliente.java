package ejercicio4;

import java.io.EOFException;
import java.io.File;
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

public class Cliente implements Serializable{

	private static File archivo = new File(
			"C:\\Users\\samue\\eclipse-workspace\\TrabajoConArchivosBinarios\\ficheros\\varios\\agendaClientes.dat");
	private static Scanner sc = new Scanner(System.in);

	private int id;
	private String nombre;
	private int telf;

	private static List<Cliente> clientes = new ArrayList<>();

	private Cliente(int id, String name, int tel) {
		this.id = id;
		this.nombre = name;
		this.telf = tel;
	}

	@Override
	public String toString() {
		return "Datos: \n -Id: " + id + "\n -Nombre: " + nombre + "\n -Teléfono: " + telf + "\n";
	}

	private static void leer() {

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {

			while (true) {
				clientes = (List<Cliente>) in.readObject();
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

	private static void agregarCliente() {

		int id = 0;
		do {
			System.out.println("Indique el id: ");
			id = sc.nextInt();
			sc.nextLine();
		} while (id < 0);

		System.out.println("Indique el nombre completo: ");
		String name = sc.nextLine();

		int tel = 0;
		do {
			System.out.println("Indique el número de teléfono: ");
			tel = sc.nextInt();
		} while (tel < 0);

		clientes.add(new Cliente(id, name, tel));

	}

	private static void muestraLista() {
		if (clientes.size() > 0) {
			for (int i = 0; i < clientes.size(); i++) 
				System.out.println(i + "-> " + clientes.get(i));
		}else
			System.out.println("No hay datos");
	}

	private static void modCliente() {
		if (clientes.size() > 0) {
			muestraLista();
			System.out.println("Indique basandose en el índice del cliente a modificar: ");
			byte it = sc.nextByte();

			byte opc = 0;
			do {

				System.out.println("\n==Menu de modificaciones==\n");
				System.out.println("1. ID");
				System.out.println("2. Nombre");
				System.out.println("3. Teléfono");
				System.out.println("4. Salir");
				opc = sc.nextByte();
				sc.nextLine();

				switch (opc) {

				case 1:
					System.out.println("Indique el nuevo id: ");
					clientes.get(it).id = sc.nextInt();
					break;
				case 2:
					System.out.println("Indique el nuevo nombre: ");
					clientes.get(it).nombre = sc.nextLine();
					break;
				case 3:
					System.out.println("Indique el nuevo numero de teléfono: ");
					clientes.get(it).telf = sc.nextInt();
					break;
				case 4:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción inválida");
					break;
				}

			} while (opc != 4);
		}else
			System.out.println("No hay datos");

	}

	private static void darDeBaja() {
		if(clientes.size() > 0) {
			muestraLista();
			System.out.println("Indique el cliente a modificar basandose en los índices: ");
			clientes.remove(sc.nextByte());
		}
		else
			System.out.println("No hay datos");
	}

	private static void listarClientes() {
		if (clientes.size() > 0)
			for (Cliente c : clientes)
				System.out.println(c);
		else
			System.out.println("No hay datos");
	}

	private static void guardarDatos() {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {

			out.writeObject(clientes);
			System.out.println("Datos guardados.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void menu() {
		if (archivo.exists())
			leer();

		byte opc = 0;
		do {
			System.out.println("\n==Menú==\n");
			System.out.println("1. Agregar cliente");
			System.out.println("2. Modificar datos");
			System.out.println("3. Dar de baja a un cliente");
			System.out.println("4. Listar los clientes");
			System.out.println("5. Salir");
			opc = sc.nextByte();

			switch (opc) {
			case 1:
				agregarCliente();
				break;
			case 2:
				modCliente();
				break;
			case 3:
				darDeBaja();
				break;
			case 4:
				listarClientes();
				break;
			case 5:
				guardarDatos();
				System.out.println("Saliendo...");

			}

		} while (opc != 5);

	}

	public static void main(String[] args) {
		menu();
	}

}

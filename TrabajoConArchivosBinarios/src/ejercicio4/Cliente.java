package actividad4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Cliente implements Serializable{

	private int identificador;
	private String nombre;
	private int telefono;
	private  static List<Cliente> listado = new ArrayList<>();
	
	/**
	 * Constructor de la clase Cliente
	 * @param identificador Parametro de tipo int correspondiente con el identificador del cliente
	 * @param nombre Paramentro de tipo String correspondiente con el nombre del cliente
	 * @param telefono Parametro de tipo int correspondiente con el telefono del cliente
	 */
	private Cliente(int identificador, String nombre, int telefono) {
		this.setIdentificador(identificador);
		this.setNombre(nombre);
		this.setTelefono(telefono);
	}
	/**
	 * Metodo de obtencion del identificador del cliente
	 * @return identificador de tipo int
	 */
	private int getIdentificador() {
		return identificador;
	}
	/**
	 * Metodo de establecimiento del identificador del cliente
	 * @param identificador Parametro de tipo int correspondiente con el identificador del cliente
	 */
	private void setIdentificador(int identificador) {
		boolean b = true;
		do {
			if(!checkClient(identificador)) {
				this.identificador = identificador;	
				b = false;
			}else {
				System.err.println("Ese identificador ya está en uso");
				System.out.println("Escribe otro identificador");
				identificador = readInteger();
			}
		}
		while(b);
	}
	/**
	 * Metodo de obtencion del nombre del cliente
	 * @return nombre de tipo String
	 */
	private String getNombre() {
		return nombre;
	}
	/**
	 * Metodo de establecimiento del nombre del cliente
	 * @param nombre Paramentro de tipo String correspondiente con el nombre del cliente
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo de obtencion del telefono del cliente
	 * @return telefono de tipo int
	 */
	private int getTelefono() {
		return telefono;
	}
	/**
	 * Metodo de establecimiento del telefono del cliente
	 * @param telefono Parametro de tipo int correspondiente con el telefono del cliente
	 */
	private void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/**
	 * Metodo que sobreescribe el metodo toString para el objeto de tipo Cliente
	 */
	@Override
	public String toString() {
		return "Identificador: " + this.getIdentificador()+ ", Nombre: " + this.getNombre()+ ", Teléfono: " + this.getTelefono()+ "\n";
	}

	/**
	 * Metodo que devuelve un numero entero después de controlar las excepciones
	 * @return num de tipo int
	 */
	private static int readInteger() {
		int num = 0;
		boolean b = true;
		do {
			try {
				num = new Scanner(System.in).nextInt();
				b = false;
			}catch(InputMismatchException ex) {
				ex.printStackTrace();
			}
		}while(b);
		return num;
	}
	/**
	 * Metodo que añade un cliente nuevo a la lista de clientes
	 */
	private static void addClient() {
		System.out.println("Escriba los datos en el siguiente orden: \nIdentificador\nNombre\nTelefono ");
		int id = readInteger();
		String nom = new Scanner(System.in).next();
		int telf = readInteger();
		
		Cliente c = new Cliente(id, nom, telf);
		
		listado.add(c);
	}
	/**
	 * Metodo que comprueba si el cliente ya se encuentra en la lista comprobando el identificador
	 * ya que el id tiene que ser unico de cada cliente
	 * @param id Parametro de tipo int correspondiente con el identificador del cliente
	 * @return Devuelve un boolean, false si no está en la lista y true si se encuentra en la lista
	 */
	private static boolean checkClient(int id) {
		boolean b = false;
		for(Cliente c: listado) {
			if(c.getIdentificador() == id) {
				b = true;
			}
		}
		return b;
	}
	/**
	 * Metodo que muestra un menu con varias modificaciones posibles
	 * @param c Parametro de tipo Cliente correspondiente con el cliente que se quiere modificar
	 * Evidentemente se pasa la referencia al objeto, por lo que se modifica directamente
	 */
	private static void menuModify(Cliente c) {
		int op = 0;
		do {
			System.out.println("1. Modificar identificador");
			System.out.println("2. Modificar nombre");
			System.out.println("3. Modificar telefono");
			System.out.println("4. Salir");
			op = readInteger();
			switch(op) {
			case 1:	System.out.println("Escribe el nuevo identificador"); 
				c.setIdentificador(readInteger());
				break;
			case 2: System.out.println("Escribe el nuevo nombre");
				c.setNombre(new Scanner(System.in).nextLine());
				break;
			case 3: System.out.println("Escribe el nuevo número de teléfono");
				c.setTelefono(readInteger());
				break;
			case 4: System.out.println("Gracias por utilizar el submenú ;)");
				break;
			default: System.out.println("Opción incorrecta");
				break;
			}
		}while(op != 4);
	}
	/**
	 * Metodo para modificar un cliente, comprueba que el cliente exista en la lista y luego utiliza el metodo
	 * menuModify pasandole como parametro el cliente que se quiere eliminar 
	 */
	private static void modifyClient() {
		System.out.println("Escriba el identificador del cliente que quiere modificar");
		int id = readInteger();
		if(checkClient(id)) {
			for(Cliente c: listado) {
				if(c.getIdentificador() == id) {
					menuModify(c);
				}
			}
		}else System.out.println("El cliente no se encuentra en el listado");
	}
	/**
	 * Metodo para dar de baja al cliente cuyo identificador diga el usuario
	 */
	private static void bajaCliente() {
		System.out.println("Escriba el identificador del cliente que quiere dar de baja");
		int id = readInteger();
		if(checkClient(id)) {
			Iterator<Cliente> it = listado.iterator();
			while(it.hasNext()) {
				Cliente c = it.next();
				if(c.getIdentificador() == id) {
					it.remove();
				}
			}
		}else System.out.println("El cliente no se encuentra en el listado");
	}
	
	/**
	 * Metodo que lee del archivo todos los datos y los introduce en el listado
	 */
	private static void check() {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("ficheros\\Actividad4.dat"))){
			listado = (List<Cliente>) in.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Se creará un archivo nuevo cuando salga del programa");
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}
	/**
	 * Metodo para guardar los cambios realizados en el archivo
	 */
	private static void save() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ficheros\\Actividad4.dat"))){
			out.writeObject(listado);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo que muestra el menu principal del programa.
	 * Primero recarga la lista con los datos que haya guardados en el archivo,
	 * luego lleva a cabo el programa en si y por ultimo guarda todos los datos de la lista en el archivo
	 */
	public static void menu() {
		
		check();
		
		int op = 0;
		
		do {
			System.out.println("1. Añadir nuevo cliente");
			System.out.println("2. Modificar datos");
			System.out.println("3. Dar de baja a un cliente");
			System.out.println("4. Listar los clientes");
			System.out.println("5. Salir");
			op = readInteger();
			
			switch(op) {
			case 1: addClient();
				break;
			case 2: modifyClient();
				break;
			case 3: bajaCliente();
				break;
			case 4: System.out.println(listado);
				break;
			case 5: System.out.println("Gracias por utilizar el programa ;)");
				break;
			default: System.out.println("Opcion Incorrecta");
				break;
			}
		}while(op!= 5);
		
		save();
	}
}

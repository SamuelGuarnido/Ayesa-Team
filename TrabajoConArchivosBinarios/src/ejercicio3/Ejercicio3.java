package ejercicio3;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CallTracker {
	private ArrayList<Integer> calls;
	private final String FILENAME = "ficheros//llamadas.dat";

	public CallTracker() {
		calls = new ArrayList<Integer>();
	}

	public void addCalls(int numCalls) {
		calls.add(numCalls);
	}

	public void viewCalls() {
		for (int i = 0; i < calls.size(); i++) {
			System.out.println("Día " + (i + 1) + ": " + calls.get(i));
		}
	}

	public void saveCalls() {
		try {
			FileOutputStream fos = new FileOutputStream(FILENAME);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(calls);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void loadCalls() {
		try (FileInputStream fis = new FileInputStream(FILENAME);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			calls = (ArrayList<Integer>) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Clase no encontrada");
			c.printStackTrace();
			return;
		}
	}

	public static void main(String[] args) {
		CallTracker callTracker = new CallTracker();
		Scanner teclado = new Scanner(System.in);

		callTracker.loadCalls();

		int option = 0;
		while (option != 3) {
			System.out.println("Menu:");
			System.out.println("1. Añadir llamadas");
			System.out.println("2. Ver llamadas");
			System.out.println("3. Salir");

			option = teclado.nextInt();

			switch (option) {
			case 1:
				System.out.println("Introducir número de llamadas:");
				int numCalls = teclado.nextInt();
				callTracker.addCalls(numCalls);
				break;
			case 2:
				callTracker.viewCalls();
				break;
			case 3:
				callTracker.saveCalls();
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}
		}
		teclado.close();
	}
}

package ejercicio1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio1 {

	public static void main(String[] args) {

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"C:\\Users\\samue\\eclipse-workspace\\Unidad5\\ficheros\\binarios\\varios\\numDouble.dat"))) {

			double num = 0;
			while (true) {
				num = in.readDouble();
				System.out.println(num);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException eofe) {
			System.out.println("Fin del fichero");
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

}

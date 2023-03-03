package ej1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
public class Ejercicio1 implements Serializable {
	public static void main(String[] args) {
		try(ObjectInputStream entrada=
			new ObjectInputStream(new FileInputStream("ficheros\\doubles.dat"))){
			double[]dobleArray= (double[]) entrada.readObject();
			for(int i=0; i<dobleArray.length; i++) {
				System.out.println(dobleArray[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}

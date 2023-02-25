package actividad1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Actividad1 {

	public static void main(String[] args) {

		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("ficheros//doubles.dat"))){

			System.out.println(Arrays.toString((double[]) in.readObject()));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

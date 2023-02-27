package ej8910;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class encriptador {
	static String cifrar(String aCifrar, String alfabeto, String cifrado) {
		String cif = "";
		int indiceChar = 0;
		for(int i = 0; i < aCifrar.length(); i++) {
			indiceChar = alfabeto.indexOf(aCifrar.charAt(i));
			cif = cif + cifrado.charAt(indiceChar);
		}
		return cif;
	}
	public static void main(String[] args) {
			try(BufferedReader in1 = new BufferedReader(
					new FileReader("C:\\ejemplos\\codec.txt"))){
				String alfabeto =" abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
				String cifrado = in1.readLine();
				String line = "", txt = "";
				try(BufferedReader in = new BufferedReader(
						new FileReader("C:\\ejemplos\\codec.txt"))){
					line = in.readLine();
					while(line != null) {
						txt = cifrar(line, alfabeto, cifrado) + "\n";
						line = in.readLine();
					}
					try(BufferedWriter out = new BufferedWriter(
							new FileWriter("C:\\ejemplos\\codet.txt"))){
						out.write(txt);
					}
					catch(IOException ioe) {
						System.out.println(ioe.getMessage());
					}
				}
				catch(IOException ioe) {
					System.out.println(ioe.getMessage());
				}
			}
			catch(IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
}
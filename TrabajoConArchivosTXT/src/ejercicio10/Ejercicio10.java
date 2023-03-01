package ejercicio10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Ejercicio10 {
	static final int tamMat=3;
    public static void main(String[] args) {
        File archivo = null;
        FileReader Fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("ficheros\\matriz.txt");
            Fr = new FileReader(archivo.toString());
            br = new BufferedReader(Fr);
            String linea;
            String limitador = " ";
            String matriz[][] = new String[tamMat][tamMat];
            int numlinea=0;
            while (((linea = br.readLine()) != null)) {
                String texto[]=linea.split(limitador);
                for (int i = 0; i < texto.length; i++) {
                    matriz[numlinea][i]=texto[i];
                } 
                numlinea++;
            }
               for(int filas = 0; filas < matriz.length; filas++) {
                    for(int colum = 0; colum < matriz[filas].length; colum++) {
                        System.out.print(matriz[colum][filas]+" ");
                    }
                    System.out.println();   
                }
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}

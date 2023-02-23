package outBinario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MyObjectOutputStream extends ObjectOutputStream{
	private static boolean existeArchivo;
	
	private static FileOutputStream createFile(String path) throws IOException{
		if(new File(path).exists()) existeArchivo = true;
		return new FileOutputStream(path, true);
	}
	
	public MyObjectOutputStream(String path) throws IOException{
		super(createFile(path));
	}
	
	@Override
	protected void writeStreamHeader() throws IOException{
		 if(!existeArchivo)
			 super.writeStreamHeader();
	}
}

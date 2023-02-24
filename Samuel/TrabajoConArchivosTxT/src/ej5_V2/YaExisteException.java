package ej5_V2;

@SuppressWarnings("serial")
public class YaExisteException extends Exception{


	public String toString() {
		return "Error: esa entrada ya existe";
	}
}

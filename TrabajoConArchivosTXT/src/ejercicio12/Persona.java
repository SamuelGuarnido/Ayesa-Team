package ejercicio12;

public class Persona {

		private String nombre;
		private String tlfn;
		
		//getters
		public String getNom() {return this.nombre;}
		public String getTlf() {return this.tlfn;}
		
		//costructor
		public Persona(String nombre, String tlfn) {
			this.nombre = nombre;
			this.tlfn = tlfn;
		}

		//toString
		public String toString()  {
			return "Nombre: "+this.getNom()+" / Telefono: "+this.getTlf();
		}
		
		
		
		


}

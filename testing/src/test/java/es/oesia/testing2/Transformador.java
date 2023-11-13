package es.oesia.testing2;

import es.oesia.testing.Clase;

public class Transformador {

	private LectorFichero lector;

	public LectorFichero getLector() {
		return lector;
	}

	public void setLector(LectorFichero lector) {
		this.lector = lector;
	}

	public Transformador(LectorFichero lector) {
		super();
		this.lector = lector;
	}

	public Clase getClase() {
		return null;
		
	}
	
	
}

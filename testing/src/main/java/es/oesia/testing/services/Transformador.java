package es.oesia.testing.services;

import java.io.FileNotFoundException;
import java.util.List;

import es.oesia.testing.models2.Alumno;
import es.oesia.testing.models2.Clase;
import es.oesia.testing.models2.Nota;

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

	public Clase getClase() throws FileNotFoundException {

		Clase clase = new Clase();
		List<String> lineas = lector.leer();
		lineas.removeIf((linea) -> linea.contains("*"));

		Alumno alumno;

		for (String linea : lineas) {

			if (!linea.contains("-")) {
				// parto la linea
				String[] datosLinea = linea.split(",");
				String nombre= datosLinea[0];
				String asignatura= datosLinea[1];
				String valorNota= datosLinea[2];
				
				if (clase.containsAlumno(nombre)) {
					alumno=clase.getAlumnoPorNombre(nombre);
				} else {
					alumno = new Alumno();
					alumno.setNombre(nombre);
					clase.addAlumno(alumno);
				}
				Nota nota = new Nota(Double.parseDouble(valorNota), asignatura);
				alumno.addNota(nota);

							
			}
		}

		return clase;

	}

}

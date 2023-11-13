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
				// genero el alumno

				if (clase.getAlumnos().contains(new Alumno(datosLinea[0]))) {
					
					
					int posicion=clase.getAlumnos().indexOf(new Alumno(datosLinea[0]));
					alumno=clase.getAlumnos().get(posicion);
					Nota nota = new Nota(Double.parseDouble(datosLinea[2]), datosLinea[1]);
					
					alumno.addNota(nota);
					//clase.addAlumno(alumno);

				} else {

					alumno = new Alumno();
					alumno.setNombre(datosLinea[0]);
					Nota nota = new Nota(Double.parseDouble(datosLinea[2]), datosLinea[1]);
					// añado al alumno la nota
					alumno.addNota(nota);
					clase.addAlumno(alumno);


				}
				

							
			}
		}

		return clase;

	}

}

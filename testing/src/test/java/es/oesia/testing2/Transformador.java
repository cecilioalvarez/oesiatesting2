package es.oesia.testing2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import es.oesia.testing.Alumno;
import es.oesia.testing.Clase;
import es.oesia.testing.Nota;

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

		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		List<String> lineas = lector.leer();
		lineas.removeIf((linea) -> linea.contains("*"));

		Alumno alumno;

		for (String linea : lineas) {

			if (!linea.contains("-")) {
				// parto la linea
				String[] datosLinea = linea.split(",");
				// genero el alumno

				if (listaAlumnos.contains(new Alumno(datosLinea[0]))) {
					
					
					int posicion=listaAlumnos.indexOf(new Alumno(datosLinea[0]));
					alumno=listaAlumnos.get(posicion);
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

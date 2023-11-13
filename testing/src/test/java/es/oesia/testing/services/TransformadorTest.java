package es.oesia.testing.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.oesia.testing.models2.Alumno;
import es.oesia.testing.models2.Clase;
import es.oesia.testing.services.LectorFichero;
import es.oesia.testing.services.Transformador;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TransformadorTest {
	
	
	//ahora mismo se parece mas a una prueba de integración
	// que a una prueba unitaria
	// porque estamos probando varias clases juntas
	//estamos probando LectorFichero y Transformador

	@Test
	void getClaseTest() throws FileNotFoundException {
		
		LectorFichero lector= new LectorFichero(new File("src/test/resources/datosalumnos.txt"));
		Transformador tf= new Transformador(lector);
		Clase clase=tf.getClase();
		List<Alumno> alumnos= clase.getAlumnos();
		
		assertThat(2,equalTo(alumnos.size()));
	}

}

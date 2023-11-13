package es.oesia.testing;

import java.util.List;

import org.junit.jupiter.api.Test;

import es.oesia.testing2.LectorFichero;
import es.oesia.testing2.Transformador;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TransformadorTest {

	@Test
	void getClaseTest() {
		
		LectorFichero lector= new LectorFichero(null);
		Transformador tf= new Transformador(lector);
		Clase clase=tf.getClase();
		List<Alumno> alumnos= clase.getAlumnos();
		assertThat(2,equalTo(alumnos.size()));
	}

}

package es.oesia.testing.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import es.oesia.testing.models2.Alumno;
import es.oesia.testing.models2.Clase;
import es.oesia.testing.models2.Nota;

@ExtendWith(MockitoExtension.class)
class TransformadorTest {

	// ahora mismo se parece mas a una prueba de integración
	// que a una prueba unitaria
	// porque estamos probando varias clases juntas
	// estamos probando LectorFichero y Transformador

	@Mock
	LectorFichero lector;

	@Test
	void getClaseTest() throws FileNotFoundException {

		List<String> lineas = new ArrayList<String>();

		lineas.add("******************");
		lineas.add("antonio,matematicas,7.5");
		lineas.add("antonio,lengua,8");
		lineas.add("-----------------");
		lineas.add("gema,matematicas,5");
		lineas.add("gema,lengua,9");
		lineas.add("******************");

		// simula el comportamiento del lector
		Mockito.when(lector.leer()).thenReturn(lineas);

		Transformador tf = new Transformador(lector);
		Clase clase = tf.getClase();
		List<Alumno> alumnos = clase.getAlumnos();
		Alumno antonio = alumnos.get(0);
		Alumno gema = alumnos.get(1);

		assertThat(2, equalTo(alumnos.size()));

		assertThat (antonio.getNombre(),equalTo("antonio"));
		assertThat (gema.getNombre(),equalTo("gema"));
		
		assertThat (gema.getNotas().get(0),equalTo(new Nota(5,"matematicas")));
		assertThat (gema.getNotas().get(1),equalTo(new Nota(9,"lengua")));

		assertThat (antonio.getNotas().get(0),equalTo(new Nota(7.5,"matematicas")));
		assertThat (antonio.getNotas().get(1),equalTo(new Nota(8,"lengua")));

		assertThat (gema.getNotas().get(0),equalTo(new Nota(5,"matematicas")));
		assertThat (gema.getNotas().get(1),equalTo(new Nota(9,"lengua")));

	}

}

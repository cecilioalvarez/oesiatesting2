package es.oesia.testing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.oesia.testing2.LectorFichero;

class LectorFicheroTest {

	@Test
	void leerTest() throws FileNotFoundException {
		
		LectorFichero lector= new LectorFichero(new File("src/test/resources/datosalumnos.txt"));
		List<String> lineas = lector.leer();
		
		assertThat(7,equalTo(lineas.size()));
		
	}



}

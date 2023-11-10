package es.oesia.testing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ClaseTest {

	@Test
	void addAlumnoTest() {
		
		Alumno pedro = new Alumno("pedro");
		Alumno juan = new Alumno("juan");
		List<Alumno> lista= new ArrayList<>();
		Clase clase = new Clase(1,lista);
		
		clase.addAlumno(new Alumno("ana"));
		
		assertThat(clase.getAlumnos(),hasItem(new Alumno("ana")));
		
	}

}

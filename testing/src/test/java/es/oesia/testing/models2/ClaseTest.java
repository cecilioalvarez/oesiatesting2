package es.oesia.testing.models2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import es.oesia.testing.models2.Alumno;
import es.oesia.testing.models2.Clase;
import es.oesia.testing.models2.Nota;

class ClaseTest {

	@Test
	void addAlumnoTest() {
		
		Alumno pedro = new Alumno("pedro");
		Alumno juan = new Alumno("juan");
		List<Alumno> lista= new ArrayList<>();
		lista.add(pedro);
		lista.add(juan);
		Clase clase = new Clase(1,lista);
		
		clase.addAlumno(new Alumno("ana"));
		
		assertThat(clase.getAlumnos(),hasItem(new Alumno("ana")));
		
	}

	

	@Test
	void mejorNotaClase() {
		
		Alumno pedro =Mockito.mock(Alumno.class);
		Mockito.when(pedro.getMejorNota()).thenReturn(new Nota(10,"Matematicas"));
		
		Alumno david = Mockito.mock(Alumno.class);
		Mockito.when(david.getMejorNota()).thenReturn(new Nota(3,"Matematicas"));

		
		List<Alumno> lista= new ArrayList<>();
		lista.add(pedro);
		lista.add(david);
		
		Clase clase = new Clase(1,lista);
		assertThat(clase.getMejorNota(),equalTo(new Nota(10,"Matematicas")));
		
	}

}

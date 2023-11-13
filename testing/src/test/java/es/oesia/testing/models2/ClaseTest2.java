package es.oesia.testing.models2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
class ClaseTest2 {

	@Mock Alumno alumno1;
	@Mock Alumno alumno2;
	
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
		
	
		Mockito.when(alumno1.getMejorNota()).thenReturn(new Nota(10,"Matematicas"));
		Mockito.when(alumno2.getMejorNota()).thenReturn(new Nota(3,"Matematicas"));
		List<Alumno> lista= new ArrayList<>();
		lista.add(alumno1);
		lista.add(alumno2);
		
		Clase clase = new Clase(1,lista);
		assertThat(clase.getMejorNota(),equalTo(new Nota(10,"Matematicas")));
		
	}
	
	@Test
	void containsAlumno() {
		
	
		
		List<Alumno> lista= new ArrayList<>();
		lista.add(new Alumno("pepe"));
		
		Clase clase = new Clase(1,lista);
		boolean contiene=clase.containsAlumno("pepe");
		assertTrue(contiene);
		
	}

}

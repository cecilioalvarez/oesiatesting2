package es.oesia.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	@Test
	void addNotaAlumno() {
		
		Alumno alumno= new Alumno("pedro");
		
		alumno.addNota(new Nota(7,"Matematicas"));
		List<Nota> notas=alumno.getNotas();
		
		assertEquals(1,notas.size());
	}

}

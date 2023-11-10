package es.oesia.testing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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
		lista.add(pedro);
		lista.add(juan);
		Clase clase = new Clase(1,lista);
		
		clase.addAlumno(new Alumno("ana"));
		
		assertThat(clase.getAlumnos(),hasItem(new Alumno("ana")));
		
	}

	

	@Test
	void mejorNotaClase() {
		
		Alumno pedro = new Alumno("pedro");
		pedro.addNota(new Nota(7,"Matematicas"));
		pedro.addNota(new Nota(6,"Lengua"));
		pedro.addNota(new Nota(5,"Fisica"));
		pedro.addNota(new Nota(9,"Ingles"));
		
		Alumno david = new Alumno("david");
		david.addNota(new Nota(3,"Matematicas"));
		david.addNota(new Nota(4,"Lengua"));
		david.addNota(new Nota(10,"Fisica"));
		david.addNota(new Nota(7,"Ingles"));
		
	
		List<Alumno> lista= new ArrayList<>();
		lista.add(pedro);
		lista.add(david);
		Clase clase = new Clase(1,lista);
		
		clase.addAlumno(new Alumno("ana"));
		
		assertThat(clase.getMejorNota(),equalTo(new Nota(10,"Fisica")));
		
	}

}

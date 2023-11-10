package es.oesia.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest2 {

	Alumno alumno;
	@BeforeEach
	public void iniciar() {
		
		List<Nota> listaNotas=new ArrayList<Nota>();
		listaNotas.add(new Nota(0,"Lengua"));
		listaNotas.add(new Nota(5,"Matematicas"));
		listaNotas.add(new Nota(4,"Lengua"));
		listaNotas.add(new Nota(7,"Historia"));
		listaNotas.add(new Nota(8,"Matematicas"));
		listaNotas.add(new Nota(10,"Matematicas"));

		alumno= new Alumno("pedro",listaNotas);
	}
	
	@Test
	void addNotaAlumno() {
		
		Nota notaNueva= new Nota(7.5,"Historia");
		alumno.addNota(notaNueva);
		List<Nota> notas=alumno.getNotas();
		//assertTrue(notas.contains(notaNueva));
		assertThat(notas,hasItem(notaNueva));
		
	}

	//aqui
	@Test
	void removeNotaAlumno() {
		
		Nota notaEliminar= new Nota(0,"Lengua");
		alumno.removeNota(notaEliminar);
		List<Nota> notas=alumno.getNotas();
		assertThat(notas,not(hasItem(notaEliminar)));
	}

	//concretamente para mi test
	@Test
	void numeroAprobadosAlumno() {
	
		alumno= new Alumno("juan",List.of(new Nota(3,"Matematicas"),new Nota(7,"Lengua")));
		int aprobados= alumno.getNumeroAprobados();
		assertThat(aprobados,equalTo(1));
	}
	@AfterEach
	public void finalizar() {
		
		alumno=null;
	}

}

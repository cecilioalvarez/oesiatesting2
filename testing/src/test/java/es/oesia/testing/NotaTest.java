package es.oesia.testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.oesisa.testing.Nota;

class NotaTest {

	// FIRST (Fast, Isolated,Repeatable, SelfValidating, Timely)
	
	
	@Test
	@DisplayName("valor de nota en rango")
	void rangoDeValoresNotaCorrecto() {
		
		Nota nota1= new Nota();
		
		assertThrows(RuntimeException.class,()->nota1.setValor(-10));
		assertThrows(RuntimeException.class,()->nota1.setValor(11));
	}
	
	@Test
	@DisplayName("igualdad entre dos notas")
	void igualdadEntreDosNotas() {
		
		Nota nota1= new Nota(7,"Matematicas");
		Nota nota2= new Nota(7,"Matematicas");
		
		boolean notasIguales= nota1.equals(nota2);
		
		assertTrue(notasIguales);
		
	}
	
	@Test
	@DisplayName("no igualdad entre dos notas por valor")
	void noIgualdadValor() {
		
		Nota nota1= new Nota(7,"Matematicas");
		Nota nota2= new Nota(8,"Matematicas");
		
		boolean noIgualesValor= nota1.equals(nota2);
		
		assertFalse(noIgualesValor);
		
	}
	@Test
	@DisplayName("no igualdad entre dos notas por asignatura")
	void noIgualdadAsignatura() {
		
		Nota nota1= new Nota(8,"Fisica");
		Nota nota2= new Nota(8,"Matematicas");
		
		boolean noIgualesAsignatura= nota1.equals(nota2);
		
		assertFalse(noIgualesAsignatura);
		
	}
	
	@Test
	@DisplayName("una nota es mayor que otra")
	void unaNotaEsMayorQueOtra() {
		
		Nota nota1= new Nota(8,"Fisica");
		Nota nota2= new Nota(9,"Matematicas");
		
		boolean esNotaMayor= nota2.esMayor(nota1);
		
		assertTrue(esNotaMayor);
		
	}

}

package es.oesia.testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.oesisa.testing.Nota;

class NotaTest {

	@Test
	@DisplayName("igualdad entre dos notas")
	void igualdadEntreDosNotas() {
		//arrange
		Nota nota1= new Nota(7,"Matematicas");
		Nota nota2= new Nota(7,"Matematicas");
		//act
		boolean notasIguales= nota1.equals(nota2);
		
		assertTrue(notasIguales);
		
	}
	
	@Test
	@DisplayName("no igualdad entre dos notas por valor")
	void noIgualdadValor() {
		//arrange
		Nota nota1= new Nota(7,"Matematicas");
		Nota nota2= new Nota(8,"Matematicas");
		//act
		boolean noIgualesValor= nota1.equals(nota2);
		
		assertFalse(noIgualesValor);
		
	}
	@Test
	@DisplayName("no igualdad entre dos notas por asignatura")
	void noIgualdadAsignatura() {
		//arrange
		Nota nota1= new Nota(8,"Fisica");
		Nota nota2= new Nota(8,"Matematicas");
		//act
		boolean noIgualesAsignatura= nota1.equals(nota2);
		
		assertFalse(noIgualesAsignatura);
		
	}
	
	@Test
	@DisplayName("una nota es mayor que otra")
	void unaNotaEsMayorQueOtra() {
		//arrange
		Nota nota1= new Nota(8,"Fisica");
		Nota nota2= new Nota(9,"Matematicas");
		//act
		boolean esNotaMayor= nota2.esMayor(nota1);
		
		assertTrue(esNotaMayor);
		
	}

}

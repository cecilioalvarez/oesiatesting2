package es.oesia.testing.models2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.oesia.testing.models2.Nota;

class NotaTest {

	// FIRST (Fast, Isolated,Repeatable, SelfValidating, Timely)
	//BICEP  (Boundaries,InverseRelation,cross-check, Errors,Performance)
	
	
	
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

	
	@Test
	@DisplayName("una nota tiene un tipo Bien")
	void laNotaEsUnBien() {
		
		
		//boundaries o limites
		Nota notaEs6= new Nota(6,"Fisica");
		
		Nota notaEs5= new Nota(5,"Fisica");
		Nota notaEs4Con9= new Nota(4.9,"Fisica");
		Nota notaEs6Con9= new Nota(6.9,"Fisica");
		Nota notaEs7= new Nota(7,"Fisica");
	
		
		Nota.Tipo tipoBienCon6= notaEs6.getTipo();
		Nota.Tipo tipoBienCon5= notaEs5.getTipo();
		Nota.Tipo tipoNoBienCon49= notaEs4Con9.getTipo();
		Nota.Tipo tipoNoBienCon69= notaEs6Con9.getTipo();
		Nota.Tipo tipoNoBienCon7= notaEs7.getTipo();
		
		//un metodo puede llevar varios assert
		
		assertEquals(Nota.Tipo.BIEN,tipoBienCon6);
		assertEquals(Nota.Tipo.BIEN,tipoBienCon5);
		assertEquals(Nota.Tipo.BIEN,tipoNoBienCon69);
		
		
		assertNotEquals(Nota.Tipo.BIEN,tipoNoBienCon49);
		assertNotEquals(Nota.Tipo.BIEN,tipoNoBienCon7);
		
	}
	
	
}

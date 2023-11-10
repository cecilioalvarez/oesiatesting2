package es.oesia.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.oesisa.testing.Calculadora;

class CalculadoraTest {

	@Test
	@DisplayName("sumar dos elementos")
	void calculadorSumar() {
		
		Calculadora c= new Calculadora();
		
		double suma=c.sumar(2, 2);
		
		assertEquals(4,suma);
		
	}
	
	@Test
	@DisplayName("restar dos elementos")
	void calculadorRestar() {
		
		Calculadora c= new Calculadora();
		
		double resta=c.restar(2, 4);
		
		assertEquals(-2,resta);
		
	}

}

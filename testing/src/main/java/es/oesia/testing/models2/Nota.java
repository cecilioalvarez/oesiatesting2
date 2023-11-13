package es.oesia.testing.models2;

import java.util.Objects;

public class Nota {

	private double valor;
	private String asignatura;

	public enum Tipo {

		MUYDEFICIENTE, INSUFICIENTE, BIEN, NOTABLE, SOBRESALIENTE
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if (valor >= 0 && valor <= 10)
			this.valor = valor;
		else
			throw new RuntimeException("la nota no es valida");
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public Nota(double valor, String asignatura) {
		super();
		this.valor = valor;
		this.asignatura = asignatura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asignatura, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(asignatura, other.asignatura)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}

	public boolean esMayor(Nota nota2) {

		return this.getValor() > nota2.getValor();
	}

	public Nota() {
		super();
	}

	public Tipo getTipo() {

		if (getValor() >= 0 && getValor() < 3) {
			// retorno una enumaci�n
			return Tipo.MUYDEFICIENTE;
		} else if (getValor() >= 3 && getValor() < 5) {
			return Tipo.INSUFICIENTE;
		} else if (getValor() >= 5 && getValor() < 7) {
			return Tipo.BIEN;
		} else if (getValor() >= 7 && getValor() < 9) {
			return Tipo.NOTABLE;
		} else {
			return Tipo.SOBRESALIENTE;
		}
	}

}

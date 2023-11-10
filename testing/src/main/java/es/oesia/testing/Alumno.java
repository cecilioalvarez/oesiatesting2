package es.oesia.testing;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

	private String nombre;
	private List<Nota> notas = new ArrayList<Nota>();

	
	
	
	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public void addNota(Nota nota) {

		notas.add(nota);
	}

	public void removeNota(Nota nota) {

		notas.remove(nota);
	}
}

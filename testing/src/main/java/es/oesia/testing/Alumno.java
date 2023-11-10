package es.oesia.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {

	private String nombre;
	private List<Nota> notas = new ArrayList<Nota>();


	public Alumno(String nombre, List<Nota> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}

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
	
	public int getNumeroAprobados() {
		int aprobados=0;
		for (Nota nota: notas) {
			
			if (nota.getValor()>=5) {
				aprobados++;
			}
		}
		return aprobados;
	}
	
	public Nota getMejorNota() {
		
		
		Nota mejorNota= notas.get(0);
		
		for (Nota nota: notas) {
			
			if (nota.getValor()>mejorNota.getValor()) {
				
				mejorNota=nota;
			}
		}
		return mejorNota;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}

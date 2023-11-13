package es.oesia.testing.models2;

import java.util.ArrayList;
import java.util.List;

public class Clase {

	private int numero;
	private List<Alumno> alumnos= new ArrayList<Alumno>();
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void addAlumno(Alumno alumno) {
		
		alumnos.add(alumno);
	}
	public Clase(int numero, List<Alumno> alumnos) {
		super();
		this.numero = numero;
		this.alumnos = alumnos;
	}
	
	public Clase() {
		// TODO Auto-generated constructor stub
	}
	public Nota getMejorNota() {
		
		Nota notaMejor = new Nota(0,"Matematicas");
		for (Alumno a: alumnos) {
			
			if (a.getMejorNota().esMayor(notaMejor)) {
				
				notaMejor=a.getMejorNota();
			}
		}
		return notaMejor;
	}
}

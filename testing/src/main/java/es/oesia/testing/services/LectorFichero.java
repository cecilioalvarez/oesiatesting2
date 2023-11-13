package es.oesia.testing.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LectorFichero {

	private File fichero;

	public File getFichero() {
		return fichero;
	}

	public void setFichero(File fichero) {
		this.fichero = fichero;
	}

	public LectorFichero(File fichero) {
		super();
		this.fichero = fichero;
	}

	public List<String> leer() throws FileNotFoundException {
		
		Path ruta= fichero.toPath();
		try {
			return Files.readAllLines(ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException("el fichero no existe");
		}
	}
}

package es.oesia.testing2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		List<String> lineas = new ArrayList<String>();
		try (Scanner scanner = new Scanner(fichero)) {
			while (scanner.hasNextLine()) {

				String linea = scanner.nextLine();
				lineas.add(linea);
			}
		}
		return lineas;
	}
}

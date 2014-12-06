package net.erickpineda.MatriculaCoche;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Erick Pineda Método principal para el programa de leer matriculas.
 *
 */
public class App {
	public static void main(String[] args) {
		matriculasCoche("/matriculas.txt");

	}

	/**
	 * Método que se encarga de leer el fichero de texto.
	 * 
	 * @param fichero
	 *            Path al fichero que se leerá
	 */
	public static void matriculasCoche(String fichero) {

		BufferedReader br = null;
		InputStream entrada = App.class.getResourceAsStream(fichero);

		if (entrada != null) {
			Reader leer = new InputStreamReader(entrada);
			br = new BufferedReader(leer);

			String lineaFichero = null;
			clausulasM(br, lineaFichero);
		} else {
			System.out.println("***NO SE HA PODIDO LEER EL FICHERO***");
		}
	}

	/**
	 * Método que recoge las cláusulas try/catch del programa.
	 * 
	 * @param br
	 *            Para leer el fichero de texto
	 * @param linea
	 *            Variable que recogera en String el path del fichero
	 */
	public static void clausulasM(BufferedReader br, String linea) {

		try {
			linea = br.readLine();

			matriculas(br, linea);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método que se encarga de hacer las distintas operaciones del programa, y
	 * compara que se cumplan una serie de reglas especificas para luego
	 * mostrarlas por pantalla.
	 * 
	 * @param br
	 *            Para leer el fichero de texto
	 * @param linea
	 *            Variable que recogera en String el path del fichero
	 * @throws IOException
	 *             Ya otro método se encargará de las cláusulas del programa.
	 */
	public static void matriculas(BufferedReader br, String linea)
			throws IOException {

		while (linea != null) {

			String[] array = linea.split(" ");

			// No leerá lineas que no contengan nada
			if (!linea.trim().equals("")) {

				// Expresion regular que la línea del fichero deberá cumplir
				Pattern exre = Pattern.compile("[0-9]{4}( )[A-Za-z]{2,3}");
				Matcher mat = exre.matcher(linea);

				if (mat.matches()) {
					System.out.print(array[1] + " " + array[0] + "\n");
				}
			}
			linea = br.readLine();
		}
	}

}

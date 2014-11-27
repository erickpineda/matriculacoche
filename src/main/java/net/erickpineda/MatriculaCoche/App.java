package net.erickpineda.MatriculaCoche;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		matriculasCoche("/matriculas.txt");

	}

	public static void matriculasCoche(String fichero) {

		BufferedReader br = null;
		InputStream entrada = App.class.getResourceAsStream(fichero);

		if (entrada != null) {
			Reader leer = new InputStreamReader(entrada);
			br = new BufferedReader(leer);

			String lineaFichero;

			try {
				lineaFichero = br.readLine();

				while (lineaFichero != null) {

					String[] array = lineaFichero.split(" ");
					for (int i = array.length - 1; i >= 0; i--) {

						System.out.print(array[i]);

					}
					System.out.println(" ");
					lineaFichero = br.readLine();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

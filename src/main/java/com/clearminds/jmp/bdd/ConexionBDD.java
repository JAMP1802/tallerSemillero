/**
 * 
 */
package com.clearminds.jmp.bdd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Jonathan Morocho
 * Clase que establece una conexión con la base de datos
 */
public class ConexionBDD {

	public static String leerPropiedad(String propiedad) {
		Properties p = new Properties();
		String valor = null;
		try {
			p.load(new FileReader("conexion.properties"));
			valor = p.getProperty(propiedad);
			return valor;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {			
			e.printStackTrace();
			return null;
		}
	}
}

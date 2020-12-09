/**
 * 
 */
package com.clearminds.jmp.bdd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.clearminds.jmp.excepciones.BDDException;

/**
 * @author Jonathan Morocho
 * Clase que establece una conexión con la base de datos
 */
public class ConexionBDD {

	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	/**
	 * Método que lee las propiedades de la BD
	 * @param propiedad parametro con la propiedad a obtener
	 * @return el valor de la propiedad o null en caso de no existir o si ocurre una excepción
	 */
	public static String leerPropiedad(String propiedad) {
		Properties p = new Properties();
		String valor = null;
		try {
			p.load(new FileReader("conexion.properties"));
			valor = p.getProperty(propiedad);
			return valor;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return valor;
		} catch (IOException e) {			
			e.printStackTrace();
			return valor;
		}
	}
	
	public static Connection obtenerConexion() throws BDDException  {
		// 1. Leer propiedades 
		String usuario = leerPropiedad("usuario");
		String password = leerPropiedad("password");
		String urlConexion = leerPropiedad("urlConexion");
		
		Connection conn = null;
	
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(urlConexion, usuario, password);
		} catch (Exception e) { 
			e.printStackTrace();
			throw new BDDException("No se pudo conectar a la base de datos.");
		}		
		
		return conn;
	}
}

package com.clearminds.jmp.servicios;

import java.sql.Connection;
import java.sql.SQLException;

import com.clearminds.jmp.bdd.ConexionBDD;
import com.clearminds.jmp.excepciones.BDDException;

public class ServicioBase {

	private Connection conexion;
	
	public void abrirConexion() throws BDDException{
		conexion = ConexionBDD.obtenerConexion();
	}
	
	public void cerrarConexion(){
		if(conexion != null){
			try {
				conexion.close();
				System.out.println("Conexion cerrada");
			} catch (SQLException e) { 
				e.printStackTrace();
				System.out.println("Error al cerrar conexión.");
			}
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	
}

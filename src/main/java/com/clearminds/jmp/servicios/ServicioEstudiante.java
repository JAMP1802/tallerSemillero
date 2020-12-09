package com.clearminds.jmp.servicios;

import com.clearminds.jmp.dtos.Estudiante;
import com.clearminds.jmp.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase{

	public void insertarEstudiante(Estudiante estudiante) throws BDDException{
		//1. Abre conexion a la bd
		abrirConexion();
		System.out.println("Insertando estudiante: " + estudiante);
		cerrarConexion();
	}
}

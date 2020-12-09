package com.clearminds.jmp.servicios.test;

import com.clearminds.jmp.dtos.Estudiante;
import com.clearminds.jmp.excepciones.BDDException;
import com.clearminds.jmp.servicios.ServicioEstudiante;

public class TestActualizar {

	public static void main(String[] args) {
		
		ServicioEstudiante srvEstudiante = new ServicioEstudiante();
		try {
			srvEstudiante.actualizarEstudiante(new Estudiante(2,"Pedro", "Navaja"));
		} catch (BDDException e) {			
			e.printStackTrace();
			e.getMessage();
		}

	}

}

package com.clearminds.jmp.servicios;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.clearminds.jmp.dtos.Estudiante;
import com.clearminds.jmp.excepciones.BDDException;
import com.clearminds.jmp.util.DateUtil;

public class ServicioEstudiante extends ServicioBase{

	public void insertarEstudiante(Estudiante estudiante) throws BDDException{
		//1. Abre conexion a la bd
		abrirConexion();
		System.out.println("Insertando estudiante: " + estudiante);
		
		Statement stmt = null;
		try {
			stmt = getConexion().createStatement();
			Date fechaSistema = new Date();
			String sql = "insert into estudiantes(nombre, apellido, edad, fecha_modificacion) values ('"+
			estudiante.getNombre()+"', '"+estudiante.getApellido()+"', " + estudiante.getEdad() +", '"+ DateUtil.convertitfecha(fechaSistema) + "')";
			
			System.out.println("Script: " + sql);
			
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar estudiante");
		}
		
	}
	
	public void actualizarEstudiante(Estudiante estudiante) throws BDDException{
		abrirConexion();
		System.out.println("Actualizando estudiante: " + estudiante);
		
		Statement stmt = null;
		try {
			stmt = getConexion().createStatement();
			Date fechaSistema = new Date();
			String sql = "update estudiantes set nombre='"+estudiante.getNombre()+"', apellido='"+estudiante.getApellido()+
					"', edad=" + estudiante.getEdad() + ", fecha_modificacion= '"+DateUtil.convertitfecha(fechaSistema)+"' where id="+estudiante.getId()+"";
			
			System.out.println("Script: " + sql);
			
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar estudiante");
		}
	}
}

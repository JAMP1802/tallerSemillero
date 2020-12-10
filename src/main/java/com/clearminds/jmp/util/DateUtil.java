package com.clearminds.jmp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final String FORMATO_COMPLETO = "yyyy-MM-dd HH:mm:ss";

	public static String convertitfecha(Date date) { 
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_COMPLETO);
		String fechaFormateada = sdf.format(fecha);
		return fechaFormateada;
	}
}

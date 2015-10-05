package br.usjt.caixaeletronico.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Data {
	DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

	public String getData() {
		Date date = new Date();
		return formatoData.format(date);
	}

	public String getHora() {
		Calendar cal = Calendar.getInstance();
		return formatoHora.format(cal.getTime());
	}
}

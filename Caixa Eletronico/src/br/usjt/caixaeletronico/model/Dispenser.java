package br.usjt.caixaeletronico.model;

import java.util.ResourceBundle;

public class Dispenser {
	public static String getRelatorioNotas(ResourceBundle resourceBundle) {
		return resourceBundle.getString("Dispenser.existem") + " 10 " + resourceBundle.getString("Dispenser.notasDe") + " "  + resourceBundle.getString("UnidadeMonetaria") + " 10,00\n" + 
			   "10 " + resourceBundle.getString("Dispenser.notasDe") + " " + resourceBundle.getString("UnidadeMonetaria") + " 20,00\n" + 
			   "10 " + resourceBundle.getString("Dispenser.notasDe") + " "  + resourceBundle.getString("UnidadeMonetaria") + " 50,00\n" +
			   "10 " + resourceBundle.getString("Dispenser.notasDe") + " "  + resourceBundle.getString("UnidadeMonetaria") + " 100,00";
	}
}

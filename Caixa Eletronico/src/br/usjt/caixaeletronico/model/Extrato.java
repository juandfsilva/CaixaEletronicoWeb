package br.usjt.caixaeletronico.model;

import java.util.ResourceBundle;

public class Extrato {

	public static String getExtrato(ResourceBundle resourceBundle, int days) {
		return  resourceBundle.getString("Login.agencia") + " 00-0000\n"+
				resourceBundle.getString("Login.conta") + " 000000-00\n"+
				resourceBundle.getString("Extrato.periodo1") + " "+days+" " + resourceBundle.getString("Extrato.dias") +"\n\n\n"+				
				resourceBundle.getString("Extrato.totalCreditos") + " ----------------------6.500,00\n"+
				resourceBundle.getString("Extrato.TransferenciasIN") + " -------------500,00\n"+
				resourceBundle.getString("Extrato.salario") + " --------------------4.000,00\n"+
				resourceBundle.getString("Extrato.restituicao") + " --------500,00\n"+
				resourceBundle.getString("Extrato.outrosCreditos") + " ------------------------1.500,00\n"+
				resourceBundle.getString("Extrato.totalDebitos") + " -----------------------9.081,43\n"+
				resourceBundle.getString("Extrato.saques") + " -----------------------50,00\n"+
				resourceBundle.getString("Extrato.cheques") + " --------------------600,50\n"+
				resourceBundle.getString("Extrato.comprasDebito") + " -----------477,21\n"+
				resourceBundle.getString("Extrato.transferenciasOUT") + " ------------5.853,78\n"+
				resourceBundle.getString("Extrato.CPMF") + " -----------------------------------24,49\n"+
				resourceBundle.getString("Extrato.outrosDebitos") + " -------------------------2.075,45\n"+
				"------------------------------------------------\n" +
				resourceBundle.getString("Extrato.saldoCC") + " ----------------690,63\n"+
				resourceBundle.getString("Extrato.saldoCI") + " 28/02 ---1.600,35\n"+
				resourceBundle.getString("Extrato.limiteCheque") + " --------------4.500,00\n"+
				resourceBundle.getString("Extrato.saldoTotal") + " ----------------------------6.790,98\n";

	}
}

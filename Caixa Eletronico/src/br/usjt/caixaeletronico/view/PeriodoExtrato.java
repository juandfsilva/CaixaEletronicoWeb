package br.usjt.caixaeletronico.view;

public class PeriodoExtrato extends MenuTemplate {
	private static String[] buttonsText = { "Ultimos 7 Dias", "Ultimos 14 dias", "Outro Periodo", "Cancelar" };
	public PeriodoExtrato() {
		super("Deseja acessar o extrato de que periodo?", "", buttonsText);
	}
}

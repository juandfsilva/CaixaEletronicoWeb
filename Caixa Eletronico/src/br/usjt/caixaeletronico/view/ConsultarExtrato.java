package br.usjt.caixaeletronico.view;

public class ConsultarExtrato extends ConsultarTemplate {
	
	private static String[] buttonsText = { "Voltar", "Extrato", "Imprimir" };
	public ConsultarExtrato(String periodo) {
		super(periodo, "Extrato", buttonsText, 1);
		String text = "Carlinhos Ribero\n26/09 - 300R$";
		super.tA.setText(text);
		
	}

}

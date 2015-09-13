package br.usjt.caixaeletronico.view;

public class Saque extends MenuTemplate {
	private static String[] buttonsText = {"R$ 10,00", "R$ 20,00", "R$ 50,00", 
											"R$ 100,00","R$ 200,00", "R$ 500,00",
												"Outro Valor", "Cancelar"};
	public Saque() {
		super("Saque", "Quanto deseja sacar ?", buttonsText);
	}


}

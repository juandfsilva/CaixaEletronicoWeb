package br.usjt.caixaeletronico;

import br.usjt.caixaeletronico.view.CadTransfTemplate;

public class CadastroDebitoAutom extends CadTransfTemplate{
	
	private static String[] buttonsText = { "Cadastrar", "Voltar"};
	private static String[] labelsText = { "Conta:", "Agencia:", "Valor:"};
	public CadastroDebitoAutom() {
		// TODO Auto-generated constructor stub
		super("Cadastro de Débito Automático", "Débito Automático", labelsText, buttonsText);
	}

}

package br.usjt.caixaeletronico.view;

public class MenuPrinc extends MenuTemplate {
	private static String[] buttonsText = {"Debito Automatico", "Saque", 
												"Extrato","Saldo", 
													"Transferencia", "Sair"};
	
	public MenuPrinc()
	{
		super("Menu Principal", "Bem vindo ao Banco São Judas",buttonsText);
	}
	

}

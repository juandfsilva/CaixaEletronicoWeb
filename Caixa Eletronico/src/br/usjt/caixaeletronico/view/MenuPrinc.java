package br.usjt.caixaeletronico.view;

import java.util.ResourceBundle;

public class MenuPrinc extends MenuTemplate {

	public MenuPrinc(ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Menu.titulo"),
				resourceBundle.getString("0"), new String[] {
				resourceBundle.getString("AutoDebt.titulo"),
				resourceBundle.getString("Saque.titulo"),
				resourceBundle.getString("Extrato.titulo"),
				resourceBundle.getString("Saldo.titulo"),
				resourceBundle.getString("Transferencia.titulo"),
				resourceBundle.getString("Sair") });
	}

}

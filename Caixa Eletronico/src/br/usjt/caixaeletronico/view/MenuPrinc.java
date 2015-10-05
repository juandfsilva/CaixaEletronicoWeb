package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import br.usjt.caixaeletronico.control.Utils;

public class MenuPrinc extends MenuTemplate {

	public MenuPrinc(ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Menu.titulo"),//Titulo
				resourceBundle.getString("0"), //Descricao
				new String[] {//array de botoes
				resourceBundle.getString("AutoDebt.titulo"),
				resourceBundle.getString("Saque.titulo"),
				resourceBundle.getString("Extrato.titulo"),
				resourceBundle.getString("Saldo.titulo"),
				resourceBundle.getString("Transferencia.titulo"),
				resourceBundle.getString("Sair") });
		final JFrame actual = this;
		super.buttons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarSaldo saldo = new ConsultarSaldo(Utils.resource);
				saldo.setVisible(true);
				actual.dispose();
			}
		});
		
		
		
	}
}

package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class Saque extends MenuTemplate {
	public Saque(final ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Saque.titulo"), resourceBundle
				.getString("Saque.quanto"), new String[] {
				resourceBundle.getString("UnidadeMonetaria") + " 10,00",
				resourceBundle.getString("UnidadeMonetaria") + " 20,00",
				resourceBundle.getString("UnidadeMonetaria") + " 50,00",
				resourceBundle.getString("UnidadeMonetaria") + " 100,00",
				resourceBundle.getString("UnidadeMonetaria") + " 200,00",
				resourceBundle.getString("UnidadeMonetaria") + " 500,00",
				resourceBundle.getString("Saque.outroValor"),
				resourceBundle.getString("Voltar") });

		// botão outro saque
		buttons[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OutroSaq obj = new OutroSaq(resourceBundle);
				obj.setVisible(true);

			}
		});

		// botão voltar
		buttons[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});

	}

}

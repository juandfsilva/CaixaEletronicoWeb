package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import br.usjt.caixaeletronico.model.Extrato;

public class ConsultarExtrato extends ConsultarTemplate {

	public ConsultarExtrato(ResourceBundle resourceBundle, String periodo, int days) {
		super(periodo, resourceBundle.getString("Extrato.desc"), new String[] {
				resourceBundle.getString("Voltar"), resourceBundle.getString("Extrato"),
				resourceBundle.getString("Imprimir") }, 1);
		String text = Extrato.getExtrato(days);
		tA.setText(text);

		// Button voltar
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();// Fecha uma janela

			}
		});

		// Button extrato
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		// Button Imprimir
		buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

}

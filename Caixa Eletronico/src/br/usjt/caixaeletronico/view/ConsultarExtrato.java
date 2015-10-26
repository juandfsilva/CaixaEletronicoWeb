package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import br.usjt.caixaeletronico.control.Utils;
import br.usjt.caixaeletronico.model.Extrato;

public class ConsultarExtrato extends ConsultarTemplate {

	public ConsultarExtrato(final ResourceBundle resourceBundle, String periodo, int days) {
		super(periodo, resourceBundle.getString("Extrato.desc"), new String[] { resourceBundle.getString("Voltar"),
				resourceBundle.getString("Extrato"), resourceBundle.getString("Imprimir") }, 1);
		String text = Extrato.getExtrato(resourceBundle, days);
		String model = resourceBundle.getString("Extrato.template");
		String saldo = resourceBundle.getString("Extrato.saldoTotal") +" "+ resourceBundle.getString("UnidadeMonetaria")
				+" "+ Utils.objConta.getSaldo();
		tA.setText(model + "\n\n" + text+"\n\n\n"+saldo);

		// Button voltar
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarExtrato.this.dispose();// Fecha uma janela
				MenuPrinc men = new MenuPrinc(resourceBundle);
				men.setVisible(true);
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

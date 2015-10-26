package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.usjt.caixaeletronico.control.ContaCtrl;

public class Saque extends MenuTemplate {
	public Saque(final ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Saque.titulo"), resourceBundle.getString("Saque.quanto"),
				new String[] { resourceBundle.getString("UnidadeMonetaria") + " 10,00",
						resourceBundle.getString("UnidadeMonetaria") + " 20,00",
						resourceBundle.getString("UnidadeMonetaria") + " 50,00",
						resourceBundle.getString("UnidadeMonetaria") + " 100,00",
						resourceBundle.getString("UnidadeMonetaria") + " 200,00",
						resourceBundle.getString("UnidadeMonetaria") + " 500,00",
						resourceBundle.getString("Saque.outroValor"), resourceBundle.getString("Voltar") });

		final int valores[] = { 10, 20, 50, 100, 200, 500 };
		String rep = resourceBundle.getString("UnidadeMonetaria") + " ";
		final ContaCtrl contaCtrl = new ContaCtrl();
		// Saque
		final ResourceBundle rb = resourceBundle;
		for (int i = 0; i < 6; ++i) {
			final int j = i;
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int saque = contaCtrl.Saque(valores[j]);
					if (saque == 1) {
						JOptionPane.showMessageDialog(null, resourceBundle.getString("sucesso"));
						Saque.this.dispose();
						MenuPrinc mp = new MenuPrinc(resourceBundle);
						mp.setVisible(true);
					} else if (saque == -1) {
						JOptionPane.showMessageDialog(null, resourceBundle.getString("Transferencia.semSaldo"));
					} else {
						JOptionPane.showMessageDialog(null, resourceBundle.getString("erro"));
					}
				}
			});

			// botão outro saque
			buttons[6].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OutroSaq obj = new OutroSaq(resourceBundle);
					obj.setVisible(true);
					Saque.this.dispose();

				}
			});

			// botão voltar
			buttons[7].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MenuPrinc mp = new MenuPrinc(resourceBundle);
					mp.setVisible(true);
					Saque.this.dispose();
				}
			});

		}
	}
}

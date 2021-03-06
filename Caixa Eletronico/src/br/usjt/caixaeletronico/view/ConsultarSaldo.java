package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import br.usjt.caixaeletronico.control.ContaCtrl;
import br.usjt.caixaeletronico.control.Utils;
import br.usjt.caixaeletronico.model.Conta;

public class ConsultarSaldo extends ConsultarTemplate {

	public ConsultarSaldo(final ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Saldo.titulo"), resourceBundle.getString("Saldo.desc"),
				new String[] { // Botoes
						resourceBundle.getString("Voltar"), resourceBundle.getString("Extrato"),
						resourceBundle.getString("Imprimir") },
				0);
		ContaCtrl ctrl = new ContaCtrl(); 
		// Texto de dento do Text Area
		tA.setText(resourceBundle.getString("Login.agencia") + ": " + Utils.objConta.getAgencia() + "\n"
				+ resourceBundle.getString("Login.conta") + ": " + Utils.objConta.getConta() + "\n"
				+ resourceBundle.getString("Saldo.data") + ": " + Utils.data.getData() + "\n\n"
				+ resourceBundle.getString("Saldo.titulo") + ": " + resourceBundle.getString("UnidadeMonetaria")
				+ Utils.objConta.getSaldo());

		final JFrame actual = this;

		super.buttons[0].addActionListener(new ActionListener() {// Botão Voltar

			@Override
			public void actionPerformed(ActionEvent e) {
				actual.dispose();
				MenuPrinc menuPrinc = new MenuPrinc(resourceBundle);
				menuPrinc.setVisible(true);
			}
		});

		super.buttons[1].addActionListener(new ActionListener() {// Botão
																	// Extrato

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		super.buttons[2].addActionListener(new ActionListener() {// Botão
																	// Imprimir

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}

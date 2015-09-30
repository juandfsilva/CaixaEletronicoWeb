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

public class ConsultarSaldo extends ConsultarTemplate {

	public ConsultarSaldo(ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Saldo.titulo"), resourceBundle
				.getString("Saldo.desc"), new String[] {
				resourceBundle.getString("Voltar"), resourceBundle.getString("Extrato"),
				resourceBundle.getString("Imprimir") }, 0);
		tA.setText(resourceBundle.getString("Login.agencia") + ": " + "0000-00\n"+
				resourceBundle.getString("Login.conta") + ": " + "000000-00\n"+
				resourceBundle.getString("Saldo.data") + ": " + "21/12/2012\n\n"+
				resourceBundle.getString("Saldo.titulo") + ": " + "R$-1000,00");
	}
}

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
	String text = "Agencia: 0000-00\nConta: 000000-00\nData:21/12/2012\n\nSaldo atual: R$-1000,00";

	public ConsultarSaldo(ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Saldo.titulo"), resourceBundle
				.getString("Saldo.desc"), new String[] {
				resourceBundle.getString("Voltar"), resourceBundle.getString("Extrato"),
				resourceBundle.getString("Imprimir") }, 0);
		tA.setText(text);
	}
}

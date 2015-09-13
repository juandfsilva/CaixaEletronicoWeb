package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
//Marco eh viadão
public class ConsultarSaldo extends ConsultarTemplate {
	private static String[] buttons = { "Voltar", "Extrato", "Imprimir" };
	String text = "Agencia: 0000-00\nConta: 000000-00\nData:21/12/2012\n\nSaldo atual: R$-1000,00";
	public ConsultarSaldo() {
		super("Saldo", "Saldo Atual", buttons, 0);
		super.tA.setText(text);
		
	}
}

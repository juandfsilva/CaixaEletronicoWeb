package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ConsultarSaldo extends JFrame {
	public ConsultarSaldo() {
		super("Saldo");
		String[] buttons = { "Voltar", "Extrato", "Imprimir" };
		Container c = getContentPane();	
		Container buttonContainer = new Container();
		buttonContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
		Container textContainer = new Container();
		textContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 8));
		
		JTextPane tA = new JTextPane();
		tA.setText("Agência: 0000-00\nConta: 000000-00\nData:21/12/2012\n\nSaldo atual: R$-1000,00");
		tA.setEditable(false);
		JScrollPane jsp = new JScrollPane(tA);
		jsp.setPreferredSize(new Dimension(400, 300));
		textContainer.add(jsp);
		
		JButton b = new JButton(buttons[0]);
		buttonContainer.add(b);
		b = new JButton(buttons[1]);
		buttonContainer.add(b);
		b = new JButton(buttons[2]);
		buttonContainer.add(b);
		c.add(buttonContainer, BorderLayout.SOUTH);
		c.add(textContainer, BorderLayout.CENTER);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
	}
}

package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
//Marco eh viadão
public class ConsultarSaldo extends ConsultarTemplate {
	private static String[] buttonsText = { Messages.getString("ConsultarSaldo.0"), Messages.getString("ConsultarSaldo.1"), Messages.getString("ConsultarSaldo.2") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	String text = "Agencia: 0000-00\nConta: 000000-00\nData:21/12/2012\n\nSaldo atual: R$-1000,00"; //$NON-NLS-1$
	public ConsultarSaldo() {
		super(Messages.getString("ConsultarSaldo.3"), Messages.getString("ConsultarSaldo.4"), buttonsText, 0); //$NON-NLS-1$ //$NON-NLS-2$
		tA.setText(text);
	}
}

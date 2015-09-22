package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Mensagem extends JFrame {
	public Mensagem(ResourceBundle resourceBundle, String titulo, String mensagem)
	{
		super(titulo);
		Container c = getContentPane();
		//c.setLayout(new GridLayout(2, 1, 8, 8));
		JTextPane jtp = new JTextPane();
		jtp.setText(mensagem);
		jtp.setEditable(false);
		JScrollPane jsp = new JScrollPane(jtp);
		c.add(jsp, BorderLayout.CENTER);
		Container c2 = new Container();
		c2.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
		JButton close = new JButton(resourceBundle.getString("Fechar"));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setAlwaysOnTop(true);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Mensagem.this.dispose();
			}
		});
		c2.add(close);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		c.add(c2, BorderLayout.SOUTH);
		setSize(800, 600);
		setLocationRelativeTo(null);
	}
}

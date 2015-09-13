package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ConsultarTemplate extends JFrame {
		
	protected JButton[] buttons;
	protected JTextPane tA;
	
	public ConsultarTemplate(String titulo, String[] buttonsText) {
		// TODO Auto-generated constructor stub
		super(titulo);
		Container c = getContentPane();	
		Container buttonContainer = new Container();
		buttonContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
		Container textContainer = new Container();
		textContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 8));
		
		tA = new JTextPane();
		tA.setText("Teste");
		tA.setEditable(false);
		JScrollPane jsp = new JScrollPane(tA);
		jsp.setPreferredSize(new Dimension(400, 300));
		textContainer.add(jsp);
		
		buttons = new JButton[buttonsText.length];
		for(int i=0; i < buttonsText.length; i++){
			buttons[i] = new JButton(buttonsText[i]);
			buttonContainer.add(buttons[i]);
		}
		c.add(buttonContainer, BorderLayout.SOUTH);
		c.add(textContainer, BorderLayout.CENTER);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
	}

}

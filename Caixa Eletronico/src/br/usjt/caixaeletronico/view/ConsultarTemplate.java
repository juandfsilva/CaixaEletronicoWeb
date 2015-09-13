package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class ConsultarTemplate extends JFrame {
		
	protected JButton[] buttons;
	protected JTextPane tA;
	
	public ConsultarTemplate(String titulo, String descricao, String[] buttonsText, int jspAlign) {
		// TODO Auto-generated constructor stub
		super(titulo);
		Container c = getContentPane();	
		Container buttonContainer = new Container();
		buttonContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
		Container textContainer = new Container();
		JLabel descr = new JLabel(descricao);
		descr.setHorizontalAlignment(SwingConstants.CENTER);
		descr.setFont(descr.getFont().deriveFont(33.0f));
		
		tA = new JTextPane();
		tA.setText("Teste");
		tA.setEditable(false);
		JScrollPane jsp = new JScrollPane(tA);
		textContainer.add(jsp);
		
		if(jspAlign == 0){
			textContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 8));
			jsp.setPreferredSize(new Dimension(300, 200));
		}else if(jspAlign == 1){
			textContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
			jsp.setPreferredSize(new Dimension(600, 600));
		}
		
		
		
		buttons = new JButton[buttonsText.length];
		for(int i=0; i < buttonsText.length; i++){
			buttons[i] = new JButton(buttonsText[i]);
			buttonContainer.add(buttons[i]);
		}
				
		c.add(descr, BorderLayout.NORTH);
		c.add(buttonContainer, BorderLayout.SOUTH);
		c.add(textContainer, BorderLayout.CENTER);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//setUndecorated(true);
	}

}

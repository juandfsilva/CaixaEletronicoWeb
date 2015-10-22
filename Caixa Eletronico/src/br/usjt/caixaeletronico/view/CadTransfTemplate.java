package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class CadTransfTemplate extends JFrame{
	
	protected JButton[] buttons;
	private JLabel[] labels;
	protected JTextField[] fields;
	
	public CadTransfTemplate(String titulo, String descricao, String[] labelsText, String[] buttonsText) {
		super(titulo);
		Container c = getContentPane();
		Container buttonContainer = new Container();
		buttonContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 8));
		Container gridContainer = new Container();
		gridContainer.setLayout(new GridLayout(labelsText.length,1));
		JLabel descr = new JLabel(descricao);
		descr.setHorizontalAlignment(SwingConstants.CENTER);
		descr.setFont(descr.getFont().deriveFont(23.0f));
		
		labels = new JLabel[labelsText.length];
		fields = new JTextField[labelsText.length];
		JPanel panels[] = new JPanel[labelsText.length];
		for(int i=0; i < labelsText.length; i++){
			panels[i] = new JPanel();
			panels[i].setLayout(new FlowLayout());
			labels[i]= new JLabel(labelsText[i]);
			fields[i]= new JTextField("",15);
			panels[i].add(labels[i]);
			panels[i].add(fields[i]);
			gridContainer.add(panels[i]);
		}
				
		buttons = new JButton[buttonsText.length];
		for(int i=0; i < buttonsText.length; i++){
			buttons[i] = new JButton(buttonsText[i]);
			buttonContainer.add(buttons[i]);
		}
				
		c.add(descr, BorderLayout.NORTH);
		c.add(buttonContainer, BorderLayout.SOUTH);
		c.add(gridContainer, BorderLayout.WEST);
		setSize(800, 600);
		setLocationRelativeTo(null);
	}

}

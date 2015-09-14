package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuTemplate extends JFrame {
	
	protected JButton[] buttons;

	protected MenuTemplate(String titulo, String descricao, String[] buttonsText) {
		super(titulo);
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		JPanel buttonsContainer = new JPanel();
		JPanel titleContainer = new JPanel();
		JPanel descriptionContainer = new JPanel();
		
		c.add(titleContainer);
		c.add(descriptionContainer);
		c.add(buttonsContainer);

		titleContainer.add(new JLabel(titulo, JLabel.CENTER));
		titleContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 16));
		descriptionContainer.add(new JLabel(descricao, JLabel.LEFT));
		descriptionContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 32, 32));
		
		buttonsContainer.setLayout(new BorderLayout());
		buttons = new JButton[buttonsText.length];
		JPanel[] panels = new JPanel[2];
		int[] paneCount = new int[2];
		paneCount[0] = buttonsText.length/2;
		paneCount[1] = buttonsText.length - paneCount[0];
		for (int i = 0; i < panels.length; ++i) {
			panels[i] = new JPanel();
			panels[i].setLayout(new GridLayout(paneCount[i], 1, 8, 8));
			panels[i].setBorder(BorderFactory.createEmptyBorder(0, 16, 200, 16));
		}
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonsText[i]);
			if (i < buttons.length / 2) {
				panels[0].add(buttons[i]);
			} else {
				panels[1].add(buttons[i]);
			}
		}
		buttonsContainer.add(panels[0], BorderLayout.WEST);
		buttonsContainer.add(panels[1], BorderLayout.EAST);
		setSize(800, 600);
		setLocationRelativeTo(null);
		//setUndecorated(true);
	}

}

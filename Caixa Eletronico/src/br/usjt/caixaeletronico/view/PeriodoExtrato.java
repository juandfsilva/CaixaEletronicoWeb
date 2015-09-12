package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PeriodoExtrato extends JFrame {
	
	JButton[] buttons;
	BorderLayout borderL = new BorderLayout();
	JPanel[] panels;
	String[] buttonsText = { "Ultimos 7 Dias", "Ultimos 14 dias", "Outro Periodo", "Cancelar" };

	public PeriodoExtrato() {
		super("Periodo Extrato");	
		Container c = getContentPane();
		setLayout(borderL);
		setLocationRelativeTo(null);

		buttons = new JButton[buttonsText.length];
		panels = new JPanel[2];
		for (int i = 0; i < panels.length; ++i) {
			panels[i] = new JPanel();
			//panels[i].setLayout(borderL);
		}
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonsText[i]);
			if (i < buttons.length / 2) {
				panels[0].add(buttons[i]);
			} else {
				panels[1].add(buttons[i]);
			}
		}
		c.add(panels[0], BorderLayout.EAST);
		c.add(panels[1], BorderLayout.WEST);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
	}

}

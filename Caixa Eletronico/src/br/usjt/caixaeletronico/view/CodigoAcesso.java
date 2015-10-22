package br.usjt.caixaeletronico.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;

import br.usjt.caixaeletronico.control.AcessoCtrl;
import br.usjt.caixaeletronico.control.Utils;

public class CodigoAcesso extends JFrame {

	String[] buttonsText = { "1 2", "3 4", "5 6", "7 8", "9 0" };
	int selecoes = 0;

	public CodigoAcesso() {
		super();
		Container c = getContentPane();
		FlowLayout flow = new FlowLayout();
		setLayout(flow);

		JButton[] buttons = new JButton[5];
		Collections.shuffle(Arrays.asList(buttonsText));
		for (int i = 0; i < buttonsText.length; i++) {
			buttons[i] = new JButton(buttonsText[i]);
			add(buttons[i]);
		}
		setLocationRelativeTo(null);
		pack();

		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.codAcesso += buttonsText[0].replace(" ", "");
				selecoes++;
				fim();
			}
		});
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.codAcesso += buttonsText[1].replace(" ", "");
				selecoes++;
				fim();
			}
		});
		buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.codAcesso += buttonsText[2].replace(" ", "");
				selecoes++;
				fim();
			}
		});
		buttons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.codAcesso += buttonsText[3].replace(" ", "");
				selecoes++;
				fim();
			}
		});
		buttons[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.codAcesso += buttonsText[4].replace(" ", "");
				selecoes++;
				fim();
			}
		});
	}

	public void fim() {
		if (selecoes >= 3) {
			this.dispose();
			AcessoCtrl acessoCtrl = new AcessoCtrl();
			acessoCtrl.verifica();
		}

	}

}

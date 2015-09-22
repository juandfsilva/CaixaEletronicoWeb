package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saque extends MenuTemplate {
	private static String[] buttonsText = {"R$ 10,00", "R$ 20,00", "R$ 50,00", 
											"R$ 100,00","R$ 200,00", "R$ 500,00",
												"Outro Valor", "Voltar"};
	public Saque() {
		super("Saque", "Quanto deseja sacar ?", buttonsText);
	
		//botão outro saque
		buttons[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OutroSaq obj = new OutroSaq();
				obj.setVisible(true);
				
			}
		});
		
		//botão voltar
		buttons[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});

	
	}
	
}

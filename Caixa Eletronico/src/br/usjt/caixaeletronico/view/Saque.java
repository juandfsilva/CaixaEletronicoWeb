package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saque extends MenuTemplate {
	private static String[] buttonsText = {"R$ 10,00", "R$ 20,00", "R$ 50,00",  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
											"R$ 100,00","R$ 200,00", "R$ 500,00", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
												Messages.getString("Saque.0"), Messages.getString("Saque.1")}; //$NON-NLS-1$ //$NON-NLS-2$
	public Saque() {
		super(Messages.getString("Saque.2"), Messages.getString("Saque.3"), buttonsText); //$NON-NLS-1$ //$NON-NLS-2$
	
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

package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.usjt.caixaeletronico.model.Extrato;

public class ConsultarExtrato extends ConsultarTemplate {
	
	private static String[] buttonsText = { Messages.getString("ConsultarExtrato.0"), Messages.getString("ConsultarExtrato.1"), Messages.getString("ConsultarExtrato.2") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	public ConsultarExtrato(String periodo, int days) {
		super(periodo, Messages.getString("ConsultarExtrato.3"), buttonsText, 1); //$NON-NLS-1$
		String text = Extrato.getExtrato(days);
		tA.setText(text);
		
		//Button voltar
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//Fecha uma janela
				
			}
		});
		
		//Button extrato
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//Button Imprimir
		buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
	}

}

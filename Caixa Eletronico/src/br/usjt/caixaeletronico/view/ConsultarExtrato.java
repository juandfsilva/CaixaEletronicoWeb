package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.usjt.caixaeletronico.model.Extrato;

public class ConsultarExtrato extends ConsultarTemplate {
	
	private static String[] buttonsText = { "Voltar", "Extrato", "Imprimir" };
	public ConsultarExtrato(String periodo, int days) {
		super(periodo, "Extrato", buttonsText, 1);
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

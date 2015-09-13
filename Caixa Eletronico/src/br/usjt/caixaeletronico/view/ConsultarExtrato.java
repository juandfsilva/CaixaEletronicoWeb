package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.usjt.caixaeletronico.model.Extrato;

public class ConsultarExtrato extends ConsultarTemplate {
	
	private static String[] buttonsText = { "Voltar", "Extrato", "Imprimir" };
	public ConsultarExtrato(String periodo, int days) {
		super(periodo, "Extrato", buttonsText, 1);
		String text = Extrato.getExtrato(days);
		super.tA.setText(text);
		
		//Button voltar
		super.buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//Fecha uma janela
				
			}
		});
		
		//Button extrato
		super.buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//Button Imprimir
		super.buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
	}

}

package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CadastroDebitoAutom extends CadTransfTemplate{
	
	private static String[] buttonsText = { "Cadastrar", "Voltar"};
	private static String[] labelsText = { "Codigo da operadora:", 
			"Codigo do consumidor:", "Dia do mês:"};
	public CadastroDebitoAutom() {
		// TODO Auto-generated constructor stub
		super("Cadastro de Débito Automático", "Débito Automático", labelsText, buttonsText);
		
		//Cadastrar
		super.buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					Mensagem msg = new Mensagem("Cadastro Débito Automático", 
							"Cadastro Realizado com sucesso!!");
					msg.setVisible(true);
					dispose();
			}
		});
		
		//Voltar
		super.buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		

	}
}

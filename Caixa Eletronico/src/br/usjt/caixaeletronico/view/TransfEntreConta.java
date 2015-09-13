package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransfEntreConta extends CadTransfTemplate {
	
	private static String[] buttonsText = { "Cadastrar", "Voltar"};
	private static String[] labelsText = { "Conta:", 
			"Agência:", "Quantia:"};
	
	public TransfEntreConta() {
		// TODO Auto-generated constructor stub
		super("Transferência Entre Contas", "Transferência", labelsText, buttonsText);
		
		//Transferir
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

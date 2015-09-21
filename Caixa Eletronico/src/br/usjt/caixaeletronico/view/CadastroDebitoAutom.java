package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CadastroDebitoAutom extends CadTransfTemplate{
	
	private static String[] buttonsText = { Messages.getString("CadastroDebitoAutom.0"), Messages.getString("CadastroDebitoAutom.1")}; //$NON-NLS-1$ //$NON-NLS-2$
	private static String[] labelsText = { Messages.getString("CadastroDebitoAutom.2"),  //$NON-NLS-1$
			Messages.getString("CadastroDebitoAutom.3"), Messages.getString("CadastroDebitoAutom.4")}; //$NON-NLS-1$ //$NON-NLS-2$
	public CadastroDebitoAutom() {
		// TODO Auto-generated constructor stub
		super(Messages.getString("CadastroDebitoAutom.5"), Messages.getString("CadastroDebitoAutom.6"), labelsText, buttonsText); //$NON-NLS-1$ //$NON-NLS-2$
		
		//Cadastrar
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					Mensagem msg = new Mensagem(Messages.getString("CadastroDebitoAutom.7"),  //$NON-NLS-1$
							Messages.getString("CadastroDebitoAutom.8")); //$NON-NLS-1$
					msg.setVisible(true);
					dispose();
			}
		});
		
		//Voltar
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		

	}
}

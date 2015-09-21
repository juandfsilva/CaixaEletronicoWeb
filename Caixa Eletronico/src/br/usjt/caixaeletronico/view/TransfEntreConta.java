package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransfEntreConta extends CadTransfTemplate {

	private static String[] buttonsText = { Messages.getString("TransfEntreConta.0"), Messages.getString("TransfEntreConta.1") }; //$NON-NLS-1$ //$NON-NLS-2$
	private static String[] labelsText = { Messages.getString("TransfEntreConta.2"), Messages.getString("TransfEntreConta.3"), Messages.getString("TransfEntreConta.4") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	public TransfEntreConta() {
		// TODO Auto-generated constructor stub
		super(Messages.getString("TransfEntreConta.5"), Messages.getString("TransfEntreConta.6"), labelsText, buttonsText); //$NON-NLS-1$ //$NON-NLS-2$

		// Transferir
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Mensagem msg = new Mensagem(Messages.getString("TransfEntreConta.7"), Messages.getString("TransfEntreConta.8")); //$NON-NLS-1$ //$NON-NLS-2$
				msg.setVisible(true);
				dispose();
			}
		});

		// Voltar
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}

}

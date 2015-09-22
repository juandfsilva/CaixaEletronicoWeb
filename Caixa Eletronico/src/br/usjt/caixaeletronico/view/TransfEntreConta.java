package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class TransfEntreConta extends CadTransfTemplate {

	public TransfEntreConta(final ResourceBundle resourceBundle) {
		// TODO Auto-generated constructor stub
		super(resourceBundle.getString("Transferencia.titulo"), resourceBundle
				.getString("Transferencia.desc"), new String[] {
				resourceBundle.getString("Transferencia.conta"),
				resourceBundle.getString("Transferencia.agencia"),
				resourceBundle.getString("Transferencia.quantia") },
				new String[] { resourceBundle.getString("Cadastrar"),
						resourceBundle.getString("Voltar") });

		// Transferir
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Mensagem msg = new Mensagem(resourceBundle,
						"Cadastro Débito Automático",
						"Cadastro Realizado com sucesso!!");
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

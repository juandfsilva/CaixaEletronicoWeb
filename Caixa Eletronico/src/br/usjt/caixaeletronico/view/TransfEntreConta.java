package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import br.usjt.caixaeletronico.control.Utils;
import br.usjt.caixaeletronico.model.ContaDAO;

public class TransfEntreConta extends CadTransfTemplate {

	public TransfEntreConta(final ResourceBundle resourceBundle) {
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
				int acDestino = Integer.parseInt(fields[0].getText());
				int agDestino = Integer.parseInt(fields[1].getText());
				double valor = Double.parseDouble(fields[2].getText());
				String mensagem = Utils.objConta.transferencia(valor, agDestino, acDestino, resourceBundle);
				Mensagem msg = new Mensagem(resourceBundle,
						"Cadastro Debito Automatico",
						mensagem);
				msg.setVisible(true);
				dispose();
				MenuPrinc menu = new MenuPrinc(resourceBundle);
				menu.setVisible(true);
			}
		});

		// Voltar
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuPrinc menu = new MenuPrinc(resourceBundle);
				menu.setVisible(true);
			}
		});
	}

}

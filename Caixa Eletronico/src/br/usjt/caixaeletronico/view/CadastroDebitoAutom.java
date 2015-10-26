package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import br.usjt.caixaeletronico.control.DebitoAutomCtrl;

public class CadastroDebitoAutom extends CadTransfTemplate {
	public CadastroDebitoAutom(final ResourceBundle resourceBundle) {
		// TODO Auto-generated constructor stub
		super(resourceBundle.getString("AutoDebt.titulo"), resourceBundle.getString("AutoDebt.desc"), new String[] { resourceBundle.getString("AutoDebt.operadora"), 
			resourceBundle.getString("AutoDebt.consumidor"), resourceBundle.getString("AutoDebt.diaMes")}, new String[] { resourceBundle.getString("Cadastrar"), resourceBundle.getString("Voltar")});
		
		//Cadastrar
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					DebitoAutomCtrl debCtrl = new DebitoAutomCtrl();
					debCtrl.registra(Integer.parseInt(fields[2].getText()), Integer.parseInt(fields[1].getText()), Integer.parseInt(fields[0].getText()));
					Mensagem msg = new Mensagem(resourceBundle, resourceBundle.getString("AutoDebt.titulo"), 
							resourceBundle.getString("AutoDebt.mensagemSucesso"));
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

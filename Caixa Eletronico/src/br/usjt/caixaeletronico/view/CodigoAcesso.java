package br.usjt.caixaeletronico.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.usjt.caixaeletronico.control.AcessoCtrl;
import br.usjt.caixaeletronico.control.Utils;

public class CodigoAcesso extends JFrame {

	String[] buttonsText;// = { "1 2", "3 4", "5 6", "7 8", "9 0" };
	String codAcesso = "";
	int selecoes = 0;
	Acao acao;
	int tentativa = 0;
	AcessoCtrl acessoCtrl = new AcessoCtrl();

	public CodigoAcesso(Acao acao, ResourceBundle resourceBundle) {
		super();
		this.acao = acao;
		Random rand = new Random();
		FlowLayout flow = new FlowLayout();
		setLayout(flow);

		int[] numeros = new int[10];
		for (int i = 0; i < numeros.length; ++i)
			numeros[i] = i;
		for (int i = numeros.length - 1; i > 0; --i) {
			int j = rand.nextInt(i + 1);
			int temp = numeros[i];
			numeros[i] = numeros[j];
			numeros[j] = temp;
		}
		buttonsText = new String[numeros.length / 2];
		for (int i = 0; i < buttonsText.length; i++) {
			buttonsText[i] = numeros[i * 2] + " " + numeros[i * 2 + 1];
		}
		JButton[] buttons = new JButton[5];
		for (int i = 0; i < buttonsText.length; i++) {
			buttons[i] = new JButton(buttonsText[i]);
			add(buttons[i]);
		}
		setLocationRelativeTo(null);
		pack();
		final ResourceBundle rb = resourceBundle;
		for (int i = 0; i < buttons.length; ++i) {
			final int j = i;
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					codAcesso += buttonsText[j].replace(" ", "");
					selecoes++;
					fim(rb);
				}
			});
		}
	}

	public void fim(ResourceBundle resourceBundle) {
		if (selecoes >= 3) {
			if(acessoCtrl.verifica(codAcesso)){
				this.dispose();
				acao.executar();
			}else if (tentativa >= 3) {
				JOptionPane.showMessageDialog(null,resourceBundle.getString("CadCodAcesso.bloqueio"));
				acessoCtrl.bloqueia(true);
				this.dispose();
				acao.falha();
			} else {
				tentativa++;
				selecoes = 0;
				codAcesso = "";
				JOptionPane.showMessageDialog(null,
						resourceBundle.getString("CadCodAcesso.tentativa1")+" "+(3 - tentativa)+" "+resourceBundle.getString("CadCodAcesso.tentativa2"));
			}
		}

	}

}

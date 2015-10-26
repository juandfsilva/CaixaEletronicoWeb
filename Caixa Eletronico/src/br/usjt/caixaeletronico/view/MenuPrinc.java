package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;


public class MenuPrinc extends MenuTemplate {

	public MenuPrinc(final ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Menu.titulo"),//Titulo
				resourceBundle.getString("0"), //Descricao
				new String[] {//array de botoes
				resourceBundle.getString("AutoDebt.titulo"),
				resourceBundle.getString("Saque.titulo"),
				resourceBundle.getString("Extrato.titulo"),
				resourceBundle.getString("Saldo.titulo"),
				resourceBundle.getString("Transferencia.titulo"),
				resourceBundle.getString("Sair") });
		final JFrame actual = this;
		
		super.buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroDebitoAutom deb = new CadastroDebitoAutom(resourceBundle);
				deb.setVisible(true);
				actual.dispose();
			}
		});
		
		super.buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Saque sq = new Saque(resourceBundle);
				sq.setVisible(true);
				actual.dispose();
			}
		});
		
		
		super.buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PeriodoExtrato extrato = new PeriodoExtrato(resourceBundle);
				extrato.setVisible(true);
				actual.dispose();
			}
		});
		
		super.buttons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarSaldo saldo = new ConsultarSaldo(resourceBundle);
				saldo.setVisible(true);
				actual.dispose();
			}
		});
		
		super.buttons[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransfEntreConta transf = new TransfEntreConta(resourceBundle);
				transf.setVisible(true);
				actual.dispose();
			}
		});
		
		super.buttons[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual.dispose();
			}
		});
		
		
		
	}
}

package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PeriodoExtrato extends MenuTemplate {
	private static String[] buttonsText = { "Ultimos 7 Dias", "Ultimos 14 dias", "Outro Periodo", "Cancelar" };
	public PeriodoExtrato() {
		super("Deseja acessar o extrato de que periodo?", "", buttonsText);
		
		//7 Dias
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame cExtrato = new ConsultarExtrato("Extrato dos ultimos 7 dias", 7);
				cExtrato.setVisible(true);
			}
		});
		
		//14 dias
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame cExtrato = new ConsultarExtrato("Extrato dos ultimos 14 dias", 14);
				cExtrato.setVisible(true);
			}
		});
		//Outro periodo
		buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int days = Integer.parseInt(
						JOptionPane.showInputDialog("Digite o periodo desejado em dias:"));
				JFrame cExtrato = new ConsultarExtrato("Extrato de outro periodo", days);
				cExtrato.setVisible(true);
			}
		});
		
		//Cancelar
		buttons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		
		
		
	}
}

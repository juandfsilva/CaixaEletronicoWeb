package br.usjt.caixaeletronico.view;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PeriodoExtrato extends MenuTemplate {
	public PeriodoExtrato(final ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Periodo.descricao"), "", new String[]{ resourceBundle.getString("Periodo.7"), resourceBundle.getString("Periodo.14"), resourceBundle.getString("Periodo.outro"), resourceBundle.getString("Cancelar") });
		
		//7 Dias
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PeriodoExtrato.this.dispose();
				JFrame cExtrato = new ConsultarExtrato(resourceBundle, resourceBundle.getString("Periodo.extrato7"), 7);
				cExtrato.setVisible(true);
			}
		});
		
		//14 dias
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PeriodoExtrato.this.dispose();
				JFrame cExtrato = new ConsultarExtrato(resourceBundle, resourceBundle.getString("Periodo.extrato8"), 14);
				cExtrato.setVisible(true);
			}
		});
		//Outro periodo
		buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PeriodoExtrato.this.dispose();
				int days = Integer.parseInt(
						JOptionPane.showInputDialog(resourceBundle.getString("Periodo.digite")));
				JFrame cExtrato = new ConsultarExtrato(resourceBundle, resourceBundle.getString("Periodo.extratoOutro"), days);
				cExtrato.setVisible(true);
			}
		});
		
		//Cancelar
		buttons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PeriodoExtrato.this.dispose();
				MenuPrinc mn = new MenuPrinc(resourceBundle);
				mn.setVisible(true);
			}
		});
		
		
		
		
	}
}

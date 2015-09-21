package br.usjt.caixaeletronico.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PeriodoExtrato extends MenuTemplate {
	private static String[] buttonsText = { Messages.getString("PeriodoExtrato.0"), Messages.getString("PeriodoExtrato.1"), Messages.getString("PeriodoExtrato.2"), Messages.getString("PeriodoExtrato.3") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	public PeriodoExtrato() {
		super(Messages.getString("PeriodoExtrato.4"), "", buttonsText); //$NON-NLS-1$ //$NON-NLS-2$
		
		//7 Dias
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame cExtrato = new ConsultarExtrato(Messages.getString("PeriodoExtrato.5"), 7); //$NON-NLS-1$
				cExtrato.setVisible(true);
			}
		});
		
		//14 dias
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame cExtrato = new ConsultarExtrato(Messages.getString("PeriodoExtrato.6"), 14); //$NON-NLS-1$
				cExtrato.setVisible(true);
			}
		});
		//Outro periodo
		buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int days = Integer.parseInt(
						JOptionPane.showInputDialog(Messages.getString("PeriodoExtrato.7"))); //$NON-NLS-1$
				JFrame cExtrato = new ConsultarExtrato(Messages.getString("PeriodoExtrato.8"), days); //$NON-NLS-1$
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

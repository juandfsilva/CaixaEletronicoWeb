package br.usjt.caixaeletronico.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import br.usjt.caixaeletronico.control.ContaCtrl;
import br.usjt.caixaeletronico.model.Conta;

public class OutroSaq extends JFrame{

	private JButton bPros, bCanc;
	private JTextField tValor;
	private JLabel lR$, lText;
	final ResourceBundle rb;

	public OutroSaq(final ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Saque2.Titulo"));
		rb = resourceBundle;
		// controlar layout
		JPanel controlInput = new JPanel(new BorderLayout(5, 5));
		// controlar label
		JPanel controlLabel = new JPanel(new GridLayout(0, 1, 3, 3));
		// controlar TextField
		JPanel controlField = new JPanel(new GridLayout(0, 1, 3, 3));

		// Organizar itens no layout
		bPros = new JButton(resourceBundle.getString("Prosseguir"));
		bCanc = new JButton(resourceBundle.getString("Cancelar"));
		tValor = new JTextField(15);
		lR$ = new JLabel(resourceBundle.getString("UnidadeMonetaria"));
		lText = new JLabel(resourceBundle.getString("Saque2.QualValor"));

		controlInput.add(controlLabel, BorderLayout.WEST);
		controlInput.add(controlField, BorderLayout.CENTER);
		controlInput.add(lText, BorderLayout.NORTH);
		controlLabel.add(lR$);
		controlField.add(tValor);

		// Controlar Botao
		JPanel control = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		control.add(bPros);
		control.add(bCanc);

		JPanel gui = new JPanel((new FlowLayout(FlowLayout.CENTER, 5, 2)));
		gui.add(controlInput, BorderLayout.CENTER);
		gui.add(control, BorderLayout.SOUTH);

		setContentPane(gui);

		setResizable(false);
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		bPros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaCtrl contaCtrl = new ContaCtrl();
				int saque = contaCtrl.Saque(Integer.parseInt(tValor.getText()));
				if (saque == 1) {
					JOptionPane.showMessageDialog(null, rb.getString("suceso"));
				} else if (saque == -1) {
					JOptionPane.showMessageDialog(null, rb.getString("Transferencia.semSaldo"));
				} else {
					JOptionPane.showMessageDialog(null, rb.getString("erro"));
				}
			}
		});
		
		bCanc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OutroSaq.this.dispose();
				MenuPrinc mn = new MenuPrinc(resourceBundle);
				mn.setVisible(true);
			}
		});
	}

	
}

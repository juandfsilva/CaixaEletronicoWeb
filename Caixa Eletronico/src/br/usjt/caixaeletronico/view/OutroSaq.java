package br.usjt.caixaeletronico.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class OutroSaq extends JFrame implements ActionListener {

	private JButton bPros, bCanc;
	private JTextField tValor;
	private JLabel lR$, lText;

	public OutroSaq() {
		super("Saque");
		// controlar layout
		JPanel controlInput = new JPanel(new BorderLayout(5, 5));
		// controlar label
		JPanel controlLabel = new JPanel(new GridLayout(0, 1, 3, 3));
		// controlar TextField
		JPanel controlField = new JPanel(new GridLayout(0, 1, 3, 3));

		// Organizar itens no layout
		bPros = new JButton("Prosseguir");
		bCanc = new JButton("Cancelar");
		tValor = new JTextField(15);
		lR$ = new JLabel("R$");
		lText = new JLabel("Qual valor deseja sacar ?");

		controlInput.add(controlLabel, BorderLayout.WEST);
		controlInput.add(controlField, BorderLayout.CENTER);
		controlInput.add(lText, BorderLayout.NORTH);
		controlLabel.add(lR$);
		controlField.add(tValor);

		// Controlar Botao
		JPanel control = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		control.add(bPros);
		control.add(bCanc);

		JPanel gui = new JPanel(new BorderLayout(35, 35));
		gui.add(controlInput, BorderLayout.CENTER);
		gui.add(control, BorderLayout.SOUTH);

		setContentPane(gui);

		setResizable(false);
		setSize(800, 600);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

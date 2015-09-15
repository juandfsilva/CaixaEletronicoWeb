package br.usjt.caixaeletronico.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ConfSaque extends JFrame implements ActionListener {

	private JButton bPros, bCanc;
	private JLabel lText;

	public ConfSaque() {
		super("Confirmação");

		bPros = new JButton("Prosseguir");
		bCanc = new JButton("Cancelar");
		lText = new JLabel("Você esta sacando R$ 100,00. Deseja continuar ?");

		JPanel control = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		control.add(bPros);
		control.add(bCanc);

		JPanel gui = new JPanel(new BorderLayout(35, 35));
		gui.setBorder(new TitledBorder("Saque"));
		gui.add(lText, BorderLayout.CENTER);
		gui.add(control, BorderLayout.SOUTH);
		setContentPane(gui);

		setResizable(false);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

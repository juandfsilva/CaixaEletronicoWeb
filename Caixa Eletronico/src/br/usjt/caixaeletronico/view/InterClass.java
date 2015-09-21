package br.usjt.caixaeletronico.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class InterClass extends JFrame implements ActionListener {
	private JButton bIng, bPort, bEsp;

	public InterClass() {

		JPanel bPanel = new JPanel(new GridLayout(3, 1));

		bIng = new JButton(Messages.getString("InterClass.0")); //$NON-NLS-1$
		bPort = new JButton(Messages.getString("InterClass.1")); //$NON-NLS-1$
		bEsp = new JButton(Messages.getString("InterClass.2")); //$NON-NLS-1$

		bPanel.add(bPort);
		bPanel.add(bIng);
		bPanel.add(bEsp);
		bPanel.setBorder(new TitledBorder(Messages.getString("InterClass.3"))); //$NON-NLS-1$

		JFrame inter = new JFrame(Messages.getString("InterClass.4")); //$NON-NLS-1$
		inter.setContentPane(bPanel);

		inter.setResizable(false);
		inter.setSize(250, 250);
		inter.setVisible(true);
		inter.setLocationRelativeTo(null);
		inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}

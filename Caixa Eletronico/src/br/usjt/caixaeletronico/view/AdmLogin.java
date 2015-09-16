package br.usjt.caixaeletronico.view;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AdmLogin extends JFrame implements ActionListener {

		private JButton bEnt, bSai;
		private JTextField tUser, tSen;
		private JLabel lUser,lSen;

		public AdmLogin() {
			super("Login Administrador");
			// controlar layout
			JPanel controlInput = new JPanel(new BorderLayout(5, 5));
			// controlar label
			JPanel controlLabel = new JPanel(new GridLayout(0, 1, 3, 3));
			// controlar TextField
			JPanel controlField = new JPanel(new GridLayout(0, 1, 3, 3));

			// Organizar itens no layout
			bEnt = new JButton("Entrar");
			bSai = new JButton("Sair");
			tUser = new JTextField(15);
			tSen = new JTextField(15);
			lUser = new JLabel("Usuario");
			lSen = new JLabel("Senha");

			controlInput.add(controlLabel, BorderLayout.WEST);
			controlInput.add(controlField, BorderLayout.CENTER);
			controlLabel.add(lUser);
			controlLabel.add(lSen);
			controlField.add(tUser);
			controlField.add(tSen);

			// Controlar Botao
			JPanel control = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
			control.add(bEnt);
			control.add(bSai);

			JPanel gui = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
			gui.setBorder(new TitledBorder("Administrador"));
			gui.add(controlInput, BorderLayout.CENTER);
			gui.add(control, BorderLayout.SOUTH);

			setContentPane(gui);

			setResizable(false);
			setSize(800, 600);
			setLocationRelativeTo(null);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	

}


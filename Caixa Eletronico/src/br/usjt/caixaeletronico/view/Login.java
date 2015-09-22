package br.usjt.caixaeletronico.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Login extends JFrame implements ActionListener {
	
	private JButton bEnt;
	private JTextField tAg, tCont, tSen;
	private JLabel lAg, lCont, lSen, lBan;
	

	public Login(ResourceBundle resourceBundle) 
	{
		super(resourceBundle.getString("Login.titulo"));
		// controlar layout
		JPanel controlInput = new JPanel(new BorderLayout(5, 5));
		// controlar label
		JPanel controlLabel = new JPanel(new GridLayout(0, 1, 3, 3));
		// controlar TextField
		JPanel controlField = new JPanel(new GridLayout( 0, 1, 3, 3));

		//Organizar itens no layout
		bEnt = new JButton(resourceBundle.getString("Login.entrar"));
		tAg = new JTextField(15);
		tCont = new JTextField(15);
		tSen = new JTextField(15);
		lAg = new JLabel(resourceBundle.getString("Login.agencia"));
		lCont = new JLabel(resourceBundle.getString("Login.conta"));
		lSen = new JLabel(resourceBundle.getString("Login.senha"));
		lBan = new JLabel(resourceBundle.getString("Login.banco"));
		JComboBox<String> Cban = new JComboBox<String> ();
		Cban.addItem("");
		Cban.addItem("Itau");
		Cban.addItem("Bradesco");
		Cban.addItem("Santander");
		Cban.addItem("HSBC");
		
		controlInput.add(controlLabel, BorderLayout.WEST);
		controlInput.add(controlField, BorderLayout.CENTER);
		controlLabel.add(lAg);
		controlLabel.add(lCont);
		controlLabel.add(lSen);
		controlLabel.add(lBan);
		controlField.add(tAg);
		controlField.add(tCont);
		controlField.add(tSen);
		controlField.add(Cban);
		
		// Controlar Botao
		JPanel control = new JPanel(new FlowLayout(FlowLayout.CENTER, 5,2));
		control.add(bEnt);
		
		JPanel gui = new JPanel(new BorderLayout(10,10));
        gui.setBorder(new TitledBorder(resourceBundle.getString("BemVindo")));
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
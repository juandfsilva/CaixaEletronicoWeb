package br.usjt.caixaeletronico.view;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Login extends JFrame implements ActionListener {
	
	private JButton bEnt;
	private JTextField tAg, tCont, tSen;
	private JLabel lAg, lCont, lSen, lBan;
	

	public Login() 
	{
		
		// controlar layout
		JPanel controlInput = new JPanel(new BorderLayout(5, 5));
		// controlar label
		JPanel controlLabel = new JPanel(new GridLayout(0, 1, 3, 3));
		// controlar TextField
		JPanel controlField = new JPanel(new GridLayout( 0, 1, 3, 3));

		//Organizar itens no layout
		bEnt = new JButton("Entrar");
		tAg = new JTextField(15);
		tCont = new JTextField(15);
		tSen = new JTextField(15);
		lAg = new JLabel("Agência");
		lCont = new JLabel("Conta");
		lSen = new JLabel("Senha");
		lBan = new JLabel("Banco");
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
        gui.setBorder(new TitledBorder("Bem Vindo"));
        gui.add(controlInput, BorderLayout.CENTER);
        gui.add(control, BorderLayout.SOUTH);
       
        JFrame log = new JFrame("Login");
        log.setContentPane(gui);
        
        log.setResizable(false);
        log.setSize(250,250);
        log.setVisible(true);
		log.setLocationRelativeTo(null);
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
       }
        

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
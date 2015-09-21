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
		super(Messages.getString("Login.0")); //$NON-NLS-1$
		// controlar layout
		JPanel controlInput = new JPanel(new BorderLayout(5, 5));
		// controlar label
		JPanel controlLabel = new JPanel(new GridLayout(0, 1, 3, 3));
		// controlar TextField
		JPanel controlField = new JPanel(new GridLayout( 0, 1, 3, 3));

		//Organizar itens no layout
		bEnt = new JButton(Messages.getString("Login.1")); //$NON-NLS-1$
		tAg = new JTextField(15);
		tCont = new JTextField(15);
		tSen = new JTextField(15);
		lAg = new JLabel(Messages.getString("Login.2")); //$NON-NLS-1$
		lCont = new JLabel(Messages.getString("Login.3")); //$NON-NLS-1$
		lSen = new JLabel(Messages.getString("Login.4")); //$NON-NLS-1$
		lBan = new JLabel(Messages.getString("Login.5")); //$NON-NLS-1$
		JComboBox<String> Cban = new JComboBox<String> ();
		Cban.addItem(""); //$NON-NLS-1$
		Cban.addItem("Itau"); //$NON-NLS-1$
		Cban.addItem("Bradesco");
		Cban.addItem("Santander"); //$NON-NLS-1$
		Cban.addItem("HSBC"); //$NON-NLS-1$
		
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
        gui.setBorder(new TitledBorder(Messages.getString("Login.6"))); //$NON-NLS-1$
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
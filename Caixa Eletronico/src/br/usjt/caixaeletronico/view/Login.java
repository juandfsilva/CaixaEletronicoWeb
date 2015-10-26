package br.usjt.caixaeletronico.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.usjt.caixaeletronico.control.AcessoCtrl;
import br.usjt.caixaeletronico.control.LoginCtrl;
import br.usjt.caixaeletronico.control.Utils;

public class Login extends JFrame {

	private JButton bEnt;
	private JFormattedTextField tAg, tCont;
	private JPasswordField tSen;
	private JLabel lAg, lCont, lSen, lBan;
	private LoginCtrl loginCtrl;
	private AcessoCtrl acessoCtrl;
	private JComboBox<String> Cban;

	public Login(ResourceBundle resourceBundle) {
		super(resourceBundle.getString("Login.titulo"));
		final JFrame actual = this;
		// MASCARA DOS NUMEROS
		MaskFormatter AGENCY = null;
		MaskFormatter ACCOUNT = null;
		try {
			AGENCY = new MaskFormatter("****-**");
			ACCOUNT = new MaskFormatter("******-*");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		AGENCY.setValidCharacters("0123456789");
		ACCOUNT.setValidCharacters("0123456789");
		loginCtrl = new LoginCtrl(this, resourceBundle);
		acessoCtrl = new AcessoCtrl();
		// controlar layout
		JPanel controlInput = new JPanel(new BorderLayout(5, 5));
		// controlar label
		JPanel controlLabel = new JPanel(new GridLayout(0, 1, 3, 3));
		// controlar TextField
		JPanel controlField = new JPanel(new GridLayout(0, 1, 3, 3));

		final MenuPrinc menu = new MenuPrinc(resourceBundle);
		// Organizar itens no layout
		final ResourceBundle rb = resourceBundle;
		bEnt = new JButton(resourceBundle.getString("Login.entrar"));
		bEnt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				char pass[] = tSen.getPassword();
				String senha = new String(pass);
				String agencia = tAg.getText().replace("-", "");
				String conta = tCont.getText().replace("-", "");
				String banco = (String) Cban.getSelectedItem();
				int next = loginCtrl.entrar(agencia, conta, senha, banco);
				if (next == 1) {
					actual.dispose();
					CodigoAcesso codAcesso = new CodigoAcesso(new Acao() {

						@Override
						public void falha() {
							// Ntem o q implementar
						}

						@Override
						public void executar() {
							menu.setVisible(true);
						}
					}, rb);
					codAcesso.setVisible(true);
				} else if (next == 0) {
					CadCodAcesso cadCodAcesso = new CadCodAcesso(rb);
					cadCodAcesso.setVisible(true);
				}
			}
		});

		tAg = new JFormattedTextField(AGENCY);
		tCont = new JFormattedTextField(ACCOUNT);
		tSen = new JPasswordField(4);
		lAg = new JLabel(resourceBundle.getString("Login.agencia"));
		lCont = new JLabel(resourceBundle.getString("Login.conta"));
		lSen = new JLabel(resourceBundle.getString("Login.senha"));
		lBan = new JLabel(resourceBundle.getString("Login.banco"));

		Cban = new JComboBox<String>();
		Cban.addItem("");
		Cban.addItem("ITAU");
		Cban.addItem("BRADESCO");
		Cban.addItem("BB");
		Cban.addItem("CITIBANK");
		Cban.addItem("SANTANDER");
		Cban.addItem("HSBC");
		Cban.addItem("CAIXA");

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
		JPanel control = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
		control.add(bEnt);

		JPanel gui = new JPanel(new BorderLayout(10, 10));
		gui.setBorder(new TitledBorder(resourceBundle.getString("BemVindo")));
		gui.add(controlInput, BorderLayout.CENTER);
		gui.add(control, BorderLayout.SOUTH);

		setContentPane(gui);

		setResizable(false);
		setSize(800, 600);
		setLocationRelativeTo(null);
	}

}
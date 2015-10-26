package br.usjt.caixaeletronico.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import br.usjt.caixaeletronico.control.AcessoCtrl;

public class CadCodAcesso extends JFrame {

	private JButton bLimpa, bOk;
	private JFormattedTextField tCodAcesso;
	private JLabel lCodAcesso;

	public CadCodAcesso(ResourceBundle resourceBundle) {
		super(resourceBundle.getString("CadCodAcesso.titulo"));// TODO
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		// MASCARA DOS NUMEROS
		MaskFormatter CODE = null;
		try {
			CODE = new MaskFormatter("***");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		CODE.setValidCharacters("0123456789");

		lCodAcesso = new JLabel(resourceBundle.getString("CadCodAcesso.Codigo"));
		tCodAcesso = new JFormattedTextField(CODE);
		bLimpa = new JButton(resourceBundle.getString("CadCodAcesso.Limpa"));// TODO
		bOk = new JButton(resourceBundle.getString("CadCodAcesso.Cadastrar"));// TODO

		tCodAcesso.setText("000");

		add(lCodAcesso);
		add(tCodAcesso);
		add(bLimpa);
		add(bOk);
		
		final ResourceBundle rb = resourceBundle;
		// Botoes
		bLimpa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tCodAcesso.setText("000");
			}
		});

		bOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(tCodAcesso.getText().equals("000")) && !(tCodAcesso.getText().equals("")) && !(tCodAcesso.getText().length() < 3)){
					AcessoCtrl acessoCtrl = new AcessoCtrl();
					int cod_acesso = Integer.parseInt(tCodAcesso.getText());
					acessoCtrl.Cadastra(cod_acesso);
					CadCodAcesso.this.dispose();
					JOptionPane.showMessageDialog(null, rb.getString("sucesso"));
				}else{
					JOptionPane.showMessageDialog(null, rb.getString("erro"));
				}
			}
		});
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}

}
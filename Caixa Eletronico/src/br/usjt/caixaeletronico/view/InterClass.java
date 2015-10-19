package br.usjt.caixaeletronico.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jcp.xml.dsig.internal.dom.Utils;

import br.usjt.caixaeletronico.Main;

public class InterClass extends JFrame{
	//private ArrayList<JButton> bLangs = new ArrayList<JButton>();
	private static class Par {
		Par(String nome, ResourceBundle rb) {
			this.nome = nome;
			this.rb = rb;
		}
		String nome;
		ResourceBundle rb;
	}
	private static ArrayList<Par> rbList = new ArrayList<Par>();
	static {
		rbList.add(new Par("Portugues", ResourceBundle.getBundle("messages", new Locale("pt", "BR"))));
		rbList.add(new Par("Ingles", 	ResourceBundle.getBundle("messages", new Locale("en", "US"))));
		rbList.add(new Par("Espanhol", 	ResourceBundle.getBundle("messages", new Locale("es", "ES"))));
	}
	public InterClass() {
		this(0);
	}
	public InterClass(int selectedRb) {
		super(rbList.get(selectedRb).rb.getString("Idioma.Idioma"));
		JPanel bPanel = new JPanel(new GridLayout(3, 1));
		for(int i = 0, s = rbList.size(); i < s; ++i)
		{
			JButton b = new JButton(rbList.get(i).rb.getString("Idioma." + rbList.get(i).nome));
			final int index = i;
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Main.start(rbList.get(index).rb);
					InterClass.this.dispose();
				}
			});
			//bLangs.add(b);
			bPanel.add(b);
		}
		bPanel.setBorder(new TitledBorder(rbList.get(selectedRb).rb.getString("Idioma.Escolha")));

		setContentPane(bPanel);

		setResizable(false);
		setSize(250, 250);
		setLocationRelativeTo(null);
	}

}

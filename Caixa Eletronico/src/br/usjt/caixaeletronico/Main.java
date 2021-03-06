package br.usjt.caixaeletronico;

import java.util.ResourceBundle;

import javax.swing.JFrame;

import br.usjt.caixaeletronico.model.ConnectionFactory;
import br.usjt.caixaeletronico.view.CadCodAcesso;
import br.usjt.caixaeletronico.view.CodigoAcesso;
import br.usjt.caixaeletronico.view.InterClass;
import br.usjt.caixaeletronico.view.Login;

public class Main {

	public static void main(String[] args) {
		InterClass ic = new InterClass();
		ic.setVisible(true);
		ic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void start(ResourceBundle rb) {
		//JFrame view = new CadCodAcesso(rb);
		//JFrame view = new CodigoAcesso(null);
		JFrame view = new Login(rb);
		//JFrame view = new CriaUsuarios();
		ConnectionFactory conn = new ConnectionFactory();
		ConnectionFactory.openFactory();
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		/*
		final JFrame[] views = {
				new MenuPrinc(rb),
				new AdmLogin(rb),
				new CadastroDebitoAutom(rb),
				new ConsultarExtrato(rb, "7", 7),
				new ConsultarSaldo(rb),
				new Login(rb),
				new Mensagem(rb, rb.getString("Dispenser.relatorio"),
						Dispenser.getRelatorioNotas(rb)), new OutroSaq(rb),
				new PeriodoExtrato(rb), new Saque(rb), new TransfEntreConta(rb) };
		for (int i = 0; i < views.length; ++i) {
			views[i].setVisible(false);
			views[i].setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			final int myId = i;
			views[i].addWindowListener(new WindowListener() {

				@Override
				public void windowActivated(WindowEvent arg0) {
				}

				@Override
				public void windowClosed(WindowEvent arg0) {
					if (myId < views.length - 1)
						views[myId + 1].setVisible(true);
				}

				@Override
				public void windowClosing(WindowEvent arg0) {
				}

				@Override
				public void windowDeactivated(WindowEvent arg0) {
				}

				@Override
				public void windowDeiconified(WindowEvent arg0) {
				}

				@Override
				public void windowIconified(WindowEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void windowOpened(WindowEvent arg0) {
					// TODO Auto-generated method stub

				}
			});
		}
		views[0].setVisible(true);*/

		/*
		 * JFrame msg = new Mensagem("Relatorio Notas",
		 * Dispenser.getRelatorioNotas()); JFrame pExtrato = new
		 * PeriodoExtrato(); JFrame cSaldo = new ConsultarSaldo(); JFrame
		 * cadDebAutom = new CadastroDebitoAutom(); JFrame saque = new Saque();
		 * pExtrato.setVisible(false); cSaldo.setVisible(false);
		 * msg.setVisible(false); cadDebAutom.setVisible(false);
		 * saque.setVisible(true);
		 * pExtrato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 */
	}

}

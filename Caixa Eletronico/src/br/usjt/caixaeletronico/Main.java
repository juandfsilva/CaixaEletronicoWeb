package br.usjt.caixaeletronico;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import br.usjt.caixaeletronico.model.Dispenser;
import br.usjt.caixaeletronico.view.AdmLogin;
import br.usjt.caixaeletronico.view.CadTransfTemplate;
import br.usjt.caixaeletronico.view.CadastroDebitoAutom;
import br.usjt.caixaeletronico.view.ConsultarExtrato;
import br.usjt.caixaeletronico.view.ConsultarSaldo;
import br.usjt.caixaeletronico.view.Login;
import br.usjt.caixaeletronico.view.Mensagem;
import br.usjt.caixaeletronico.view.MenuPrinc;
import br.usjt.caixaeletronico.view.MenuTemplate;
import br.usjt.caixaeletronico.view.OutroSaq;
import br.usjt.caixaeletronico.view.PeriodoExtrato;
import br.usjt.caixaeletronico.view.Saque;
import br.usjt.caixaeletronico.view.TransfEntreConta;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final JFrame[] views = {
			new MenuPrinc(),
			new AdmLogin(),
			new CadastroDebitoAutom(),
			new ConsultarExtrato("7", 7), //$NON-NLS-1$
			new ConsultarSaldo(),
			new Login(),
			new Mensagem("Relatorio de Notas", Dispenser.getRelatorioNotas()), //$NON-NLS-1$
			new OutroSaq(),
			new PeriodoExtrato(),
			new Saque(),
			//new TransfEntreConta()
		};
		for(int i = 0; i < views.length; ++i) {
				views[i].setVisible(false);
				views[i].setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				final int myId = i;
				views[i].addWindowListener(new WindowListener() {

					@Override
					public void windowActivated(WindowEvent arg0) {
					}

					@Override
					public void windowClosed(WindowEvent arg0) {
						if(myId < views.length-1)
							views[myId+1].setVisible(true);
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
		views[0].setVisible(true);
		/*JFrame msg = new Mensagem("Relatorio Notas", Dispenser.getRelatorioNotas());
		JFrame pExtrato = new PeriodoExtrato();
		JFrame cSaldo = new ConsultarSaldo();
		JFrame cadDebAutom = new CadastroDebitoAutom();
		JFrame saque = new Saque();
		pExtrato.setVisible(false);
		cSaldo.setVisible(false);
		msg.setVisible(false);
		cadDebAutom.setVisible(false);
		saque.setVisible(true);
		pExtrato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		*/

	}

}

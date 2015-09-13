package br.usjt.caixaeletronico;

import javax.swing.JFrame;

import br.usjt.caixaeletronico.model.Dispenser;
import br.usjt.caixaeletronico.view.CadTransfTemplate;
import br.usjt.caixaeletronico.view.ConsultarExtrato;
import br.usjt.caixaeletronico.view.ConsultarSaldo;
import br.usjt.caixaeletronico.view.Mensagem;
import br.usjt.caixaeletronico.view.MenuTemplate;
import br.usjt.caixaeletronico.view.PeriodoExtrato;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JFrame frame = new Mensagem"Relatorio Notas", Dispenser.getRelatorioNotas());
		JFrame frame = new PeriodoExtrato();
		JFrame frame1 = new ConsultarSaldo();
		JFrame frame2 = new ConsultarExtrato("Extrato de 7 dias");
		JFrame frame3 = new CadastroDebitoAutom();
		
		
		frame.setVisible(false);
		frame1.setVisible(false);
		frame2.setVisible(false);
		frame3.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

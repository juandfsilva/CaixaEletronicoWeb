package br.usjt.caixaeletronico;

import javax.swing.JFrame;

import br.usjt.caixaeletronico.model.Dispenser;
import br.usjt.caixaeletronico.view.Mensagem;
import br.usjt.caixaeletronico.view.MenuTemplate;
import br.usjt.caixaeletronico.view.PeriodoExtrato;

public class CaixaEletronico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JFrame frame = new Mensagem"Relatorio Notas", Dispenser.getRelatorioNotas());
		JFrame frame = new PeriodoExtrato();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

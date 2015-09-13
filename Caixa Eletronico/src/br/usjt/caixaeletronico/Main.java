package br.usjt.caixaeletronico;

import javax.swing.JFrame;

import br.usjt.caixaeletronico.model.Dispenser;
import br.usjt.caixaeletronico.view.CadTransfTemplate;
import br.usjt.caixaeletronico.view.CadastroDebitoAutom;
import br.usjt.caixaeletronico.view.ConsultarExtrato;
import br.usjt.caixaeletronico.view.ConsultarSaldo;
import br.usjt.caixaeletronico.view.Mensagem;
import br.usjt.caixaeletronico.view.MenuTemplate;
import br.usjt.caixaeletronico.view.PeriodoExtrato;
import br.usjt.caixaeletronico.view.Saque;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame msg = new Mensagem("Relatorio Notas", Dispenser.getRelatorioNotas());
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

	}

}

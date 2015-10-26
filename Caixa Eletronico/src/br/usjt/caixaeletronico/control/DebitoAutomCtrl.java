package br.usjt.caixaeletronico.control;

import br.usjt.caixaeletronico.model.DebitoAutomatico;

public class DebitoAutomCtrl {
	DebitoAutomatico deb = new DebitoAutomatico();
	public void registra(int dia, int codOp, int codCli){
		deb.registra(dia, codOp, codCli);
	}
}

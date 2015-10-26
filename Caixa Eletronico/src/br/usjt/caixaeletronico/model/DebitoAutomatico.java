package br.usjt.caixaeletronico.model;

public class DebitoAutomatico {

	public void registra(int dia, int codOp, int codCli) {
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.DebitoAutom(codOp, codCli, dia);
	}
}

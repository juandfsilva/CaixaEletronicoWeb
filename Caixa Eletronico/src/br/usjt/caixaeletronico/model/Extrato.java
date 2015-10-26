package br.usjt.caixaeletronico.model;

import java.util.ResourceBundle;

import br.usjt.caixaeletronico.control.Utils;

public class Extrato {
	public static String getExtrato(ResourceBundle resourceBundle, int days) {
		MovimentacaoDAO mov = new MovimentacaoDAO();
		return mov.getMovString(Utils.objConta);

	}
}

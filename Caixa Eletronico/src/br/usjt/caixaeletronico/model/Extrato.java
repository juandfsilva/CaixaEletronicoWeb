package br.usjt.caixaeletronico.model;

public class Extrato {

	public static String getExtrato(int days) {
		return  "Agencia 00hue\n"+
				"Conta huehue\n"+
				"Periodo dos ultimos "+days+"\n\n\n"+				
				"Total de Créditos ----------------------6.500,00\n"+
				"Depositos / TransferÃªncias -------------500,00\n"+
				"Salario e Proventos --------------------4.000,00\n"+
				"Restituicao do Imposto de Renda --------500,00\n"+
				"Outros Creditos ------------------------1.500,00\n"+
				"Total de Debitos -----------------------9.081,43\n"+
				"Saques Efetuados -----------------------50,00\n"+
				"Cheques Compensados --------------------600,50\n"+
				"Compras com Cartao de Debito -----------477,21\n"+
				"Pagamentos / Transferencias ------------5.853,78\n"+
				"CPMF -----------------------------------24,49\n"+
				"Outros Debitos -------------------------2.075,45\n"+
				"------------------------------------------------\n" +
				"Saldo de Conta Corrente ----------------690,63\n"+
				"Saldo de Conta Investimento em 28/02 ---1.600,35\n"+
				"Limite de Cheque Especial --------------4.500,00\n"+
				"Saldo Total ----------------------------6.790,98\n";

	}
}

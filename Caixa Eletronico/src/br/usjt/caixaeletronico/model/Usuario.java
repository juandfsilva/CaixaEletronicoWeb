package br.usjt.caixaeletronico.model;

public class Usuario {
	String conta, senha, agencia, codigoDeAcesso;
	public Usuario(String agencia, String conta, String senha) {
		this.agencia = agencia;
		this.conta = conta;
		this.senha = senha;
	}
	private Usuario() { }
	public String getConta() {
		return conta;
	}
	public String getSenha() {
		return senha;
	}
	public String getAgencia() {
		return agencia;
	}
	public String getCodigoDeAcesso() {
		return codigoDeAcesso;
	}
	@Override
	public String toString() {
		return agencia + ", " + conta;
	}
	public static Usuario[] converterLinhas(String[] linhas) {
		Usuario[] ret = new Usuario[linhas.length];
		for(int i = 0; i < ret.length; ++i)
		{
			String[] sep = linhas[i].split("[|]");
			ret[i] = new Usuario();
			ret[i].agencia = sep[0];
			ret[i].conta = sep[1];
			ret[i].senha = sep[2];
			if(sep.length > 3)
				ret[i].codigoDeAcesso = sep[3];
		}
		return ret;
	}
	//retorna 0 se forem iguais, -1 se deve vir antes, 1 se deve ir depois
	//compara a agencia numericamente, depois a conta.
	public int comparar(Usuario outro)
	{
		for(int i = 0, s = agencia.length(), s2 = outro.agencia.length(); i < s; ++i)
		{
			if(i >= s2) return 1;
			char c1 = agencia.charAt(i);
			char c2 = outro.agencia.charAt(i);
			if(c1 < c2) return -1;
			if(c1 > c2) return 1;
		}
		for(int i = 0, s = conta.length(), s2 = outro.conta.length(); i < s; ++i)
		{
			if(i >= s2) return 1;
			char c1 = conta.charAt(i);
			char c2 = outro.conta.charAt(i);
			if(c1 < c2) return -1;
			if(c1 > c2) return 1;
		}
		return 0;
	}
	public int comparar(String agencia, String conta)
	{
		Usuario temporario = new Usuario();
		temporario.conta = conta;
		temporario.agencia = agencia;
		return comparar(temporario);
	}
}

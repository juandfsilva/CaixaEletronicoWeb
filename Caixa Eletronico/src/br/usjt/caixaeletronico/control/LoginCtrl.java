package br.usjt.caixaeletronico.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

import com.sun.xml.internal.bind.v2.TODO;

import br.usjt.caixaeletronico.model.ConnectionFactory;
import br.usjt.caixaeletronico.model.Conta;
import br.usjt.caixaeletronico.model.Usuario;
import br.usjt.caixaeletronico.view.Login;

public class LoginCtrl {
	Login loginView;

	public LoginCtrl(Login loginView) {
		this.loginView = loginView;
	}

	public boolean entrar(String agencia, String conta, String senha) {
		try {
			Path path = Paths.get("logins.txt");
			byte[] data = Files.readAllBytes(path);
			String decifrado = null;
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("chave.txt"));
				SecretKeySpec iSim = (SecretKeySpec) ois.readObject();

				ois.close();

				Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
				IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
				aescf.init(Cipher.DECRYPT_MODE, iSim, ivspec);
				decifrado = new String(aescf.doFinal(data));
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Falha ao ler arquivo criptografado.\n" + e.toString());
			}
			String[] linhas = decifrado.split("\n");
			Usuario[] users = Usuario.converterLinhas(linhas);
			Usuario user = buscar(users, agencia, conta);
			if (user == null) {
				JOptionPane.showMessageDialog(null, "Usuario não existente");
			}
			if (user.getSenha().equals(senha)) {
				Utils.objConta.setAgencia(Integer.parseInt(agencia));
				Utils.objConta.setConta(Integer.parseInt(conta));
				Utils.objConta.setSaldo(Utils.objConta.getSaldo());
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Senha incorreta!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Usuario buscar(Usuario[] users, String agencia, String conta) {
		Usuario ret = null;
		int ini = 0, fim = users.length - 1;
		while (ini <= fim) {
			int i = (ini + fim) / 2;
			int comp = users[i].comparar(agencia, conta);
			if (comp < 0) // users[i] é menor que o procurado
			{
				ini = i + 1;
			} else if (comp > 0) // users[i] é maior que o procurado
			{
				fim = i - 1;
			} else if (comp == 0)
				return users[i]; // é igual
		}

		return ret;
	}

}

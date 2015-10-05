package br.usjt.caixaeletronico.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import br.usjt.caixaeletronico.model.ConnectionFactory;

import br.usjt.caixaeletronico.model.Usuario;

public class CriaUsuarios extends JFrame {
	JList list;
	ArrayList<Usuario> data;
	ConnectionFactory fac;
	class ModeloListaUsuarios extends AbstractListModel<Usuario> {
		@Override
		public Usuario getElementAt(int v) {
			return data.get(v);
		}

		@Override
		public int getSize() {
			return data.size();
		}
		public void update() {
			fireContentsChanged(this, 0, getSize()-1);
		}
	}
	public CriaUsuarios() {
		super("Cria usuarios");
		getContentPane().setLayout(new FlowLayout());
		data = new ArrayList<Usuario>();
		le();
		final ModeloListaUsuarios model = new ModeloListaUsuarios();  
		list = new JList<Usuario>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setPreferredSize(new Dimension(400, 800));
		list.setVisibleRowCount(-1);
		add(list);
		JButton b = new JButton("Adicionar");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String agencia = JOptionPane.showInputDialog(null,
						"Digite a agência no formato 000000(6digitos)");
				String conta = JOptionPane.showInputDialog(null,
						"Digite a conta no formato 0000000(7digitos)");
				String senha = JOptionPane.showInputDialog(null,
						"Digite uma senha");
				Usuario usr = new Usuario(agencia, conta, senha);
				int index = 0;
				// procura lugar onde deve ficar na lista
				for (int i = 0, s = data.size(); i < s; ++i) {
					if (data.get(i).comparar(usr) > 0) {
						index = i;
						break;
					}
				}
				data.add(index, usr);
				model.update();
			}
		});
		add(b);
		b = new JButton("Salvar");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ordena a lista pra ter certeza que está ordenada, depois
				// salva ela no arquivo de texto encriptografado
				ordena();
				salva();
			}
		});
		add(b);

		b = new JButton("Conecta");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fac = new ConnectionFactory();
			}
		});
		add(b);
		
		b = new JButton("fecha");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fac.closeFactory();
			}
		});
		add(b);
		
		setSize(800, 600);
	}

	void ordena() {

	}

	void le() {
		Path caminhoLogins = Paths.get("logins.txt");
		if (!Files.exists(caminhoLogins))
			return;
		// se nao existir nenhum arquivo de logins, comece do zero.
		Path caminhoChave = Paths.get("chave.txt");
		byte[] arquivo = null;
		try {
			arquivo = Files.readAllBytes(caminhoLogins);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		String arquivoDecifrado;
		if (Files.exists(caminhoChave)) {
			try {
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(caminhoChave.toFile()));
				SecretKeySpec iSim = (SecretKeySpec) ois.readObject();

				ois.close();

				Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
				IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
				aescf.init(Cipher.DECRYPT_MODE, iSim, ivspec);
				arquivoDecifrado = new String(aescf.doFinal(arquivo));
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"Falha ao ler arquivo criptografado.\n" + e.toString());
				return;
			}
		} else {
			// chave nao existe, le o arquivo diretamente
			arquivoDecifrado = new String(arquivo);
		}
		String[] linhas = arquivoDecifrado.split("\n");
		Usuario[] users = Usuario.converterLinhas(linhas);
		for(int i = 0, s = users.length; i < s; ++i) {
			data.add(users[i]);
		}
	}

	void salva() {
		Path caminhoChave = Paths.get("chave.txt");
		SecretKey sk;
		if (!Files.exists(caminhoChave)) {
			// chave ainda não existe, criaremos uma
			try {
				KeyGenerator kg = KeyGenerator.getInstance("AES");
				kg.init(128);
				sk = kg.generateKey();
				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(caminhoChave.toFile()));
				oos.writeObject(sk);
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(
						null,
						"Falha ao criar a chave criptográfica.\n"
								+ e.toString());
				return;
			}
			JOptionPane.showMessageDialog(null,
					"Nova chave criptográfica gerada com sucesso!");
		} else {
			// chave já existe, vamos ler.
			try {
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(caminhoChave.toFile()));
				sk = (SecretKey) ois.readObject();
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"Falha ao ler a chave criptográfica.\n" + e.toString());
				return;
			}
		}
		byte[] chave = sk.getEncoded();

		StringBuilder textoBuilder = new StringBuilder();
		for (int i = 0, s = data.size(); i < s; ++i) {
			Usuario usr = data.get(i);
			textoBuilder.append(usr.getAgencia());
			textoBuilder.append('|');
			textoBuilder.append(usr.getConta());
			textoBuilder.append('|');
			textoBuilder.append(usr.getSenha());
			textoBuilder.append('|');
			String cda = usr.getCodigoDeAcesso();
			if (cda != null)
				textoBuilder.append(cda);
			if (i - 1 < s)
				textoBuilder.append('\n');
		}
		String textoFinal = textoBuilder.toString();
		byte[] textoCifrado = null;
		try {
			Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
			aescf.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"),
					ivspec);
			textoCifrado = aescf.doFinal(textoFinal.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Falha ao criptografar dados.\n" + e.toString());
			return;
		}
		try {
			FileOutputStream fos = new FileOutputStream("logins.txt");
			fos.write(textoCifrado);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha ao escrever arquivo.\n"
					+ e.toString());
			return;
		}
		JOptionPane.showMessageDialog(null, "Arquivo escrito com sucesso!");
	}
}

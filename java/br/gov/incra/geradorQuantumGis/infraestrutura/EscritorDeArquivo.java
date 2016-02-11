package br.gov.incra.geradorQuantumGis.infraestrutura;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class EscritorDeArquivo<T> {

	private static final String CAMPO_VAZIO = "-";
	private static final String SEPARADOR_DE_COLUNA = ";";
	private static final String SEPARADOR_DE_LINHA = System.lineSeparator();

	private Nomeador nomeador;
	private StringBuilder linhas;

	public EscritorDeArquivo(Nomeador nomeador) {
		this.nomeador = nomeador;
		this.linhas = new StringBuilder();
	}

	public void salvar(List<T> elementos) {
		try {
			new File(nomeador.obterDiretorio()).mkdirs();
			for (T elemento : elementos) {
				adicionarElemento(elemento);
			}
			byte[] conteudo = linhas.toString().getBytes();
			Path arquivo = new File(nomeador.obterNome()).toPath();
			Files.write(arquivo, conteudo);
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}
	}

	protected void adicionarCampo(String campo) {
		linhas.append(obterCampoSeguro(campo));
		linhas.append(SEPARADOR_DE_COLUNA);
	}

	protected void adicionarCampo() {
		linhas.append(CAMPO_VAZIO);
		linhas.append(SEPARADOR_DE_COLUNA);
	}

	protected void finalizarLinha(String campo) {
		linhas.append(obterCampoSeguro(campo));
		linhas.append(SEPARADOR_DE_LINHA);
	}

	protected void finalizarLinha() {
		linhas.append(CAMPO_VAZIO);
		linhas.append(SEPARADOR_DE_LINHA);
	}

	private String obterCampoSeguro(String campo) {
		return campo.replaceAll(SEPARADOR_DE_COLUNA, "");
	}

	protected abstract void adicionarElemento(T elemento);

}

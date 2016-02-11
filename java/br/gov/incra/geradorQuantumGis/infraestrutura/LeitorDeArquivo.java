package br.gov.incra.geradorQuantumGis.infraestrutura;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public abstract class LeitorDeArquivo<T> {

	private static final String SEPARADOR_DE_COLUNA = ";";

	private Nomeador nomeador;
	private List<T> linhas;

	public LeitorDeArquivo(Nomeador nomeador) {
		this.nomeador = nomeador;
		this.linhas = new LinkedList<>();
	}

	public List<T> carregar() {
		try {
			new File(nomeador.obterDiretorio()).mkdirs();
			Path arquivo = new File(nomeador.obterNome()).toPath();
			List<String> elementos = Files.readAllLines(arquivo);
			for (String elemento : elementos) {
				String[] colunas = elemento.split(SEPARADOR_DE_COLUNA);
				linhas.add(receberElemento(colunas));
			}
			return linhas;
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}
		return null;
	}

	protected abstract T receberElemento(String... colunas);

}

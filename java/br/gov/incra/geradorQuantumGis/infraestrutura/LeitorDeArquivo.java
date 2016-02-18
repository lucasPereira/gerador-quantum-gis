package br.gov.incra.geradorQuantumGis.infraestrutura;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class LeitorDeArquivo<T> {

	private static final String SEPARADOR_DE_COLUNA = ";";

	private Nomeador nomeador;
	private Integer quantidadeDeColunas;
	private List<T> linhas;
	private List<String> linhasProblematicas;

	public LeitorDeArquivo(Nomeador nomeador, Integer quantidadeDeColunas) {
		this.nomeador = nomeador;
		this.quantidadeDeColunas = quantidadeDeColunas;
		this.linhas = new LinkedList<>();
		this.linhasProblematicas = new LinkedList<>();
	}

	public List<T> carregar() {
		try {
			new File(nomeador.obterDiretorio()).mkdirs();
			Path arquivo = new File(nomeador.obterNome()).toPath();
			List<String> elementos = Files.readAllLines(arquivo);
			Iterator<String> iterador = elementos.iterator();
			if (iterador.hasNext()) {
				iterador.next();
				Integer linhaAtual = 0;
				while (iterador.hasNext()) {
					linhaAtual++;
					String conteudoLinhaAtual = iterador.next();
					String[] colunas = conteudoLinhaAtual.split(SEPARADOR_DE_COLUNA);
					if (colunas.length != quantidadeDeColunas) {
						linhasProblematicas.add(String.format("%d: %s", linhaAtual, conteudoLinhaAtual));
					} else {
						linhas.add(receberElemento(colunas));
					}
				}
			}
			System.out.println(linhasProblematicas.size());
			for (String linha : linhasProblematicas) {
				System.out.println(linha);
			}
			return linhas;
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}
		return null;
	}

	protected abstract T receberElemento(String... colunas);

}

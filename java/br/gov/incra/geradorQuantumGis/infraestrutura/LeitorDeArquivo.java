package br.gov.incra.geradorQuantumGis.infraestrutura;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jopendocument.dom.spreadsheet.Range;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public abstract class LeitorDeArquivo<T> {

	private String nomeArquivo;
	private Integer indiceAba;

	public LeitorDeArquivo(String nomeArquivo) {
		this(nomeArquivo, 0);
	}

	public LeitorDeArquivo(String nomeArquivo, Integer indiceAba) {
		this.nomeArquivo = nomeArquivo;
		this.indiceAba = indiceAba;
	}

	public List<T> carregar() throws IOException {
		File arquivo = new File(nomeArquivo);
		SpreadSheet planilha = SpreadSheet.createFromFile(arquivo);
		Sheet aba = planilha.getSheet(indiceAba);
		Range limites = aba.getUsedRange();
		Point pontoUltimaCelula = limites.getEndPoint();
		Integer ultimaLinha = (int) pontoUltimaCelula.getY();
		Integer ultimaColuna = (int) pontoUltimaCelula.getX();
		Integer quantidadeDeLinhas = ultimaLinha + 1;
		Integer quantidadeDeColunas = ultimaColuna + 1;
		List<T> registros = new ArrayList<>(quantidadeDeLinhas);
		List<String> celulas = new ArrayList<>(quantidadeDeColunas);
		for (Integer linhaAtual = 1; linhaAtual <= ultimaLinha; linhaAtual++) {
			for (Integer colunaAtual = 0; colunaAtual <= ultimaColuna; colunaAtual++) {
				String celula = aba.getImmutableCellAt(colunaAtual, linhaAtual).getTextValue();
				celulas.add(celula);
			}
			T registro = criarRegistro(celulas);
			registros.add(registro);
			celulas.clear();
		}
		return registros;
	}

	protected abstract T criarRegistro(List<String> celulas);

}

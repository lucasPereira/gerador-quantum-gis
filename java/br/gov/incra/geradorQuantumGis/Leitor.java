package br.gov.incra.geradorQuantumGis;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jopendocument.dom.spreadsheet.Range;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class Leitor {

	public void ler(Transformador transformador, Iterador iterador) throws IOException {
		System.out.println(String.format("Carregando planilha: %s.", transformador.obterNomePlanilha()));
		File arquivo = new File(transformador.obterNomePlanilha());
		SpreadSheet planilha = SpreadSheet.createFromFile(arquivo);
		Sheet aba = planilha.getFirstSheet();
		System.gc();
		System.out.println(String.format("Planilha carregada: %s.", transformador.obterNomePlanilha()));

		System.out.println(String.format("Preparando iteração: %s.", transformador.obterNomePlanilha()));
		Range limites = aba.getUsedRange();
		Point pontoUltimaCelula = limites.getEndPoint();
		Integer ultimaLinha = (int) pontoUltimaCelula.getY();
		Integer ultimaColuna = (int) pontoUltimaCelula.getX();
		Integer quantidadeDeLinhas = ultimaLinha + 1;
		Integer quantidadeDeColunas = ultimaColuna + 1;
		iterador.preparar(quantidadeDeLinhas, quantidadeDeColunas);
		List<String> celulas = new ArrayList<>(quantidadeDeColunas);
		System.gc();
		System.out.println(String.format("Iteração preparada: %s.", transformador.obterNomePlanilha()));

		System.out.println(String.format("Realizando iteração: %s.", transformador.obterNomePlanilha()));
		for (Integer linhaAtual = 1; linhaAtual <= ultimaLinha; linhaAtual++) {
			for (Integer colunaAtual = 0; colunaAtual <= ultimaColuna; colunaAtual++) {
				String celula = aba.getImmutableCellAt(colunaAtual, linhaAtual).getTextValue();
				celulas.add(celula);
			}
			Imovel registro = transformador.criarRegistro(celulas);
			iterador.iterar(registro);
			celulas.clear();
		}
		System.gc();
		System.out.println(String.format("Iteração realizada: %s.", transformador.obterNomePlanilha()));
	}

}

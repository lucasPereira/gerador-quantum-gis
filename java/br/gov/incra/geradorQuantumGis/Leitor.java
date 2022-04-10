package br.gov.incra.geradorQuantumGis;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jopendocument.dom.spreadsheet.Range;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class Leitor {

	private Transformador transformador;
	private List<Iterador> iteradores;

	public Leitor(Transformador transformador, Iterador... iterador) {
		this.transformador = transformador;
		this.iteradores = Arrays.asList(iterador);
	}

	public void ler(String nomePlanilha) throws IOException  {
		System.out.println(String.format("Carregando planilha: %s.", nomePlanilha));
		File arquivo = new File(nomePlanilha);
		SpreadSheet planilha = SpreadSheet.createFromFile(arquivo);
		Sheet aba = planilha.getFirstSheet();
		System.gc();
		System.out.println(String.format("Planilha carregada: %s.", nomePlanilha));

		System.out.println(String.format("Preparando iteração: %s.", nomePlanilha));
		Range limites = aba.getUsedRange();
		Point pontoUltimaCelula = limites.getEndPoint();
		Integer ultimaLinha = (int) pontoUltimaCelula.getY();
		Integer ultimaColuna = (int) pontoUltimaCelula.getX();
		Integer quantidadeDeLinhas = ultimaLinha + 1;
		Integer quantidadeDeColunas = ultimaColuna + 1;
		preparar(quantidadeDeLinhas, quantidadeDeColunas);
		List<String> celulas = new ArrayList<>(quantidadeDeColunas);
		System.gc();
		System.out.println(String.format("Iteração preparada: %s.", nomePlanilha));

		System.out.println(String.format("Realizando iteração: %s.", nomePlanilha));
		for (Integer linhaAtual = 1; linhaAtual <= ultimaLinha; linhaAtual++) {
			for (Integer colunaAtual = 0; colunaAtual <= ultimaColuna; colunaAtual++) {
				String celula = aba.getImmutableCellAt(colunaAtual, linhaAtual).getTextValue();
				celulas.add(celula);
			}
			Imovel registro = transformador.criarRegistro(celulas);
			iterar(registro);
			celulas.clear();
		}
		System.gc();
		System.out.println(String.format("Iteração realizada: %s.", nomePlanilha));
	}

	private void iterar(Imovel registro) {
		for (Iterador iterador : iteradores) {
			iterador.iterar(registro);
		}
	}

	private void preparar(Integer quantidadeDeLinhas, Integer quantidadeDeColunas) {
		for (Iterador iterador : iteradores) {
			iterador.preparar(quantidadeDeLinhas, quantidadeDeColunas);
		}
	}

}

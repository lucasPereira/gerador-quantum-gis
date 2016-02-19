package br.gov.incra.geradorQuantumGis;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class Escritor {

	private SpreadSheet planilha;

	public Escritor() {
		planilha = SpreadSheet.create(0, 0, 0);
	}

	public void incluirAba(Transformador transformador, List<Imovel> imoveis) throws IOException {
		System.out.println(String.format("Incluindo aba: %s.", transformador.obterNomeAba()));
		Sheet aba = planilha.addSheet(transformador.obterNomeAba());
		String[] colunasCabecalho = transformador.obterColunas();
		Integer quantidadeLinhas = imoveis.size();
		Integer quantidadeColunas = colunasCabecalho.length;
		aba.ensureRowCount(quantidadeLinhas + 1);
		aba.ensureColumnCount(quantidadeColunas);
		for (Integer indiceLinha = 0; indiceLinha < 1; indiceLinha++) {
			for (Integer indiceColuna = 0; indiceColuna < quantidadeColunas; indiceColuna++) {
				String valorCelula = colunasCabecalho[indiceColuna];
				MutableCell<SpreadSheet> celula = aba.getCellAt(indiceColuna, indiceLinha);
				celula.setValue(valorCelula);
			}
		}
		for (Integer indiceLinha = 1; indiceLinha < quantidadeLinhas; indiceLinha++) {
			String[] colunasRegistro = imoveis.get(indiceLinha - 1).comoRegistro();
			for (Integer indiceColuna = 0; indiceColuna < quantidadeColunas; indiceColuna++) {
				String varloCelula = colunasRegistro[indiceColuna];
				MutableCell<SpreadSheet> celula = aba.getCellAt(indiceColuna, indiceLinha);
				celula.setValue(varloCelula);
			}
		}
		System.gc();
		System.out.println(String.format("Aba incluida: %s.", transformador.obterNomeAba()));
	}

	public void escrever(String nomeArquivo) throws IOException {
		System.out.println(String.format("Escrevendo arquivo: %s.", nomeArquivo));
		File arquivo = new File(nomeArquivo);
		planilha.saveAs(arquivo);
		System.gc();
		System.out.println(String.format("Arquivo escrito: %s.", nomeArquivo));
	}

}

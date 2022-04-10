package br.gov.incra.geradorQuantumGis;

import java.util.List;
import java.util.Map;

public class IteradorCombinadorPorDocumentoProprietario implements Iterador {

	private Map<String, Imovel> estrutura;
	private List<Imovel> resultados;

	public IteradorCombinadorPorDocumentoProprietario(Map<String, Imovel> estrutura, List<Imovel> resultados) {
		this.estrutura = estrutura;
		this.resultados = resultados;
	}

	@Override
	public void preparar(Integer quantidadeDeLinhas, Integer quantidadeDeColunas) {}

	@Override
	public void iterar(Imovel registro) {
		if (estrutura.containsKey(registro.getDocumentoProprietario())) {
			resultados.add(registro);
		}
	}

}

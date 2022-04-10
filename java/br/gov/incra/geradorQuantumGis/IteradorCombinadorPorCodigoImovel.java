package br.gov.incra.geradorQuantumGis;

import java.util.List;
import java.util.Map;

public class IteradorCombinadorPorCodigoImovel implements Iterador {

	private Map<String, Imovel> estrutura;
	private List<Imovel> resultados;

	public IteradorCombinadorPorCodigoImovel(Map<String, Imovel> estrutura, List<Imovel> resultados) {
		this.estrutura = estrutura;
		this.resultados = resultados;
	}

	@Override
	public void preparar(Integer quantidadeDeLinhas, Integer quantidadeDeColunas) {}

	@Override
	public void iterar(Imovel registro) {
		System.out.println(registro.getCodigoSncrImovel());
		if (estrutura.containsKey(registro.getCodigoSncrImovel())) {
			resultados.add(registro);
		}
	}

}

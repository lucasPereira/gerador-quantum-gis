package br.gov.incra.geradorQuantumGis;

import java.util.Map;

public class IteradorBuscadorEmEstrutura implements Iterador {

	private Map<String, Imovel> estrutura;

	public IteradorBuscadorEmEstrutura(Map<String, Imovel> estrutura) {
		this.estrutura = estrutura;
	}

	@Override
	public void preparar(Integer quantidadeDeLinhas, Integer quantidadeDeColunas) {}

	@Override
	public void iterar(Imovel registro) {
		if (estrutura.containsKey(registro.getCodigoSncrImovel())) {
			System.out.println("Achou " + registro.getCodigoSncrImovel());
		}
	}

}

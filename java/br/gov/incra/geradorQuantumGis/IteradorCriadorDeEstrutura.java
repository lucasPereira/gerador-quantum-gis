package br.gov.incra.geradorQuantumGis;

import java.util.HashMap;
import java.util.Map;

public class IteradorCriadorDeEstrutura implements Iterador {

	private Map<String, Imovel> registros;

	@Override
	public void preparar(Integer quantidadeDeLinhas, Integer quantidadeDeColunas) {
		registros = new HashMap<>(quantidadeDeLinhas);
	}

	@Override
	public void iterar(Imovel registro) {
		String codigo = registro.getCodigoSncrImovel();
		if (codigo != null && !codigo.isEmpty()) {
			registros.put(codigo, registro);
		}
	}

	public Map<String, Imovel> obterEstruturaDeBusca() {
		return registros;
	}

}

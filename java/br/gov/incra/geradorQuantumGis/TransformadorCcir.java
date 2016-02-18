package br.gov.incra.geradorQuantumGis;

import java.util.List;

public class TransformadorCcir implements Transformador {

	@Override
	public String obterNomePlanilha() {
		return "ods/ccir.ods";
	}

	@Override
	public ImovelCcir criarRegistro(List<String> celulas) {
		ImovelCcir imovel = new ImovelCcir();
		imovel.setCodigoSncrImovel(celulas.get(1));
		return imovel;
	}

}

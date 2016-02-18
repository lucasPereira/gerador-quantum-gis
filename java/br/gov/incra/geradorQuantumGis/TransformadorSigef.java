package br.gov.incra.geradorQuantumGis;

import java.util.List;

public class TransformadorSigef implements Transformador {

	@Override
	public String obterNomePlanilha() {
		return "ods/sigef.ods";
	}

	@Override
	public ImovelSigef criarRegistro(List<String> celulas) {
		ImovelSigef imovel = new ImovelSigef();
		imovel.setCodigoSncrImovel(celulas.get(6));
		return imovel;
	}

}

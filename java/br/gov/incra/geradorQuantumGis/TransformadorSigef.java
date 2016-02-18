package br.gov.incra.geradorQuantumGis;

import java.util.List;

public class TransformadorSigef implements Transformador {

	private Integer parte;

	public TransformadorSigef(Integer indice) {
		this.parte = indice;
	}

	@Override
	public String obterNomePlanilha() {
		return String.format("ods/sigef%d.ods", parte);
	}

	@Override
	public ImovelSigef criarRegistro(List<String> celulas) {
		ImovelSigef imovel = new ImovelSigef();
		imovel.setCodigoSncrImovel(celulas.get(6));
		return imovel;
	}

}

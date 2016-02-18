package br.gov.incra.geradorQuantumGis;

import java.util.List;

public class TransformadorSncr implements Transformador {

	@Override
	public String obterNomePlanilha() {
		return "ods/sncr.ods";
	}

	@Override
	public ImovelSncr criarRegistro(List<String> celulas) {
		ImovelSncr imovel = new ImovelSncr();
		imovel.setDocumentoProprietario(celulas.get(0));
		imovel.setNomeProprietario(celulas.get(1));
		imovel.setDividaProprietario(celulas.get(2));
		imovel.setCodigoSncrImovel(celulas.get(3));
		imovel.setNomeImovel(celulas.get(4));
		imovel.setAreaImovel(celulas.get(5));
		imovel.setCidadeImovel(celulas.get(6));
		imovel.setEstadoImovel(celulas.get(7));
		return imovel;
	}

}

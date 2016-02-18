package br.gov.incra.geradorQuantumGis.dominio;

import java.util.List;

import br.gov.incra.geradorQuantumGis.infraestrutura.LeitorDeArquivo;

public class LeitorImovelSncr extends LeitorDeArquivo<ImovelSncr> {

	public LeitorImovelSncr() {
		super("ods/imoveisDeDevedoresDaReceitaAcimaDeDezMilhoes.ods", 0);
	}

	@Override
	protected ImovelSncr criarRegistro(List<String> celulas) {
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

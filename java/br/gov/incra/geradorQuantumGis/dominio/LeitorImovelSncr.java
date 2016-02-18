package br.gov.incra.geradorQuantumGis.dominio;

import br.gov.incra.geradorQuantumGis.infraestrutura.LeitorDeArquivo;
import br.gov.incra.geradorQuantumGis.infraestrutura.Nomeador;

public class LeitorImovelSncr extends LeitorDeArquivo<ImovelSncr> {

	public LeitorImovelSncr(Nomeador nomeador) {
		super(nomeador, 8);
	}

	@Override
	protected ImovelSncr receberElemento(String... colunas) {
		ImovelSncr imovel = new ImovelSncr();
		imovel.setDocumentoProprietario(colunas[0]);
		imovel.setNomeProprietario(colunas[1]);
		imovel.setDividaProprietario(colunas[2]);
		imovel.setCodigoSncrImovel(colunas[3]);
		imovel.setNomeImovel(colunas[4]);
		imovel.setAreaImovel(colunas[5]);
		imovel.setCidadeImovel(colunas[6]);
		imovel.setEstadoImovel(colunas[7]);
		return imovel;
	}

}

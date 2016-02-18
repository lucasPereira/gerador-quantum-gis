package br.gov.incra.geradorQuantumGis.dominio;

import br.gov.incra.geradorQuantumGis.infraestrutura.LeitorDeArquivo;
import br.gov.incra.geradorQuantumGis.infraestrutura.Nomeador;

public class LeitorImovelSigef extends LeitorDeArquivo<ImovelSigef> {

	public LeitorImovelSigef(Nomeador nomeador) {
		super(nomeador, 25);
	}

	@Override
	protected ImovelSigef receberElemento(String... colunas) {
		ImovelSigef imovel = new ImovelSigef();
		imovel.setCodigoSncrImovel(colunas[6]);
		return imovel;
	}

}
